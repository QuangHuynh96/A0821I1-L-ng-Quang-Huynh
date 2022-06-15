package com.example.demo.service.impl;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import com.example.demo.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public void save(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(KhuyenMai khuyenMai) {
        khuyenMai.setFlag(false);
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public List<KhuyenMai> getList() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public Page<KhuyenMai> getAllCustomer(int key_money, String key_startDay, String key_endDay, Pageable pageable) {
        return khuyenMaiRepository.findAll(key_money, key_startDay, key_endDay, pageable);
    }

    @Override
    public Page<KhuyenMai> search(int key_money, String key_startDay, String key_endDay, Pageable pageable) {
        return khuyenMaiRepository.search(key_money, key_startDay, key_endDay, pageable);
    }
}
