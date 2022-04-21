package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Ninja;
import com.codingdojo.repositories.NinjaRepository;

@Service
public class NinjaService 
{
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository)
	{
		this.ninjaRepository=ninjaRepository;
	}
	
	// -------- Create --------
	public void Create(Ninja ninja)
	{
		ninjaRepository.save(ninja);
	}
	
	// -------- Read --------
	public Ninja ReadOne(Long id)
	{
		Optional<Ninja> ninja=ninjaRepository.findById(id);
		return ninja.isPresent()?ninja.get():null;
	}
	
	// -------- Read All --------
	public ArrayList<Ninja> ReadAll()
	{
		ArrayList<Ninja> ninja=(ArrayList<Ninja>)ninjaRepository.findAll();
		return ninja;  // -------- ninja or ninjas??? --------
	}
	
	// -------- Update --------
	public void Update(Ninja ninja)
	{
		Create(ninja);
	}
	
	// -------- Delete --------
	public void Delete(Long id)
	{
		ninjaRepository.deleteById(id);
	}
};
