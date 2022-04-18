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

import com.codingdojo.models.Expense;
import com.codingdojo.services.ExpenseService;

@Controller
public class ExpenseController 
{
	@Autowired
	private ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService)
	{
		this.expenseService=expenseService;
	}
	
	@GetMapping("/expenses")
	public String expenses(Model model)
	{
		model.addAttribute("expense", new Expense());
		model.addAttribute("expenses", expenseService.ReadAll());
		return "expenses";
	}
	
	
	// --------------- HOME PAGE/CREATE ---------------
	// -------- ** BindingResult ** show us the errors --------
	@PostMapping("/expenses")
	public String expense_create(@Valid @ModelAttribute("expense") Expense expense, BindingResult res, Model model)
	{
		if(res.hasErrors())
		{
			model.addAttribute("expense", expenseService.ReadAll());
			return "expense";
		}
		var id = expenseService.Create(expense);
		return "redirect:/show/" + id;
	}
	
	// --------------- SHOW ---------------
	@GetMapping("/show/{id}")
	public String show
	(
			@PathVariable("id") Long id, Model model
	)
	{
		model.addAttribute("expense", expenseService.ReadOne(id));
		return "show";
	}
	
	// --------------- EDIT ---------------
	@GetMapping("/expenses/{id}/edit")
	public String edit
	(
			@PathVariable("id") Long id, Model model
	)
	{
		Expense expense=expenseService.ReadOne(id);
		if(expense==null) return "redirect:/expense";
		model.addAttribute("expense", expenseService.ReadOne(id));
		return "edit";
	}
	
	// --------------- UPDATE ---------------
	@PostMapping("/expenses/{id}/update")
	public String expense_update
	(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult res, Model model, @PathVariable("id") Long id
	)
	{
		if(res.hasErrors())
		{
			System.out.println("***** HAS ERRORS *****");
			return "edit";
		}
		expenseService.Update(expense);
		return "redirect:/expenses";
	}
	
	// --------------- DELETE ---------------
	@PostMapping("/expenses/{id}/delete")
	public String expense_delete
	(
			@PathVariable("id") Long id
	)
	{
		expenseService.Delete(id);
		return "redirect:/expense";
	}
	
};
