package controller;

import model.bean.Auther;
import model.service.AutherService;
import model.service.impl.AutherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AutherServlet", value = "/Auther")
public class AutherServlet extends HttpServlet {
    AutherService autherService = new AutherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateAutherForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            default:
                showAutherList(request, response);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("auther", autherService.findById(id));
        try {
            request.getRequestDispatcher("view/auther/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateAutherForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/auther/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAutherList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("autherList",autherService.findAll());
        try {
            request.getRequestDispatcher("view/auther/list.jsp").forward(request, response);
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
                createAuther(request, response);
                break;
            case "delete":
                deleteAuther(request,response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                searchAuther(request, response);
                break;
            default:
                break;
        }
    }

    private void searchAuther(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String nickName = request.getParameter("nickName");
        String address = request.getParameter("address");

        request.setAttribute("autherList", autherService.search(name, nickName,address));
        try {
            request.getRequestDispatcher("view/auther/list.jsp").forward(request , response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String nickName = request.getParameter("nickName");
        String address = request.getParameter("address");
        Auther auther = new Auther(id,name,nickName, address);
        List<String> messList = autherService.update(auther);

        boolean check =true;
        for (String mess: messList) {
            if (!mess.equals("")){
                check =false;
            }
        }
        String message = "update thanh cong";
        if (!check) {
            message = "update khong thanh cong";
        }
        request.setAttribute("message", message);
        request.setAttribute("messList", messList);
        request.setAttribute("auther", auther);
        try {
            request.getRequestDispatcher("view/auther/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteAuther(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        autherService.delete(id);
        request.setAttribute("autherList", autherService.findAll());
        try {
            request.getRequestDispatcher("view/auther/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAuther(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String nickName = request.getParameter("nickName");
        String address = request.getParameter("address");
        Auther auther = new Auther(name,nickName, address);
        List<String> messList = autherService.add(auther);

        boolean check =true;
        for (String mess: messList) {
            if (!mess.equals("")){
                check =false;
            }
        }
        String message = "Them moi thanh cong";
        if (!check) {
            message = "Them moi khong thanh cong";
        }

        request.setAttribute("message", message);
        request.setAttribute("messList", messList);
        request.setAttribute("auther", auther);
        try {
            request.getRequestDispatcher("view/auther/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
