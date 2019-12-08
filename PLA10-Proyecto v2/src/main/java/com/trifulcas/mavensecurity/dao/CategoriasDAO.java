package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trifulcas.mavensecurity.model.Categorias;

@Repository
public class CategoriasDAO implements ICategoriasDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Categorias> getCategorias() {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Categorias> categoria = miSesion.createQuery("from Categorias", Categorias.class).list();
		return categoria;
	}

	@Override
	public void save(Categorias categoria) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(categoria);
	}

	@Override
	public Categorias getCategoria(int idcategoria) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Categorias.class, idcategoria);
	}

	@Override
	public void delete(Categorias categoria) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(categoria);
	}
}
