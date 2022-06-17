package com.example.demo;

import com.example.demo.dto.KhuyenMaiDto;
import com.example.demo.entity.KhuyenMai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class formatKhuyenMai {

    public KhuyenMai format (KhuyenMaiDto khuyenMaiDto) {
        KhuyenMai khuyenMai = new KhuyenMai();
        try {
            khuyenMai.setId(khuyenMaiDto.getId());
            khuyenMai.setTitle(khuyenMaiDto.getTitle());
            khuyenMai.setMoney(khuyenMaiDto.getMoney());
            khuyenMai.setDetail(khuyenMaiDto.getDetail());
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(khuyenMaiDto.getStartDay());
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(khuyenMaiDto.getEndDay());
            khuyenMai.setStartDay(startDate);
            khuyenMai.setEndDay(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return khuyenMai;
    }
}
