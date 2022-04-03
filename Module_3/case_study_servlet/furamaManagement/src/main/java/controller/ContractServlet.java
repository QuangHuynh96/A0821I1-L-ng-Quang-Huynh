package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractServlet", value = "/Contract")

public class ContractServlet extends HttpServlet {
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
                break;
            case "edit":
                break;
            case "findByName":
                break;
            default:
                showContractManagement(request, response);
                break;
        }
    }

    private void showCreateContractForm(HttpServletRequest request, HttpServletResponse response) {
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
                "    <form method=\"post\" action=\"/Contract?action=findByName\" class=\"form-inline my-2 my-lg-0 list-group-item list-group-item-action disabled\" style=\"padding: 0 8px\">\n" +
                "        <input name=\"name\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Enter service name\" aria-label=\"Search\">\n" +
                "        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search (disabled)</button>\n" +
                "    </form>\n" +
                "    <a href=\"/Contract?action=create\" class=\"list-group-item list-group-item-action\">\n" +
                "        Create new contract (disable)\n" +
                "    </a>\n" +
                "    <a href=\"/Service?action=findByAll\" class=\"list-group-item list-group-item-action disabled\">Show contract list (disabled)</a>";
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

                break;
            case "delete":

                break;
            case "edit":

                break;
            case "findByName":

                break;
            default:
                break;
        }
    }

}
