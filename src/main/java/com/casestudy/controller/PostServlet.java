package com.casestudy.controller;

import com.casestudy.model.Post;
import com.casestudy.model.User;
import com.casestudy.service.comment.CommentService;
import com.casestudy.service.likepost.LikePostService;
import com.casestudy.service.post.PostService;
import com.casestudy.service.relationship.RelationshipService;
import com.casestudy.service.role.RoleService;
import com.casestudy.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PostServlet", value = "/post")
public class PostServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final PostService postService = new PostService();
    private final RelationshipService relationshipService = new RelationshipService();
    private final RoleService roleService = new RoleService();
    private final CommentService commentService = new CommentService();
    private final LikePostService likePostService = new LikePostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deletePost(request, response);
                break;
            case "view":
                break;
            default:
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/create.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = postService.findById(id);
        request.setAttribute("post", post);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userLogin");
        try {
            postService.delete(id);
            request.setAttribute("postList", postService.findAll());
            request.setAttribute("user", user);
            request.setAttribute("commentList", commentService.findAll());
            request.setAttribute("relationshipList", relationshipService.findAllByUserId(user.getId()));
            request.setAttribute("likePostList",likePostService.findAll());
            dispatcher.forward(request, response);
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "edit":
                editPost(request, response);
                break;
            case "view":
                break;
            default:
                break;
        }
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher dispatcher = request.getRequestDispatcher("post/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        String tittle = request.getParameter("tittle");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userLogin");
        Post post = new Post(id, tittle, content, image, user);
        request.setAttribute("message", "Post was updated!");
        try {
            postService.update(post);
//            session.setAttribute("post",post);
            request.setAttribute("post", post);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        int userId = Integer.parseInt(request.getParameter("id"));
        String tittle = request.getParameter("tittle");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        HttpSession session = request.getSession();
        User user = userService.findById(userId);
        Post post = new Post(tittle, content, image, user);

//        session.setAttribute("post",post);
//        session.setAttribute("user",user);

//        session.getAttribute("user");
//        session.getAttribute("post");

        try {

            postService.insert(post);
//            Post newPost = new Post(postID,tittle,content,image,user);
//            session.setAttribute("post",newPost);
            request.setAttribute("user", user);
            request.setAttribute("postList", postService.findAll());
            request.setAttribute("commentList", commentService.findAll());
            request.setAttribute("relationshipList", relationshipService.findAllByUserId(user.getId()));
            request.setAttribute("likePostList",likePostService.findAll());

            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
