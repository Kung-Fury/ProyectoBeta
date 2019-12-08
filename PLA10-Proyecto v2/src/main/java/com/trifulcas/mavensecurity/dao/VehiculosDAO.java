package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trifulcas.mavensecurity.model.Vehiculos;

@Repository
public class VehiculosDAO implements IVehiculosDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Vehiculos> getVehiculos() {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Vehiculos> vehiculos = miSesion.createQuery("from Vehiculos", Vehiculos.class).list();
		return vehiculos;
	}
	
	public List<Vehiculos> getVehiculos(int idcategoria) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Vehiculos> vehiculos=miSesion.createQuery("from Vehiculos where idcategoria=:idcategoria", 
				Vehiculos.class).setParameter("idcategoria", idcategoria).list();
		return vehiculos;
	}

	@Override
	public void save(Vehiculos vehiculo) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(vehiculo);
	}

	@Override
	public Vehiculos getVehiculo(int idvehiculo) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Vehiculos.class, idvehiculo);
	}

	@Override
	public void delete(Vehiculos vehiculo) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(vehiculo);
	}
}
