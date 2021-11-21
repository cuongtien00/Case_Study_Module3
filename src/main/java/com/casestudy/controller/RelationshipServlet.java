package com.casestudy.controller;

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

@WebServlet(name = "RelationshipServlet", value = "/relationship")
public class RelationshipServlet extends HttpServlet {
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
            case "accept":
                acceptRequest(request,response);
                break;
            case "cancel":
                cancelRequest(request,response);
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                break;
        }
    }

    private void cancelRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        relationshipService.cancelRequest(id);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("userLogin");
        request.setAttribute("user", user);
        request.setAttribute("postList", postService.findAll());
        request.setAttribute("commentList", commentService.findAll());
        request.setAttribute("relationshipList",relationshipService.findAllByUserId(user.getId()));
        request.setAttribute("likePostList",likePostService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        relationshipService.acceptRequest(id);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("userLogin");
        request.setAttribute("user", user);
        request.setAttribute("postList", postService.findAll());
        request.setAttribute("commentList", commentService.findAll());
        request.setAttribute("relationshipList",relationshipService.findAllByUserId(user.getId()));
        request.setAttribute("likePostList",likePostService.findAll());
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
}
