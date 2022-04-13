package model.repository;

import model.bean.Auther;
import model.bean.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    boolean add(Book book);
    boolean update(Book book);
    boolean delete(int id);
    List<Book> search(String name1, String name2);
    Book findById(int id);
}
