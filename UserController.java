package com.shopping.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.model.User;
import com.shopping.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	public UserController(){
		System.out.println("in constr of " + getClass().getName());
	}
	
	//for registration
	
	@RequestMapping("/regist")
	public String showRegForm(Model map)
	{
		System.out.println("in show register form");
		//create empty POJO & add it as a model attribute
		map.addAttribute("user123", new User());
		return "UserRegister";
	}
	
	 @RequestMapping(value="/regist",method=RequestMethod.POST)
     public String processRegForm(@ModelAttribute("user123") User u)
		{
			System.out.println("in process reg form "+u);
			//invoke service layer method to add a new member
			service.addUser(u);
			return "redirect:/users/regist";
		}
	 
	 
	 //for login
	 
	 
	 @RequestMapping("/loginuser")
		public String showLoginForm(Model map)
		{
			System.out.println("inside usercontroller .....loginuser get method");
			//create empty POJO & add it as a model attribute
			map.addAttribute("user12", new User());
			map.addAttribute("status", " "); //username that'll be entered in form
			return "Login";
		}
	 
		@SuppressWarnings("unused")
		@RequestMapping(value="/loginuser",method=RequestMethod.POST)
		public String processLoginForm(@Valid @ModelAttribute("user12") User user,
				BindingResult res,Model map,HttpSession hs)
		{
			hs.setAttribute("user12", user);
			System.out.println("inside usercontroller login process" + user);
		    if (res.hasErrors()) 
		    {
		    System.out.println("p.l errs " + res);
		    return "Invalid";
		    }
			System.out.println("no p.l errs ...cont to B.L");
			User status=service.validateUser(user);
			System.out.println("my status"+status);
			hs.setAttribute("user123",status);
			System.out.println(" after servno p.l errs ...cont to B.L");
			
			if(status.getUserName().equals(user.getUserName()))
			{
				return "AdminMenu"; //write homepage name
			}
			
			else
			{
				return "Invalid";
			}
			
			
		}

}
