package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhuyenMaiService {
    void save(KhuyenMai khuyenMai);

    void delete(KhuyenMai khuyenMai);

    List<KhuyenMai> getList();

    Page<KhuyenMai> getAllCustomer(int key_money, String key_startDay, String key_endDay, Pageable pageable );
    Page<KhuyenMai> search(int key_money, String key_startDay, String key_endDay, Pageable pageable );

}
