package com.michaelwright.givingtree.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.michaelwright.givingtree.models.Company;
import com.michaelwright.givingtree.services.CompanyService;



@Component
public class CompanyValidator implements Validator {
private CompanyService cS;
	
	public CompanyValidator(CompanyService cS) {
		this.cS = cS;
	}
	
	// 1
    @Override
    public boolean supports(Class<?> clazz) {
        return Company.class.equals(clazz);
    }
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        Company user = (Company) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
        if(cS.findByPhone(user.getPhone()) != null) {
    		errors.rejectValue("phone", "Taken");
        }
    }
	

}
