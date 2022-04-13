package controller;

import model.bean.DichVu;
import model.service.DichVuService;
import model.service.RentalTypeBO;
import model.service.ServiceTypeBO;
import model.service.impl.DichVuServiceImpl;
import model.service.impl.RentalTypeBOImpl;
import model.service.impl.ServiceTypeBOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/Service")

public class ServiceServlet extends HttpServlet {
    RentalTypeBO rentalTypeBO = new RentalTypeBOImpl();
    ServiceTypeBO serviceTypeBO = new ServiceTypeBOImpl();
    DichVuService dichVuService = new DichVuServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateServiceForm(request, response);
                break;
            case "findByAll":
                findAllDichVu(request, response);
                break;
            case "edit":
                showEditServiceForm(request, response);
                break;
            default:
                showServiceManagement(request, response);// back to homepage.
                break;
        }
    }

    private void showEditServiceForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        DichVu dichVu = dichVuService.FindById(id);
        request.setAttribute("dichVu", dichVu);
        request.setAttribute("kieuThueList", rentalTypeBO.findAll());
        request.setAttribute("loaiDichVuList", serviceTypeBO.findAll());
        try {
            request.getRequestDispatcher("view/service/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAllDichVu(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("dichVuList", dichVuService.findAll());
        request.setAttribute("kieuThueList", rentalTypeBO.findAll());
        request.setAttribute("loaiDichVuList", serviceTypeBO.findAll());
        try {
            request.getRequestDispatcher("view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateServiceForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("kieuThueList", rentalTypeBO.findAll());
        request.setAttribute("loaiDichVuList", serviceTypeBO.findAll());
        try {
            request.getRequestDispatcher("view/service/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showServiceManagement(HttpServletRequest request, HttpServletResponse response) {
        String content ="    <h4 class=\" navbar \" >Service management</h4>" +
                        "    <form method=\"post\" action=\"/Service?action=findByName\" class=\"form-inline my-2 my-lg-0 list-group-item list-group-item-action \" style=\"padding: 0 8px\">\n" +
                        "        <input name=\"name\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Enter service name\" aria-label=\"Search\">\n" +
                        "        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search </button>\n" +
                        "    </form>\n" +
                        "    <a href=\"/Service?action=create\" class=\"list-group-item list-group-item-action\">\n" +
                        "        Create new service\n" +
                        "    </a>\n" +
                        "    <a href=\"/Service?action=findByAll\" class=\"list-group-item list-group-item-action \">Show service list</a>";
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
                createService(request, response);
                break;
            case "delete":
                deleteService(request, response);
                break;
            case "edit":
                editService(request,response);
                break;
            case "findByName":
                findByName(request, response);
                break;
            default:
                break;
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<DichVu> dichVuList = dichVuService.FindByName(name);
        request.setAttribute("dichVuList", dichVuList);
        request.setAttribute("kieuThueList", rentalTypeBO.findAll());
        request.setAttribute("loaiDichVuList", serviceTypeBO.findAll());
        try {
            request.getRequestDispatcher("view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("dichVuId"));
        String ten = request.getParameter("name");
        int idKieuThue = Integer.parseInt(request.getParameter("rentalType"));
        int idLoaiDichVu = Integer.parseInt(request.getParameter("serviceType"));
        int dienTich = Integer.parseInt(request.getParameter("area"));
        double chiPhiThue = Double.parseDouble(request.getParameter("rentalCosts"));
        int soNguoiToiDa = Integer.parseInt(request.getParameter("maximumMenber"));
        String tieuChuanPhong = request.getParameter("roomStandard");
        String moTaTienNghiKhac = request.getParameter("description");
        int dienTichHoBoi = Integer.parseInt(request.getParameter("poolArea"));
        int soTang = Integer.parseInt(request.getParameter("floors"));

        DichVu dichVu = new DichVu(idKieuThue, idLoaiDichVu, ten, dienTich, chiPhiThue, soNguoiToiDa, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang);
        dichVuService.update(id, dichVu);
        request.setAttribute("dichVuList", dichVuService.findAll());
        request.setAttribute("kieuThueList", rentalTypeBO.findAll());
        request.setAttribute("loaiDichVuList", serviceTypeBO.findAll());
        try {
            request.getRequestDispatcher("view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        dichVuService.remove(id);
        request.setAttribute("dichVuList", dichVuService.findAll());
        request.setAttribute("kieuThueList", rentalTypeBO.findAll());
        request.setAttribute("loaiDichVuList", serviceTypeBO.findAll());
        try {
            request.getRequestDispatcher("view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("name");
        int idKieuThue = Integer.parseInt(request.getParameter("rentalType"));
        int idLoaiDichVu = Integer.parseInt(request.getParameter("serviceType"));
        int dienTich = Integer.parseInt(request.getParameter("area"));
        double chiPhiThue = Double.parseDouble(request.getParameter("rentalCosts"));
        int soNguoiToiDa = Integer.parseInt(request.getParameter("maximumMenber"));
        String tieuChuanPhong = request.getParameter("roomStandard");
        String moTaTienNghiKhac = request.getParameter("description");
        int dienTichHoBoi = Integer.parseInt(request.getParameter("poolArea"));
        int soTang = Integer.parseInt(request.getParameter("floors"));

        DichVu dichVu = new DichVu(idKieuThue, idLoaiDichVu, ten, dienTich, chiPhiThue, soNguoiToiDa, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang);
        dichVuService.save(dichVu);
        request.setAttribute("message", "successfully added new");
        try {
            request.getRequestDispatcher("view/service/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
