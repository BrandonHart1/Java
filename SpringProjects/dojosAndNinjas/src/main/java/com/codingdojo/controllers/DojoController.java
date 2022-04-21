package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Dojo;
import com.codingdojo.services.DojoService;

@Controller
public class DojoController 
{
	@Autowired // will deal with the dependencies in a specific order (repository first)
	private DojoService dojoService;
	
	public DojoController(DojoService dojoservice)
	{
		this.dojoService = dojoservice;
	}
	
	@GetMapping("/dojos")
	public String dojo_new(Model model)
	{	
		model.addAttribute("dojo", new Dojo());  // show the dojo page
		model.addAttribute("dojos", dojoService.FindAll());
		return "dojo_new";
	}
	
	@GetMapping("/dojos/{id}")
	public String dojo_show
	(
			@PathVariable("id") Long id,
			Model model
	)
	{
		model.addAttribute("dojo",dojoService.FindOne(id));
		return "dojos";
	}
	
	@PostMapping("/dojo")
	public String dojo_create
	(
			@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult bindingresult // validates, bindingresult stores the errors
	)
	{
		if(bindingresult.hasErrors())  // checks for errors
		{
			return "dojo_new";
		}
		dojoService.Create(dojo); // if successful, creates and adds to database
		return "redirect:/ninja";
	}
};
