package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Controller
public class CustomerController 
{
	@Autowired
	private CustomerDao customerDao;
	@RequestMapping(value="/all/getRegistrationform")
	public String getRegistrationForm(Model model){
	Customer customer	=new Customer();
	model.addAttribute("customer",customer);	
	return "RegistrationForm";	
	}
	@RequestMapping(value="/all/registercustomer")
	public String registerCustomer(@ModelAttribute Customer customer,Model model){
		String email=customer.getUser().getEmail();
		if(!customerDao.isEmailUnique(email))
		{
			model.addAttribute("errorMessage","Email already exists.. please choose different email id");
			return "RegistrationForm";
		}
		customerDao.registerCustomer(customer);
		
		 return "redirect:/Login";
	}
}
