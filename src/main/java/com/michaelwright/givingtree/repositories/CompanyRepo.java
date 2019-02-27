package com.michaelwright.givingtree.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.michaelwright.givingtree.models.Company;



@Repository
public interface CompanyRepo extends CrudRepository<Company, Long> {
	Company findByPhone(String phone);
    public List<Company> findAll();

}
