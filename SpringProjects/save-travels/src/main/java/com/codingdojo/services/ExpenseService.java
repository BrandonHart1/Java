package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Expense;
import com.codingdojo.repositories.ExpenseRepository;

@Service  // -------- talks to the database --------
public class ExpenseService 
{
	private final ExpenseRepository expenseRepository; // will call all the methods (ex: findAll)
	
	public ExpenseService(ExpenseRepository expenseRepository)
	{
		this.expenseRepository=expenseRepository;
	}
	
	// -------- CREATE and save into the database --------
	public Long Create(Expense expense)  
	{
		return expenseRepository.save(expense).getId(); // returning the id to return to the specific show page
		
	}
	
	// -------- FIND ALL --------
	public ArrayList<Expense> FindAll()
	{
		return (ArrayList<Expense>)expenseRepository.findAll(); // -------- ArrayList is a class in Java --------
	}
	
	// -------- READ --------
	public Expense ReadOne(Long id)
	{
		Optional<Expense> expense=expenseRepository.findById(id);  // ----- making a query in the table -----
		return expense.isPresent()?expense.get():null; // ----- if true (left of colon):false (right of colon) -----
	}
	
	public ArrayList<Expense> ReadAll() 
	{
		ArrayList<Expense> expenses=(ArrayList<Expense>)expenseRepository.findAll();
		return expenses;
	}
	
	// -------- UPDATE --------
	public void Update(Expense expense)  
	{
		Create(expense);
	}
	
	// -------- DELETE --------
	public void Delete(Long id)
	{
		expenseRepository.deleteById(id);
	}

	
	
}
