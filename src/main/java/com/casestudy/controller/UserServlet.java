package com.casestudy.controller;

import com.casestudy.service.comment.CommentService;
import com.casestudy.service.comment.ICommentService;
import com.casestudy.service.likepost.LikePostService;
import com.casestudy.service.post.PostService;
import com.casestudy.service.relationship.RelationshipService;
import com.casestudy.service.role.RoleService;
import com.casestudy.service.user.UserService;

import javax.management.relation.Role;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final PostService postService = new PostService();
    private final RelationshipService relationshipService = new RelationshipService();
    private final RoleService roleService = new RoleService();
    private final CommentService commentService = new CommentService();
    private final LikePostService likePostService = new LikePostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "view":
                showView(request,response);
                break;
            default:
                homePage(request,response);
                break;
        }

    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }
}
