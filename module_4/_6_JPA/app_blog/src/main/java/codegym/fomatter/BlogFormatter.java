package codegym.fomatter;

import codegym.entity.Blog;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class BlogFormatter implements Formatter<Blog>{
    private BlogService service;

    @Override
    public Blog parse(String text, Locale locale) throws ParseException {
        return service.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Blog object, Locale locale) {
        return object.toString();
    }
}
