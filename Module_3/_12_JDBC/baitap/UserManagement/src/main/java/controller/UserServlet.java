package controller;

import model.bean.User;
import model.service.Impl.UserServiceImpl;
import model.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "controller.UserServlet", value = "/Users")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateUserForm(request, response);
                break;

            case "edit":
                showEditUserForm(request, response);
                break;
            case "findByCountry":
                showfindByCountryForm(request, response);
                break;
            default:
                showUserList(request,response);
                // hien thi danh sách
        }
    }



    private void showfindByCountryForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/findByCountry.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditUserForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user",userService.selectUser(id));
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userService.deleteUser(id);
            request.setAttribute("userList", userService.selectUsers());
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteUserForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateUserForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("userList",userService.selectUsers());
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
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
                createUser(request, response);
                break;
            case "edit":
                updateUser(request,response);
                break;
            case "findByCountry":
                findByCountry(request, response);
                break;
            case "sort":
                sortUserList(request, response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            default:
                showUserList(request,response);
                // hien thi danh sách
        }
    }

    private void sortUserList(HttpServletRequest request, HttpServletResponse response) {
        String sort = request.getParameter("sort");
        List<User> userList = userService.selectUsers(sort);
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByCountry(HttpServletRequest request, HttpServletResponse response) {
            int result = 0;
            String country = request.getParameter("country");
            List<User> userList = userService.findByCountry(country);
            if ( userList != null) {
                result = userList.size();
            }
            request.setAttribute("userList", userList);
            request.setAttribute("result",result);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        try {
            userService.updDateUser(user);
            request.setAttribute("userList", userService.selectUsers());
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name, email, country);
        try {
            userService.insertUser(user);
            request.setAttribute("userList",userService.selectUsers());
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
