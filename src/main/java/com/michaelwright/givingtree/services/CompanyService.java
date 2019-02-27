package com.michaelwright.givingtree.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.michaelwright.givingtree.models.Bank;
import com.michaelwright.givingtree.models.Company;
import com.michaelwright.givingtree.repositories.CompanyRepo;



@Service
public class CompanyService {
	private final CompanyRepo cR;


	public CompanyService(CompanyRepo companyRepo) {
		this.cR = companyRepo;
	
	}
	
	public List<Company> allCompanies() {
		return cR.findAll();
	}
	
	// find user by id
	public Company findUserById(Long id) {
		Optional<Company> u = cR.findById(id);
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	public boolean authenticateUser(String phone, String password) {
		// first find the user by email
		Company user = cR.findByPhone(phone);
		// if we can't find it by email, return false
		if(user == null) {
			return false;
		} else {
			// if the passwords match, return true, else, return false
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	public Company registerUser(Company user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return cR.save(user);
    }
	
	   // find user by phone
    public Company findByPhone(String phone) {
        return cR.findByPhone(phone);
    }
	
	
	
	
	public Company createCompany(Company company) {
		return cR.save(company);

	}
	
	public void request(Bank b, Company c) {
		List<Bank> requests = c.getRequest_banks();
		
		if(!requests.contains(b)) {
			requests.add(b);
			c.setRequest_banks(requests);
			cR.save(c);
		}
	}
	
	public void delete(Bank b, Company c) {
		List<Bank> list = c.getBanks();
		
		int indexOfEvent = list.indexOf(b); 
		list.remove(indexOfEvent);
		c.setBanks(list);
		cR.save(c);
	}
	
	public Company getCompanyById(Long id) {
		Optional<Company> optionalCompany = cR.findById(id);
		if (optionalCompany.isPresent()) {
			return optionalCompany.get();
		} else {
			return null;
		}
	}

}
