package com.niit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
      @RequestMapping(value="/home")
      public String homepage()
      {
    	  return "Home";
      }
      @RequestMapping(value="/all/Admin")
      public String adminpage()
      {
    	  return "Admin";
      }
      @RequestMapping(value="/all/AboutPage")
      public String Aboutuspage()
      {
    	  return "AboutUs";
      }
      @RequestMapping("/login")
      public String login()
      {
      	return "Login";
      }
      @RequestMapping("/loginerror")
      public String loginError(Model model)
      {
      	model.addAttribute("loginError","Invalid email/password");
      	return "Login";
      }
      @RequestMapping(value="/logout")
      public String logout(Model model)
      {
      	model.addAttribute("message","Loggedout successfully..");
      	return "Login";
      }
      @RequestMapping(value="/all/Header")
  	public String getStartPage()
      {
  		return "Home";
  	}
     
      @RequestMapping(value="/loginsuccess")
   	public String loginSuccess(){
   		return "Product";
   	}

}
