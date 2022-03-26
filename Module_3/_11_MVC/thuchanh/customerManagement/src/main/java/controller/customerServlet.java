package controller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.CustomerServiceImpl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllerServlet", value = "/customers")
public class customerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                showCreateCustomerForm(request, response);
                break;
            case "edit":
                showEditCustomerForm(request, response);
                break;
            case "delete":
                showDeleteCustomerForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Customer customer = this.customerService.FindById(id);
        request.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher;
        if(customer == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            requestDispatcher = request.getRequestDispatcher("view/customer/view.jsp");
        }

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));

        Customer customer = this.customerService.FindById(id);
        request.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher;
        if( customer == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            requestDispatcher = request.getRequestDispatcher("view/customer/delete.jsp");
        }

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));

        Customer customer = this.customerService.FindById(id);

        request.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher;
        if( customer == null) {
           requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        }

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customers", customers);

        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.FindById(id);
        RequestDispatcher requestDispatcher;
        if(customer == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            this.customerService.remove(id);
            try {
                response.sendRedirect("/customers");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = new Customer(id, name, email, address);

        this.customerService.update(id, customer);// update customer

        request.setAttribute("customer", customer);
        request.setAttribute("message", "Customer information was updated");

        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int)(Math.random()*1000);

        Customer customer = new Customer(id, name,email, address);
        this.customerService.save(customer);

        request.setAttribute("message", "New customer was created.");

        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
