package model.repository;

import model.bean.Auther;

import java.util.List;

public interface AutherRepository {
    List<Auther> findAll();
    boolean add(Auther auther);
    boolean update(Auther auther);
    boolean delete(int id);
    List<Auther> search(String name);
    Auther findById(int id);
}
