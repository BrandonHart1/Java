package com.codingdojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>
{
	
};
