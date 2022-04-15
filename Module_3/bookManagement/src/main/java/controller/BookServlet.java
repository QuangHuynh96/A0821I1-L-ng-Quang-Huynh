package controller;

import model.bean.Auther;
import model.bean.Book;
import model.service.AutherService;
import model.service.BookService;
import model.service.impl.AutherServiceImpl;
import model.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/Book")
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();
    AutherService autherService = new AutherServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateBookForm(request, response);
                break;
            case "findByAll":
//                findByAll(request, response);
                break;
            case "contractCustomer":
//                contractCustomer(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "findByName":
                break;
            case "createContractDetail":
//                showCreateContractDetailForm(request, response);
                break;
            default:
                showBookList(request, response);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("book", bookService.findById(id));
        request.setAttribute("autherList", autherService.findAll());
        try {
            request.getRequestDispatcher("view/book/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateBookForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("autherList",autherService.findAll());
        try {
            request.getRequestDispatcher("view/book/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showBookList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("bookList",bookService.findAll());
        request.setAttribute("autherList",autherService.findAll());
        try {
            request.getRequestDispatcher("view/book/list.jsp").forward(request, response);
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
                createBook(request, response);
                break;
            case "delete":
                deleteBook(request,response);
                break;
            case "update":
                updateBook(request, response);
                break;
            case "search":
                searchBook(request, response);
                break;
            default:
                break;
        }
    }

    private void searchBook(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String autherName = request.getParameter("auther");

        request.setAttribute("bookList", bookService.search(name, autherName));
        request.setAttribute("autherList", autherService.findAll());
        try {
            request.getRequestDispatcher("view/book/list.jsp").forward(request , response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int idAuther = Integer.parseInt(request.getParameter("idAuther"));
        Book book = new Book(id, name, price, idAuther);
        List<String> messList = bookService.update(book);

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
        request.setAttribute("book", book);
        request.setAttribute("autherList", autherService.findAll());
        try {
            request.getRequestDispatcher("view/book/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.delete(id);
        request.setAttribute("bookList",bookService.findAll());
        request.setAttribute("autherList",autherService.findAll());
        try {
            request.getRequestDispatcher("view/book/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int idAuther = Integer.parseInt(request.getParameter("idAuther"));
        Book book  = new Book(name, price, idAuther);
        List<String> messList = bookService.add(book);

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
        request.setAttribute("book", book);
        request.setAttribute("autherList",autherService.findAll());
        try {
            request.getRequestDispatcher("view/book/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
