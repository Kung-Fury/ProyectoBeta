package com.trifulcas.mavensecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trifulcas.mavensecurity.dao.IUserDetailsDAO;
import com.trifulcas.mavensecurity.model.User;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserDetailsDAO userDAO;

	@Override
	@Transactional
	public List<User> getUser() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void save(User usuario) {
		userDAO.save(usuario);
	}

	@Override
	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Override
	@Transactional
	public void delete(User usuario) {
		userDAO.delete(usuario);
	}
}