package com.codingdojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.models.User;

// -------- repository saves a user to the database --------
// -------- don't want to save repository for LoginUser because we don't want to save it --------
public interface UserRepository extends CrudRepository<User, Long>
{
	User findByEmail(String email);
};
