package controller;

import model.bean.Customer;
import model.bean.LoaiKhach;
import model.service.CustomerService;
import model.service.CustomerTypeService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.CustomerTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


@WebServlet(name = "CustomerServlet", value = "/Customer")
public class CustomerServlet extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomerForm(request, response);
                break;
            case "findByAll":
                findAllCustomer(request, response);
                break;
            case "edit":
                showEditCustomerForm(request, response);
                break;
            default:
                showCustomerManagement(request, response);// back to homepage.
                break;
        }
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.FindById(id);
        List<LoaiKhach> customerTypeList = customerTypeService.findAll();

        request.setAttribute("customer", customer);
        request.setAttribute("customerTypeList", customerTypeList);

        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<LoaiKhach> customerTypeList = customerTypeService.findAll();
        List<Customer> customerList= customerService.findAll();

        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
            List<LoaiKhach> customerTypeList = customerTypeService.findAll();
            request.setAttribute("customerTypeList",customerTypeList);
        try {

            request.getRequestDispatcher("view/customer/createCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerManagement(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerTypeList" , customerTypeService.findAll());
        String content =
                "    <h4 class=\" navbar \" >Customer management</h4>" +
                "   <form method=\"post\" action=\"/Customer?action=findByName\" class=\"form-inline my-2 my-lg-0\" style=\"padding: 0 8px\">\n" +
                "        <input name=\"name\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Enter customer name\" aria-label=\"Search\">\n" +
                "        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
                "    </form>\n" +
                "    <a href=\"/Customer?action=create\" class=\"list-group-item list-group-item-action\">\n" +
                "        Create new customer\n" +
                "    </a>\n" +
                "    <a href=\"/Customer?action=findByAll\" class=\"list-group-item list-group-item-action\">Show customer list</a>";
        request.setAttribute("content",content);
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                upDate(request, response);
                break;
            case "findByName":
                getListByName(request, response);
                break;
            default:
                break;
        }
    }

    private void getListByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = customerService.FindByName(name);
        request.setAttribute("customerTypeList", customerTypeService.findAll());
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void upDate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customerId"));
        int idLoaiKhach = Integer.parseInt(request.getParameter("idCustomerType"));
        String ten = request.getParameter("fullName");
        String ngaySinh = request.getParameter("birtday");
        boolean gioiTinh ;
        if(request.getParameter("gender").toLowerCase(Locale.ROOT).equals("nam")) {
            gioiTinh = true;
        }else  {
            gioiTinh = false;
        }
        int cmnd = Integer.parseInt(request.getParameter("idCard"));
        int soDienThoai = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("address");
        Customer customer = new Customer(idLoaiKhach, ten, ngaySinh, gioiTinh, cmnd, soDienThoai, email, diaChi);

        customerService.update(id, customer);
        request.setAttribute("customerList", customerService.findAll());
        request.setAttribute("customerTypeList", customerTypeService.findAll());
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(id);
        request.setAttribute("message", "Deleted!");

        request.setAttribute("customerList", customerService.findAll());
        request.setAttribute("customerTypeList", customerTypeService.findAll());
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idLoaiKhach = Integer.parseInt(request.getParameter("idCustomerType"));
        String ten = request.getParameter("fullName");
        String ngaySinh = request.getParameter("birtday");
        boolean gioiTinh ;
        if(request.getParameter("gender").toLowerCase(Locale.ROOT).equals("nam")) {
            gioiTinh = true;
        }else  {
            gioiTinh = false;
        }
        int cmnd = Integer.parseInt(request.getParameter("idCard"));
        int soDienThoai = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("address");

        Customer customer = new Customer(idLoaiKhach, ten, ngaySinh, gioiTinh, cmnd, soDienThoai, email, diaChi);
        customerService.save(customer);

        List<LoaiKhach> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("message","Successful new creation!");
        try {
            request.getRequestDispatcher("view/customer/createCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
