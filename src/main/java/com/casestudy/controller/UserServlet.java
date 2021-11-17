package com.casestudy.controller;

import com.casestudy.model.User;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/login")
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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "homePageUser":
                showUserPage(request, response);
                break;
            case "homePageAdmin":
                showAdminPage(request, response);
                break;
            case "signup":
                showViewCreateUser(request,response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "view":
                showView(request, response);
                break;
            default:
                homePage(request, response);
                break;
        }

    }

    private void showViewCreateUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/createUser.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAdminPage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/homePageAdmin.jsp");
        HttpSession session = request.getSession(false);
        if (session != null) {
            List<User> userList = (List<User>) session.getAttribute("userList");
            request.setAttribute("userList", userList);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showUserPage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/homePageUser.jsp");
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            request.setAttribute("user", user);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "signup":
                signup(request,response);
                break;
            default:
//                login(request, response);
                break;
        }
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) {
        String fullName = request.getParameter("fullName");
        String introduction = request.getParameter("introduction");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        while (userService.checkUserName(username)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/createUser.jsp");
            request.setAttribute("message","Ten dang nhap da ton tai");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user  = new User(fullName,introduction,username,password);
        try {
            userService.insert(user);
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("index.jsp");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByIdPassword(username, password);
        List<User> userList = userService.findAll();
        if (user != null) {
            HttpSession session = request.getSession();
            if (user.getRole().getName().equals("admin")) {
                session.setAttribute("userList", userList);
                try {
                    response.sendRedirect("/login?action=homePageAdmin");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                session.setAttribute("user", user);
                try {
                    response.sendRedirect("/login?action=homePageUser");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            request.setAttribute("message", "Ten dang nhap hoac mat khau khong ton tai");
            try {
                dispatcher2.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }
}
