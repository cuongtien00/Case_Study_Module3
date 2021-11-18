package com.casestudy.controller;

import com.casestudy.model.LikePost;
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
import java.util.List;

@WebServlet(name = "LikePostServlet", value = "/likePost")
public class LikePostServlet extends HttpServlet {
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
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                break;
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
                createLike(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                break;
        }
    }

    private void createLike(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        int postId = Integer.parseInt(request.getParameter("id"));
        Post post = postService.findById(postId);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userLogin");
        LikePost likePost = new LikePost(post,user);
        try {
            likePostService.insert(likePost);
            request.setAttribute("user",user);
            request.setAttribute("postList",postService.findAll());
            request.setAttribute("commentList",commentService.findAll());
            request.setAttribute("likePostList",likePostService.findAllByPostId(postId));
            dispatcher.forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
