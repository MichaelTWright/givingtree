package com.michaelwright.givingtree.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.michaelwright.givingtree.models.Bank;
import com.michaelwright.givingtree.services.BankService;
@Component
public class BankValidator implements Validator {
private BankService bS;
	
	public BankValidator(BankService bS) {
		this.bS = bS;
	}
	
	// 1
    @Override
    public boolean supports(Class<?> clazz) {
        return Bank.class.equals(clazz);
    }
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        Bank user = (Bank) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
        if(bS.findByPhone(user.getPhone()) != null) {
    		errors.rejectValue("phone", "Taken");
        }
    }

}
