package model.service;

import model.bean.Auther;
import model.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<String> add(Book book);
    List<String> update(Book book);
    boolean delete(int id);
    List<Book> search(String name1, String name2);
    Book findById(int id);
}
