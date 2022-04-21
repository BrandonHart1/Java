package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojo;
import com.codingdojo.repositories.DojoRepository;

@Service
public class DojoService 
{
	@Autowired
	private DojoRepository dojoRepository;  // calls on the methods (findAll, etc.)
	public DojoService(DojoRepository dojoRepository)
	{
		this.dojoRepository=dojoRepository;
	}
	
	public void Create(Dojo dojo)
	{
		dojoRepository.save(dojo);
	}
	
	public ArrayList<Dojo> FindAll()
	{
		return (ArrayList<Dojo>)dojoRepository.findAll();
	}
	
	public Dojo FindOne(Long id)
	{
		Optional<Dojo> dojo=dojoRepository.findById(id);
		return dojo.isPresent()?dojo.get():null;
	}
	
	void Update(Dojo dojo)
	{
		Create(dojo);
	}
	
	void Delete(Long id)
	{
		dojoRepository.deleteById(id);
	}

	public ArrayList<Dojo> ReadAll() 
	{
		return (ArrayList<Dojo>)dojoRepository.findAll();
	}
};


