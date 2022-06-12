package com.example.ihack.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.SessionAttributes;



	@Controller
	@SessionAttributes("name")
	public class LoginController {

	 
		
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String showwelcomepage( ModelMap model) {
			model.put("name", getLoggedinUserName());
			return "welcome";
		}

	private String getLoggedinUserName() {
		
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if(principal instanceof UserDetails) {
		return ((UserDetails)principal).getUsername();
	}
	return principal.toString();
	}

	}
	


