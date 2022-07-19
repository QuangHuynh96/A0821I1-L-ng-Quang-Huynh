package com.example.demo.domain.Services.impl;

import com.example.demo.domain.Services.OderService;
import com.example.demo.infrastructure.Repository.OderRepository;
import com.example.demo.infrastructure.entity.Oder;
import com.example.demo.infrastructure.dto.OderDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderServiceImpl implements OderService {

    @Autowired
    OderRepository oderRepository;

    @Override
    public void save(OderDto oderDto) {
        Oder oder = new Oder();
        BeanUtils.copyProperties(oderDto, oder);

        oder.setFlag(true);
        oderRepository.save(oder);
    }

    @Override
    public void delete(Oder oder) {
        oder.setFlag(false);
        oderRepository.save(oder);
    }

    @Override
    public Optional<Oder> findCustomerById(long id) {
        return oderRepository.findById(id);
    }

    @Override
    public List<Oder> getList() {
        return oderRepository.getOderList();
    }
}
