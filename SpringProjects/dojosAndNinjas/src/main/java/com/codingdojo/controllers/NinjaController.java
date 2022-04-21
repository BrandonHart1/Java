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

import com.codingdojo.models.Ninja;
import com.codingdojo.services.DojoService;
import com.codingdojo.services.NinjaService;

@Controller
public class NinjaController 
{
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	public NinjaController
	(
			NinjaService ninjaService,
			DojoService dojoService
	)
	{
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	
	@GetMapping("/ninja")
	public String ninja_new(Model model)
	{
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("ninjas", ninjaService.ReadAll());
		model.addAttribute("dojos", dojoService.ReadAll());
		return "ninja_new";
	}
	
	@PostMapping("/ninja")
	public String ninja_create
	(
			@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult bindingresult, Model model
	)
	{
		if(bindingresult.hasErrors())
		{
			model.addAttribute("ninjas", ninjaService.ReadAll());
			return "ninja_new";
		}
		ninjaService.Create(ninja);
		return "redirect:/dojos";
	}
	
	@GetMapping("/ninja/{id}")
	public String ninja_show
	(
			@PathVariable("id") Long id,
			Model model
	)
	{
		model.addAttribute("ninja",ninjaService.ReadOne(id));
		return "dojos";
	}
	
	@GetMapping("/ninja/{id}/edit")
	public String ninja_edit
	(
			@PathVariable("id") Long id,
			Model model
	)	
	{
		Ninja ninja=ninjaService.ReadOne(id);
		if(ninja==null) return "redirect:/ninja";
		model.addAttribute("ninja",ninjaService.ReadOne(id));
		return "ninja_edit";
	}
	
	@PostMapping("/ninja/{id}/update")
	public String ninja_update
	(
			@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult bindingresult,
			Model model,
			@PathVariable("id") Long id
	)
	{
		if(bindingresult.hasErrors())
		{
			return "ninja_edit";
		}
		ninjaService.Update(ninja);;
		return "redirect:/dojos";
	}
	
	@PostMapping("/ninja/{id}/delete")
	public String ninja_delete
	(
		@PathVariable("id") Long id
	)
	{
		ninjaService.Delete(id);
		return "redirect:/ninja";
	}
	
}
