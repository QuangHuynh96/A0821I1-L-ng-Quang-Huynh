package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller.ProductServlet", value = "/Product")
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProductForm(request, response);
                break;
            case "edit":
                showEditProductForm(request, response);
                break;
            case "delete":
                showDeleteProductForm(request, response);
                break;
            case "view":
                showProductForm(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;

            default:
                showProductList(request, response);
                //  hien thi danh sac san pham
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        Product product = this.productService.FindByName(name);
        request.setAttribute("product", product);

        try {
            if(product == null) {
                request.getRequestDispatcher("view/error-404.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("view/product/view.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Product product = this.productService.FindByName(name);
        request.setAttribute("product", product);

        try {
            if(product == null) {
                request.getRequestDispatcher("view/error-404.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("view/product/view.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteProductForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Product product = this.productService.FindByName(name);
        request.setAttribute("product", product);

        try {
            if(product == null) {
                request.getRequestDispatcher("view/error-404.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("view/product/delete.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Product product = this.productService.FindByName(name);
        request.setAttribute("product", product);

        try {
            if(product == null) {
                request.getRequestDispatcher("view/error-404.jsp");
            }else {
                request.getRequestDispatcher("view/product/edit.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);

        try {
            request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/product/create.jsp").forward(request, response);
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
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                EditProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

        Product product = this.productService.FindByName(name);
        try {
            if( product == null) {
                request.getRequestDispatcher("view/error=404.jsp").forward(request, response);
            }else {
                this.productService.remove(product.getId());
                response.sendRedirect("/Product");
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void EditProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        int id =Integer.parseInt(request.getParameter("id"));

        Product product = new Product(id, name, price, description, producer);
        this.productService.update(id, product);

        request.setAttribute("product",product);
        request.setAttribute("message", "Product information was updated");

        try {
            request.getRequestDispatcher("view/product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {


        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");

        List<Product> products = productService.findAll();// list product.
        int id = products.get(products.size()-1).getId();

        Product product = new Product(id, name, price, description,producer);
        productService.save(product);
        request.setAttribute("message", "New product was created.");
        try {
            request.getRequestDispatcher("view/product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}