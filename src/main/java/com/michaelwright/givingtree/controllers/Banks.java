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

import com.michaelwright.givingtree.models.Bank;
import com.michaelwright.givingtree.models.Company;
import com.michaelwright.givingtree.services.BankService;
import com.michaelwright.givingtree.validation.BankValidator;

@Controller
public class Banks {
	 private final BankService bankService;
	 private final BankValidator bankValidator;
	 
	 public Banks(BankService userService, BankValidator userValidator) {
	        this.bankService = userService;
	        this.bankValidator = userValidator;
	 }
	 @RequestMapping("/banklog")
	 public String login(@ModelAttribute("bank") Bank bank) {
		 return "logReg/bankLog.jsp";
	 }
    
	 @RequestMapping("/bankreg")
	 public String register(@ModelAttribute("bank") Bank bank) {
		 return "logReg/bankReg.jsp";
	 }
	 
	 @RequestMapping(value="/bregister", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("bank") Bank bank, BindingResult result, HttpSession session) {
	    	bankValidator.validate(bank, result);
	    	if(result.hasErrors()) {
				return "logReg/bankReg.jsp"; 
			} else {
				Bank u = bankService.registerUser(bank); 
				session.setAttribute("bankId", u.getId());
				
				return "redirect:/dash";
				}
		}
	 
	 @RequestMapping(value="/loginbank", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("phone") String phone, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("company") Company company) {
	        boolean isAuthenticated = bankService.authenticateUser(phone, password); 
	        if(isAuthenticated) {
	        	Bank u = bankService.findByPhone(phone); 
	        	session.setAttribute("bankId", u.getId());
	        	return "redirect:/dash";
	        }else {
	        	model.addAttribute("error", "Invalid Credentails. Please try again.");
				return "logReg/bankLog.jsp";
	        }
	    }

}
