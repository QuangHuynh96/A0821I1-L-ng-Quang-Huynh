package model.service.impl;

import common.Validation;
import model.bean.Auther;
import model.repository.AutherRepository;
import model.repository.impl.AutherRepositoryImpl;
import model.service.AutherService;

import java.util.ArrayList;
import java.util.List;

public class AutherServiceImpl implements AutherService {
    AutherRepository autherRepository = new AutherRepositoryImpl();
    @Override
    public List<Auther> findAll() {
        return autherRepository.findAll();
    }

    @Override
    public List<String> add(Auther auther) {
        List<String> messList = new ArrayList<>();
        boolean check=true;
        if (Validation.checkNickName(auther.getNickName()) ){
            messList.add("");
        }else {
            check=false;
            messList.add("Nickname phải dài từ 6-8 ký tự. ");
        }
        if (check){
            // cho lưu
            autherRepository.add(auther);
        }
        return messList;
    }

    @Override
    public List<String> update(Auther auther) {
        List<String> messList = new ArrayList<>();
        boolean check=true;
        if (Validation.checkNickName(auther.getNickName()) ){
            messList.add("");
        }else {
            check=false;
            messList.add("Nickname phải dài từ 6-8 ký tự. ");
        }
        if (check){
            // cho lưu
            autherRepository.update(auther);
        }
        return messList;
    }

    @Override
    public boolean delete(int id) {
        return autherRepository.delete(id);
    }

    @Override
    public List<Auther> search(String name, String nickName, String address) {
        return autherRepository.search( name, nickName, address);
    }

    @Override
    public Auther findById(int id) {
        return autherRepository.findById(id);
    }
}
