//package codegym.formatter;
//
//import codegym.entity.Product;
//import codegym.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//@Component
//public class ProductFormatter implements Formatter<Product> {
//
//    private ProductService service;
//
//    @Autowired
//    public ProductFormatter( ProductService service) {
//        this.service = service;
//    }
//
//    public Product parse(int num, Locale locale) throws ParseException {
//        return service.findById(num);
//    }
//
//    @Override
//    public String print(Product object, Locale locale) {
//        return object.toString();
//    }
//
//    @Override
//    public Product parse(String text, Locale locale) throws ParseException {
//        return null;
//    }
//}
