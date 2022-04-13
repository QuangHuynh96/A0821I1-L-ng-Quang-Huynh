package controller;

import model.bean.Employees;
import model.service.BoPhanService;
import model.service.EmployeeService;
import model.service.TrinhDoService;
import model.service.ViTriService;
import model.service.impl.BoPhanServiceimpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.TrinhDoServiceImpl;
import model.service.impl.ViTriServiceImpl;
import org.apache.taglibs.standard.tei.ImportTEI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/Employee")

public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    ViTriService viTriService = new ViTriServiceImpl();
    TrinhDoService trinhDoService = new TrinhDoServiceImpl();
    BoPhanService boPhanService = new BoPhanServiceimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateEmployeeForm(request, response);
                break;
            case "findByAll":
                showEmployeeListForm(request,response);
                break;
            case "edit":
                showEditEmployeeForm(request,response);
                break;
            default:
                showEmployeeManagement(request, response);// back to homepage.
                break;
        }
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employees employees = employeeService.FindById(id);
        request.setAttribute("employee",employees);
        request.setAttribute("locationList", viTriService.findAll());
        request.setAttribute("levelList",trinhDoService.findAll());
        request.setAttribute("partList",boPhanService.findAll());
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("locationList", viTriService.findAll());
        request.setAttribute("levelList",trinhDoService.findAll());
        request.setAttribute("partList",boPhanService.findAll());
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeListForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList", employeeService.findAll());
        request.setAttribute("locationList", viTriService.findAll());
        request.setAttribute("levelList",trinhDoService.findAll());
        request.setAttribute("partList",boPhanService.findAll());
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeManagement(HttpServletRequest request, HttpServletResponse response) {
        String content =
                "    <h4 class=\" navbar \" >Employee management</h4>" +
                        "   <form method=\"post\" action=\"/Employee?action=findByName\" class=\"form-inline my-2 my-lg-0\" style=\"padding: 0 8px\">\n" +
                        "        <input name=\"name\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Enter employee name\" aria-label=\"Search\">\n" +
                        "        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
                        "    </form>\n" +
                        "    <a href=\"/Employee?action=create\" class=\"list-group-item list-group-item-action\">\n" +
                        "        Create new employee\n" +
                        "    </a>\n" +
                        "    <a href=\"/Employee?action=findByAll\" class=\"list-group-item list-group-item-action\">Show employee list</a>";
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
                createEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
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
        List<Employees> employeesList = employeeService.FindByName(name);
        request.setAttribute("employeeList", employeesList);
        request.setAttribute("locationList", viTriService.findAll());
        request.setAttribute("levelList",trinhDoService.findAll());
        request.setAttribute("partList",boPhanService.findAll());
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("fullName");
        String ngaySinh = request.getParameter("birtday");
        int cmnd = Integer.parseInt(request.getParameter("idCard"));
        int luong = Integer.parseInt(request.getParameter("salary"));
        int soDienThoai = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("address");
        int idViTri = Integer.parseInt(request.getParameter("location"));
        int idTrinhDo = Integer.parseInt(request.getParameter("level"));
        int idBoPhan = Integer.parseInt(request.getParameter("part"));
        Employees employees = new Employees(ten,ngaySinh,cmnd,luong,soDienThoai,email,diaChi,idViTri,idTrinhDo,idBoPhan);
        boolean check = employeeService.update(id, employees);
        String message;
        if(check) {
            message = "Successful new updation!";
        }else {
            message = "Fail new updation!";
        }
        request.setAttribute("message", message);
        try {
            request.setAttribute("employee", employees);
            request.setAttribute("locationList", viTriService.findAll());
            request.setAttribute("levelList",trinhDoService.findAll());
            request.setAttribute("partList",boPhanService.findAll());
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("fullName");
        String ngaySinh = request.getParameter("birtday");
        int cmnd = Integer.parseInt(request.getParameter("idCard"));
        int luong = Integer.parseInt(request.getParameter("salary"));
        int soDienThoai = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("address");
        int idViTri = Integer.parseInt(request.getParameter("location"));
        int idTrinhDo = Integer.parseInt(request.getParameter("level"));
        int idBoPhan = Integer.parseInt(request.getParameter("part"));
        Employees employees = new Employees(ten,ngaySinh,cmnd,luong,soDienThoai,email,diaChi,idViTri,idTrinhDo,idBoPhan);
        boolean check = employeeService.save(employees);
        String message;
        if(check) {
            message = "Successful new creation!";
        }else {
            message = "Fail new creation!";
        }
        request.setAttribute("message", message);
        try {
            request.setAttribute("locationList", viTriService.findAll());
            request.setAttribute("levelList",trinhDoService.findAll());
            request.setAttribute("partList",boPhanService.findAll());
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.remove(id);
        request.setAttribute("employeeList", employeeService.findAll());
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
