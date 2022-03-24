import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet", value = "/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {

    private static List<Customer> CustomerList= new ArrayList<>();

    static {
        CustomerList.add(new Customer("Mai Van Hoan","1983-08-20", "Ha Noi"));
        CustomerList.add(new Customer("Nguyen Van Nam","1983-08-21", "Bac Giang"));
        CustomerList.add(new Customer("Nguyen Thai Hoa","1983-08-22", "Name Dinh"));
        CustomerList.add(new Customer("Tran Dang khoa","1983-08-17", "Ha Tay"));
        CustomerList.add(new Customer("Nguyen Dinh Thi","1983-08-19", "Ha Noi"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showCustomerList.jsp");
        request.setAttribute("CustomerList",CustomerList);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
