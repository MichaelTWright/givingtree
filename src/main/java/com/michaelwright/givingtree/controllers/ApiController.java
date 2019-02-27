package com.michaelwright.givingtree.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelwright.givingtree.models.Bank;
import com.michaelwright.givingtree.models.Company;
import com.michaelwright.givingtree.services.CompanyService;

@RestController
public class ApiController {
	 private final CompanyService companyService;
	
	
	    
   public ApiController(CompanyService companyService) {

       this.companyService = companyService;   
   }
   
   @RequestMapping("/api/{id}/phone")
	public List<String> getNumbers(@PathVariable("id") Long id) {
		Company company = companyService.getCompanyById(id);
		List<Bank> banks = company.getBanks();
		List<String> myList = new ArrayList<String>();
		for (int i = 0; i < banks.size(); i++) {
			String phone = banks.get(i).getPhone();
			myList.add(phone); 
		}
		System.out.println(myList);
		return myList; 
	}
   
   @RequestMapping("/api/{id}")
	public List<String> getCompany(@PathVariable("id") Long id) {
		Company company = companyService.getCompanyById(id);
		List<String> myList = new ArrayList<String>();
		myList.add(company.getName());
		myList.add(company.getAddress()); 
		myList.add(company.getPhone()); 
		
		System.out.println(myList);
		return myList; 
	}

}
