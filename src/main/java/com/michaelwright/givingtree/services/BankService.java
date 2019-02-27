package com.michaelwright.givingtree.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.michaelwright.givingtree.models.Bank;
import com.michaelwright.givingtree.models.Company;
import com.michaelwright.givingtree.repositories.BankRepo;

@Service
public class BankService {
	private final BankRepo bR;


	public BankService(BankRepo bankRepo) {
		this.bR = bankRepo;
	
	}
	
	public List<Bank> allBanks() {
		return bR.findAll();
	}
	
	// find user by id
	public Bank findUserById(Long id) {
    	Optional<Bank> u = bR.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
	
	public boolean authenticateUser(String phone, String password) {
        // first find the user by email
        Bank user = bR.findByPhone(phone);
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
	
	public Bank registerUser(Bank user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return bR.save(user);
	}
	
	   // find user by phone
	 public Bank findByPhone(String phone) {
	     return bR.findByPhone(phone);
	 }
	
	public Bank createBank(Bank bank) {
		return bR.save(bank);

	}
	
	public void accept(Bank b, Company c) {
		List<Company> requests = b.getRequests();
		List<Company> approved = b.getCompanies();
		
		int indexOfEvent = requests.indexOf(c); 
		requests.remove(indexOfEvent);
		b.setRequests(requests);
		bR.save(b);
		
		if(!approved.contains(c)) {
			approved.add(c);
			b.setCompanies(approved);
			bR.save(b);
		}
	}

	public void decline(Bank b, Company c) {
		List<Company> requests = b.getRequests();
		
		int indexOfEvent = requests.indexOf(c); 
		requests.remove(indexOfEvent);
		b.setRequests(requests);
		bR.save(b);
	}
	
	

}
