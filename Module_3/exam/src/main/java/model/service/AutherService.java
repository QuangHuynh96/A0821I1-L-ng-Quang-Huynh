package model.service;

import model.bean.Auther;

import java.util.List;

public interface AutherService {
    List<Auther> findAll();
    List<String> add(Auther auther);
    List<String> update(Auther auther);
    boolean delete(int id);
    List<Auther> search(String name);
    Auther findById(int id);
}
