package com.example.demo.repository;

import com.example.demo.entity.Contract;
import com.example.demo.entity.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    @Query(value = "SELECT * FROM contract_detail where flag = true and contract_id =:id ", nativeQuery = true)
    List<ContractDetail> getListByContractId(@Param("id") Long id);
}
