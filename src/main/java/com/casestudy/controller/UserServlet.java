package com.casestudy.controller;

import com.casestudy.model.Role;
import com.casestudy.model.User;
import com.casestudy.service.comment.CommentService;
import com.casestudy.service.comment.ICommentService;
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
            List<User> userList = (List<User>)session.getAttribute("userList");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);

        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        request.setAttribute("user",user);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/createUser.jsp");
        String fullName = request.getParameter("fullName");
        String introduction = request.getParameter("introduction");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        while (userService.checkUserName(username)){

            request.setAttribute("message","User Name has exists!");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user  = new User(fullName,introduction,username,password);
        request.setAttribute("successMessage","Sign Up Success!");
        try {
            userService.insert(user);
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
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
            request.setAttribute("message", "User name or password is wrong!");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String fullName = request.getParameter("fullName");
        String introduction = request.getParameter("introduction");
        String username = user.getUserName();
        String password = request.getParameter("password");
        Role role = roleService.findById(1);
        User user1 = new User(id,fullName,introduction,username,password,role);

        try {
            userService.update(user1);
            session.setAttribute("user",user1);
            request.setAttribute("message","User was updated!");
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }
}
