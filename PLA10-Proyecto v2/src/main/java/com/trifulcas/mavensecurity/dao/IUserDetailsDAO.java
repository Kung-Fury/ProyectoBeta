package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trifulcas.mavensecurity.model.User;

@Service
public interface IUserDetailsDAO {
 

User findUserByUsername(String username);  
  
  List<User> getUsers();

	void save(User usuario);

	User getUser(String username);
	
	void delete(User usuario);
	
}