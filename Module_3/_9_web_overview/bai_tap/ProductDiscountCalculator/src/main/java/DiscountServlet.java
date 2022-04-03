import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float listPrice = Float.parseFloat(request.getParameter("ListPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("DiscountPercent"));
        String description = request.getParameter("Description");

        float discountAmount = (float) (listPrice * discountPercent * 0.01);

        float discountPrice = listPrice - discountAmount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>" + description + "</h1><br>");
        writer.println("<h1>Discount Amount (chiec khau): " + discountAmount + " vnd</h1><br>");
        writer.println("<h1>Discount Price (gia sau cung): " + discountPrice + " vnd</h1>");
        writer.println("</html>");
    }
}
