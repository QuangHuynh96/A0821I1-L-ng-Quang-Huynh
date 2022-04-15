package model.service.impl;

import model.bean.BenhNhan;
import model.repository.BenhNhanRepository;
import model.repository.impl.BenhNhanRepositoryImpl;
import model.service.BenhNhanService;

import java.util.ArrayList;
import java.util.List;

public class BenhNhanServiceImpl implements BenhNhanService {

    BenhNhanRepository benhNhanRepository = new BenhNhanRepositoryImpl();
    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }

    @Override
    public List<String> add(BenhNhan benhNhan) {
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
            benhNhanRepository.add(benhNhan);
        }
        return messList;
    }

    @Override
    public List<String> update(BenhNhan benhNhan) {
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
            benhNhanRepository.update(benhNhan);
        }
        return messList;
    }

    @Override
    public boolean delete(int id) {
        return benhNhanRepository.delete(id);
    }

    @Override
    public BenhNhan findById(int id) {
        return benhNhanRepository.findById(id);
    }
}
