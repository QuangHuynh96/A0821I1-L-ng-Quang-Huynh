package model.repository.impl;

import model.bean.Auther;
import model.bean.Book;
import model.repository.BaseRepository;
import model.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private static final String FINDALL = "select * from book where delete_flag = true;";
    private  static  final  String ADDNEW = "insert into Book (`name`, price, id_auther)\n" +
                                            "values (?,?,?);";
    private static final String FINDBYID = "select * from book where delete_flag = true and id_book = ?;";
    private static final String DELETE = "update book set delete_flag = false where id_book = ?;";
    private static final String UPDATE = "update book set `name` = ?, price = ?, id_auther = ?  where id_book = ? and delete_flag = true;";
    private static final String SEARCH ="select * from book\n" +
            "left join auther on auther.id_author = book.id_auther\n" +
            " where book.name like ? and auther.name like ? and book.delete_flag = true;";
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int idAuther = resultSet.getInt(4);
                Book book = new Book(id, name, price,idAuther);
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean add(Book book) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADDNEW);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDouble(2, book.getPrice());
            preparedStatement.setInt(3, book.getIdAuther());
            int check = preparedStatement.executeUpdate();// trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setDouble(2, book.getPrice());
            preparedStatement.setInt(3, book.getIdAuther());
            preparedStatement.setInt(4,book.getId());
            int check = preparedStatement.executeUpdate();// trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            int check = preparedStatement.executeUpdate();// trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> search(String name1,String name2) {
        List<Book> bookList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+name1+"%");
            preparedStatement.setString(2,"%"+name2+"%");

            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int idAuther = resultSet.getInt(4);
                Book newBook = new Book(id, name, price,idAuther);
                bookList.add(newBook);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int id_auther = resultSet.getInt(4);
                 book = new Book(id,name,price,id_auther);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }
}
