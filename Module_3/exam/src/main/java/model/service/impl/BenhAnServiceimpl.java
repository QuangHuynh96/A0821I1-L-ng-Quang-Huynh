package model.service.impl;

import model.bean.BenhAn;
import model.repository.BenhAnRepository;
import model.repository.impl.BenhAnRepositoryImpl;
import model.service.BenhAnService;

import java.util.ArrayList;
import java.util.List;

public class BenhAnServiceimpl implements BenhAnService {
    BenhAnRepository benhAnRepository = new BenhAnRepositoryImpl();
    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }

    @Override
    public List<String> add(BenhAn benhAn) {
        return null;
    }

    @Override
    public List<String> update(BenhAn benhAn) {
        List<String> messList = new ArrayList<>();
        boolean check=true;
//        if (Validation.checkNickName(auther.getNickName()) ){
//            messList.add("");
//        }else {
//            check=false;
//            messList.add("Nickname phải dài từ 6-8 ký tự. ");
//        }
        if (check){
            // cho lưu
            benhAnRepository.update(benhAn);
        }
        return messList;
    }

    @Override
    public boolean delete(int id) {
        return benhAnRepository.delete(id);
    }

    @Override
    public BenhAn findById(int id) {
        return benhAnRepository.findById(id);
    }
}
