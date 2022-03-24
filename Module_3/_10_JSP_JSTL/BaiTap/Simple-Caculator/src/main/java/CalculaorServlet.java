import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculaorServlet", value = "/Calculaor")
public class CalculaorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOpenrand = Float.parseFloat(request.getParameter("first-openrand"));
        float secondOpenrand = Float.parseFloat(request.getParameter("second-openrand"));
        String operator = request.getParameter("operator");

        request.setAttribute("first-number", firstOpenrand);
        request.setAttribute("second-number", secondOpenrand);
        request.setAttribute("operator", operator);


//        response.getWriter().println("<html>");
        try {
//            float result = Calculator.calculator(firstOpenrand, secondOpenrand,operator);
//            response.getWriter().println(firstOpenrand+operator+secondOpenrand+"="+result);

            float result = Calculator.calculator(firstOpenrand, secondOpenrand,operator);
            request.setAttribute("result", result);
            request.getRequestDispatcher("result.jsp").forward(request,response);

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request,response);

//            response.getWriter().println("Error: " + e.getMessage());
        }
//        response.getWriter().println("</html>");
    }
}
