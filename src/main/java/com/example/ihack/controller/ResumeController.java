package com.example.ihack.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ihack.model.Resume;
import com.example.ihack.service.ResumeRepository;
import com.example.ihack.service.ResumeService;
import com.example.ihack.model.Resume;

@RestController
public class ResumeController {
	
	
	@Autowired
	ResumeService service;

	@Autowired
	ResumeRepository repository;	
	

	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String showtodo( ModelMap model) {
		String name=getLoggedInUserName(model);
		model.put("todos",repository.findByUser(name));
		//model.put("todos", service.retrieveTodos(name));
		return "list-resumes";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String addtodo( ModelMap model) {
		model.addAttribute("todo",new Resume(0,getLoggedInUserName(model),"","","","","",""));
				return "resume";
	}

	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deletetodo( ModelMap model,@RequestParam int id) {
		repository.deleteById(id);
		//service.deleteTodo(id);
				return "redirect:/list-resumes";
	}
	
	
	

	@RequestMapping(value="/update-resume",method=RequestMethod.GET)
	public String updatetodo( ModelMap model,@RequestParam int id) {
		Resume todo=repository.findById(id).get();
		//Todo todo=service.retrieveTodo(id);
		model.put("todo",todo);
				return "resume";
	}
	
	
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String showupdatetodo(@Valid Resume todo,BindingResult result,ModelMap model) {
		
		todo.setUser(getLoggedInUserName(model));
		if(result.hasErrors()) {
			return "resume";
		}
		
		
		repository.save(todo);
		
				return "redirect:/list-resumes";
	}
	
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String showaddtodo( ModelMap model,@Valid Resume todo,BindingResult result) {
		if(result.hasErrors()) {
			return "resume";
		}
		
		todo.setUser(getLoggedInUserName(model));
		repository.save(todo);
		
		//service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
				return "redirect:/list-resumes";
	}
	
	
		private String getLoggedInUserName(ModelMap model) {
			Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(principal instanceof UserDetails) {
				return ((UserDetails)principal).getUsername();
			}
			return principal.toString();
		}
}
