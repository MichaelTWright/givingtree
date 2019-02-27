package com.michaelwright.givingtree.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.michaelwright.givingtree.models.Bank;
import com.michaelwright.givingtree.models.Company;
import com.michaelwright.givingtree.services.BankService;
import com.michaelwright.givingtree.services.CompanyService;

@Controller
public class MainController {
	 private final CompanyService companyService;
	 private final BankService bankService;
	
	    
   public MainController(CompanyService companyService, BankService bankService) {
       this.bankService = bankService;
       this.companyService = companyService;   
   }
   
   @RequestMapping("/")
   public String index() {
	   System.out.println("HERE");
       return "index.jsp";
   }
   
   @RequestMapping("/home")
   public String home(HttpSession session, Model model) {
   	Long companyId = (Long) session.getAttribute("companyId"); 
   	if (companyId == null){
   	 return "redirect:/"; 
   	}

   	Company u = companyService.findUserById(companyId); 
   	List<Bank> banks = bankService.allBanks();
	model.addAttribute("banks", banks);
	
	List<Bank> list = u.getBanks();
	model.addAttribute("list", list);
	
	List<Bank> requests = u.getRequest_banks();
	model.addAttribute("requests", requests);

   	model.addAttribute("user", u); 

   	return "company.jsp"; 
   }
   
   @RequestMapping("/dash")
   public String dash(HttpSession session, Model model) {
   	Long bankId = (Long) session.getAttribute("bankId");
   	if (bankId == null){
      	 return "redirect:/"; 
    }
   	
   	Bank u = bankService.findUserById(bankId); 
   	model.addAttribute("user", u); 
   	
   	List<Company> requests = u.getRequests();
	model.addAttribute("requests", requests);
	
  	List<Company> approved = u.getCompanies();
	model.addAttribute("approved", approved);
	
	Map<Object, Object> map = new HashMap<Object, Object>();
	for (int i = 0; i < requests.size(); i++) {
		String zip = requests.get(i).getZip();
		Object company = requests.get(i); 
		
		final String uri = "https://www.zipcodeapi.com/rest/BD7iONeUdzPznG1O77skZQxiYxsQ7FBF4CzkfnhXnUkTjUm6HZ5DanVCynt7iXDY/distance.json/"+u.getZip()+"/"+zip+"/mile";
		
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(uri, Object.class);
		
		map.put(company,result);
	}
	
	System.out.println(map);
     
   	model.addAttribute("map", map); 
	
   	return "bank.jsp"; 
   }
   
   
   
   @RequestMapping("/logout")
   public String logout(HttpSession session) {
       session.invalidate();
       return "redirect:/"; 
   }
   
   @RequestMapping(value="/company/{id}", method=RequestMethod.POST)
   public String request(@RequestParam("bank") Long bankId, @PathVariable("id") long id) {
	   Bank b = bankService.findUserById(bankId);
	   Company c = companyService.findUserById(id);
	   companyService.request(b, c);
	   
	   return "redirect:/home"; 
   }
   
   @RequestMapping(value="/accept/{bId}/{cId}")
   public String accept(@PathVariable("bId") long bId, @PathVariable("cId") long cId) {
	   Bank b = bankService.findUserById(bId);
	   Company c = companyService.findUserById(cId);
	   bankService.accept(b, c);
	   
	   return "redirect:/dash"; 
   }
   
   @RequestMapping(value="/decline/{bId}/{cId}")
   public String decline(@PathVariable("bId") long bId, @PathVariable("cId") long cId) {
	   Bank b = bankService.findUserById(bId);
	   Company c = companyService.findUserById(cId);
	   bankService.decline(b, c);
	   
	   return "redirect:/dash"; 
   }
   @RequestMapping(value="/delete/{cId}/{bId}")
   public String delete(@PathVariable("cId") long cId, @PathVariable("bId") long bId) {
	   Bank b = bankService.findUserById(bId);
	   Company c = companyService.findUserById(cId);
	   companyService.delete(b, c);
	   
	   return "redirect:/home"; 
   }


}
