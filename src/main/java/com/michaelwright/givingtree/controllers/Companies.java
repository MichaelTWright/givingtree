package com.michaelwright.givingtree.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.michaelwright.givingtree.models.Company;
import com.michaelwright.givingtree.services.CompanyService;
import com.michaelwright.givingtree.validation.CompanyValidator;

@Controller
public class Companies {
	 private final CompanyService companyService;
	 private final CompanyValidator companyValidator;
	 
	 public Companies(CompanyService userService, CompanyValidator userValidator) {
	        this.companyService = userService;
	        this.companyValidator = userValidator;
	    }
	 
    @RequestMapping("/companylog")
    public String loginForm() {
        return "logReg/companyLog.jsp";
    }
    
    @RequestMapping("/companyreg")
    public String registerForm(@ModelAttribute("company") Company company) {
        return "logReg/companyReg.jsp";
    }
	 
	 @RequestMapping(value="/cregister", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("company") Company company, BindingResult result, HttpSession session) {
	    	companyValidator.validate(company, result);
	    	if(result.hasErrors()) {
				return "logReg/companyReg.jsp"; 
			} else {
				Company u = companyService.registerUser(company); 
				session.setAttribute("companyId", u.getId());
				
				return "redirect:/home";
				}
		}
	 
	 @RequestMapping(value="/logincompany", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("phone") String phone, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("company") Company company) {
	        boolean isAuthenticated = companyService.authenticateUser(phone, password); 
	        if(isAuthenticated) {
	        	Company u = companyService.findByPhone(phone); 
	        	session.setAttribute("companyId", u.getId());
	        	return "redirect:/home";
	        }else {
	        	model.addAttribute("error", "Invalid Credentails. Please try again.");
				return "logReg/companyLog.jsp";
	        }
	    }

}
