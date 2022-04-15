package controller;

import model.bean.BenhAn;
import model.service.BenhAnService;
import model.service.BenhNhanService;
import model.service.impl.BenhAnServiceimpl;
import model.service.impl.BenhNhanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BenhAnServlet", value = "/BenhAn")
public class BenhAnServlet extends HttpServlet {
    BenhAnService benhAnService = new BenhAnServiceimpl();
    BenhNhanService benhNhanService = new BenhNhanServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                showCreateAutherForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            default:
                showBenhAnList(request, response);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        BenhAn benhAn = benhAnService.findById(id);

        request.setAttribute("benhNhanList",benhNhanService.findAll());
        request.setAttribute("benhAn", benhAn);
        try {
            request.getRequestDispatcher("view/BenhAn/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showBenhAnList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("benhNhanList",benhNhanService.findAll());
        request.setAttribute("benhAnList",benhAnService.findAll());
        try {
            request.getRequestDispatcher("view/BenhAn/list.jsp").forward(request, response);
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
//                createContract(request, response);
                break;
            case "delete":
                deleteBenhAn(request,response);
                break;
            case "update":
                updateBenhAn(request, response);
                break;
            case "createContractDetail":
//                createContractDetail(request,response);
                break;
            case "findByName":
                break;
            default:
                break;
        }
    }

    private void updateBenhAn(HttpServletRequest request, HttpServletResponse response) {
        int idBenhAn = Integer.parseInt(request.getParameter("idBenhAn"));
        int idBenhNhan = Integer.parseInt(request.getParameter("idBenhNhan"));
        String ngayNhapVien = request.getParameter("gayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String lyDoNhapVien = request.getParameter("lyDoNhapVien");
        BenhAn benhAn = new BenhAn(idBenhAn, idBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        List<String> stringList = benhAnService.update(benhAn);
        boolean check =true;
        for (String mess: stringList) {
            if (!mess.equals("")){
                check =false;
            }
        }
        String message = "update thanh cong";
        if (!check) {
            message = "update khong thanh cong";
        }
        request.setAttribute("benhNhanList",benhNhanService.findAll());
        request.setAttribute("benhAn", benhAn);
        request.setAttribute("message", message);
        request.setAttribute("messList", stringList);
        try {
            request.getRequestDispatcher("view/BenhAn/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBenhAn(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        benhAnService.delete(id);
        request.setAttribute("benhAnList", benhAnService.findAll());
        request.setAttribute("benhNhanList", benhNhanService.findAll());
        try {
            request.getRequestDispatcher("view/BenhAn/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
