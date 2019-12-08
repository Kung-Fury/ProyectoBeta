
package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trifulcas.mavensecurity.model.Authorities;

@Repository
public class AuthoritiesDAO implements IAuthoritiesDAO {

  @Autowired
  private SessionFactory sessionFactory;

  
  	@Override
	public void save(Authorities autoridad) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(autoridad);
	}
	
  	@Override
	public Authorities getAuthority(String autoridad) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Authorities.class, autoridad);
	}
	
  	@Override
	public void delete(Authorities autoridad) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(autoridad);
	}

	@Override
	public List<Authorities> getAuthority() {
		 Session miSesion = sessionFactory.getCurrentSession();
			List<Authorities> autoridad = miSesion.createQuery("from Authorities", Authorities.class).list();
		return autoridad;
	}
}