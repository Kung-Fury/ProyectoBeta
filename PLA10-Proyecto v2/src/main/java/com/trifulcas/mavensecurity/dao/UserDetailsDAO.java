
package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trifulcas.mavensecurity.model.User;

@Repository
public class UserDetailsDAO implements IUserDetailsDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public User findUserByUsername(String username) {
    return sessionFactory.getCurrentSession().get(User.class, username);
  }
 
  	@Override
  	public List<User> getUsers() {
	 Session miSesion = sessionFactory.getCurrentSession();
	List<User> usuario = miSesion.createQuery("from User", User.class).list();
	return usuario;
	}
	
  	@Override
	public void save(User usuario) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(usuario);
	}
	
  	@Override
	public User getUser(String username) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(User.class, username);
	}
	
  	@Override
	public void delete(User usuario) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(usuario);
	}

	
}