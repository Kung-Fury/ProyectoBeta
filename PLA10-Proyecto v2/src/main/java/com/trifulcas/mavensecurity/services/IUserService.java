package com.trifulcas.mavensecurity.services;

import java.util.List;

import com.trifulcas.mavensecurity.model.User;

public interface IUserService {
	List<User> getUser();

	void save(User usuario);

	User getUser(String username);
	
	void delete(User usuario);

}