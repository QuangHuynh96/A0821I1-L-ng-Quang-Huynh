package model.service.impl;

import common.Validation;
import model.bean.Book;
import model.repository.BookRepository;
import model.repository.impl.BookRepositoryImpl;
import model.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<String> add(Book book) {
        List<String> messList = new ArrayList<>();
        boolean check=true;
        if (Validation.checkName(book.getName()) ){
            messList.add("");
        }else {
            check=false;
            messList.add("ten sai dinh dang. ");
        }
        if (check){
            // cho lưu
            bookRepository.add(book);
        }
        return messList;
    }

    @Override
    public List<String> update(Book book) {
        List<String> messList = new ArrayList<>();
        boolean check=true;
        messList.add("");
//        if (Validation.checkNickName(book.getName()) ){
//            messList.add("");
//        }else {
//            check=false;
//            messList.add("Nickname phải dài từ 6-8 ký tự. ");
//        }
        if (check){
            // cho lưu
            bookRepository.update(book);
        }
        return messList;
    }

    @Override
    public boolean delete(int id) {
        return bookRepository.delete(id);
    }

    @Override
    public List<Book> search(String name1, String name2) {
        return bookRepository.search(name1, name2);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }
}
