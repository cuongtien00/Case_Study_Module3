package com.casestudy.controller;

import com.casestudy.model.Comment;
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

@WebServlet(name = "CommentServlet", value = "/comment")
public class CommentServlet extends HttpServlet {
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
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "view":
                break;
            default:
                break;
        }    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            commentService.delete(id);
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("userLogin");
            request.setAttribute("user",user);
            request.setAttribute("postList",postService.findAll());
            request.setAttribute("commentList",commentService.findAll());
            dispatcher.forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Comment comment = commentService.findById(id);
        request.setAttribute("comment",comment);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
                createComment(request,response);
                break;
            case "edit":
                editComment(request,response);
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                break;
        }
    }

    private void editComment(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Comment comment = commentService.findById(id);
        Post post = postService.findById(comment.getPost().getId());
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
            User user = (User)session.getAttribute("userLogin");
            Comment comment1 = new Comment(id,content,post,user);
            try {
                commentService.update(comment1);
                request.setAttribute("post",post);
                request.setAttribute("user",user);
                request.setAttribute("comment",comment1);
                dispatcher.forward(request,response);
            } catch (SQLException | ServletException | IOException e) {
                e.printStackTrace();
            }
    }

    private void createComment(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        int postId = Integer.parseInt(request.getParameter("id"));
        Post post = postService.findById(postId);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userLogin");
        String content = request.getParameter("content");
        Comment comment = new Comment(content,post,user);
       commentService.insert(comment);
        request.setAttribute("user",user);
        request.setAttribute("postList",postService.findAll());
        request.setAttribute("commentList",commentService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
