package controller;

import model.bean.ContractCustomerOder;
import model.bean.DichVuDiKem;
import model.bean.HopDong;
import model.bean.HopDongChiTiet;
import model.service.*;
import model.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/Contract")

public class ContractServlet extends HttpServlet {
    ContractCustomerOderService contractCustomerOderService = new ContracCustomerOderServiceImpl();
    ContractDetailService contractDetailService = new ContractDetailServiceImpl();
    ContractService contractService = new ContractServiceImpl();
    AccompaniedService accompaniedService = new AccompaniedServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    DichVuService dichVuService = new DichVuServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateContractForm(request, response);
                break;
            case "findByAll":
                findByAll(request, response);
                break;
            case "contractCustomer":
                contractCustomer(request, response);
                break;
            case "edit":
                break;
            case "findByName":
                break;
            case "createContractDetail":
                showCreateContractDetailForm(request, response);
                break;
            default:
                showContractManagement(request, response);
                break;
        }
    }

    private void contractCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("dichVuList",dichVuService.findAll());
        request.setAttribute("list", contractCustomerOderService.findAll());
        try {
            request.getRequestDispatcher("view/contractCustomerOder/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByAll(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contractList", contractService.findAll());
        request.setAttribute("employeeList", employeeService.findAll());
        request.setAttribute("customerList", customerService.findAll());
        request.setAttribute("serviceList", dichVuService.findAll());
        try {
            request.getRequestDispatcher("view/contract/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateContractDetailForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("contractList", contractService.findAll());
            request.setAttribute("accompaniedServiceList", accompaniedService.findAll());
            request.getRequestDispatcher("view/contractDetail/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateContractForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList" , employeeService.findAll());
        request.setAttribute("customerList", customerService.findAll());
        request.setAttribute("dichVuList", dichVuService.findAll());
        try {
            request.getRequestDispatcher("view/contract/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractManagement(HttpServletRequest request, HttpServletResponse response) {
        String content =
                "   <h4 class=\" navbar \" >Contract management</h4>" +
                "    <form method=\"post\" action=\"/Contract?action=findByName\" class=\"disable form-inline my-2 my-lg-0 list-group-item list-group-item-action disabled\" style=\"padding: 0 8px\">\n" +
                "        <input name=\"name\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Enter service name\" aria-label=\"Search\">\n" +
                "        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search (disabled)</button>\n" +
                "    </form>\n" +
                "    <a href=\"/Contract?action=create\" class=\"list-group-item list-group-item-action\">\n" +
                "        Create new contract \n" +
                "    </a>\n" +
                "    <a href=\"/Contract?action=findByAll\" class=\"list-group-item list-group-item-action \">Show contract list </a>" +
                "    <a href=\"/Contract?action=createContractDetail\" class=\"list-group-item list-group-item-action\"> Create new contract detail</a>";
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
                createContract(request, response);
                break;
            case "delete":
                deleteContract(request,response);
                break;
            case "edit":
//                editContract(request, response);
                break;
            case "createContractDetail":
                createContractDetail(request,response);
                break;
            case "findByName":
                break;
            default:
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int idHopDong = Integer.parseInt(request.getParameter("contract"));
        int idDichVuDiKem = Integer.parseInt(request.getParameter("service"));
        int soLuong = Integer.parseInt(request.getParameter("amount"));
        HopDongChiTiet hopDongChiTiet = new HopDongChiTiet(idHopDong, idDichVuDiKem, soLuong);
        boolean check = contractDetailService.save(hopDongChiTiet);
        String message;
        if(check) {
            message = "Successful new creation!";
        }else {
            message = "Fail new creation!";
        }
        request.setAttribute("message", message);
        try {
            request.setAttribute("contractList", contractService.findAll());
            request.setAttribute("accompaniedServiceList", accompaniedService.findAll());
            request.getRequestDispatcher("view/contractDetail/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        contractService.remove(id);
        request.setAttribute("contractList", contractService.findAll());
        request.setAttribute("employeeList", employeeService.findAll());
        request.setAttribute("customerList", customerService.findAll());
        request.setAttribute("serviceList", dichVuService.findAll());
        try {
            request.getRequestDispatcher("view/contract/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        int idNhanVien = Integer.parseInt(request.getParameter("employeeId"));
        int idKhachHang = Integer.parseInt(request.getParameter("customerId"));
        int idDichVu = Integer.parseInt(request.getParameter("serviceId"));
        String ngayLamHopDong = request.getParameter("startDay");
        String ngayKetThuc = request.getParameter("endDay");
        Double tienDatCoc = Double.parseDouble(request.getParameter("rentalCosts"));
        HopDong hopDong = new HopDong(idNhanVien, idKhachHang, idDichVu, ngayLamHopDong, ngayKetThuc, tienDatCoc);
        boolean check = contractService.save(hopDong);
        String message;
        if(check) {
            message = "Successful new creation!";
        }else {
            message = "Fail new creation!";
        }
        request.setAttribute("message", message);
        request.setAttribute("employeeList", employeeService.findAll());
        request.setAttribute("customerList", customerService.findAll());
        request.setAttribute("serviceList", dichVuService.findAll());
        try {
            request.getRequestDispatcher("view/contract/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
