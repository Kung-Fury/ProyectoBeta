package com.trifulcas.mavensecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trifulcas.mavensecurity.dao.IVehiculosDAO;
import com.trifulcas.mavensecurity.model.Vehiculos;

@Service("vehiculosService")
public class VehiculosService implements IVehiculosService {

	@Autowired
	private IVehiculosDAO vehiculosDAO;

	@Override
	@Transactional
	public List<Vehiculos> getVehiculos() {
		return vehiculosDAO.getVehiculos();
	}

	@Override
	@Transactional
	public List<Vehiculos> getVehiculos(int idvehiculo) {
		return vehiculosDAO.getVehiculos(idvehiculo);
	}
	
	@Override
	@Transactional
	public void save(Vehiculos vehiculo) {
		vehiculosDAO.save(vehiculo);
	}

	@Override
	@Transactional
	public Vehiculos getVehiculo(int idvehiculo) {
		
		return vehiculosDAO.getVehiculo(idvehiculo);
	}

	@Override
	@Transactional
	public void delete(Vehiculos vehiculo) {
		vehiculosDAO.delete(vehiculo);
	}
}