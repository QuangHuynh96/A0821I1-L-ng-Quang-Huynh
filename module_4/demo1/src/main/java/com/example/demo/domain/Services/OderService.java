package com.example.demo.domain.Services;

import com.example.demo.infrastructure.dto.OderDto;
import com.example.demo.infrastructure.entity.Oder;

import java.util.List;
import java.util.Optional;

public interface OderService {
    void save(OderDto oderDto);

    void delete(Oder oder);

    Optional<Oder> findCustomerById(long id);

    List<Oder> getList();
}
