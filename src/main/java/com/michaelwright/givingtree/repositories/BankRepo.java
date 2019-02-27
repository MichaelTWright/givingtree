package com.michaelwright.givingtree.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.michaelwright.givingtree.models.Bank;

@Repository
public interface BankRepo extends CrudRepository<Bank, Long> {
	Bank findByPhone(String phone);
    public List<Bank> findAll();
}
