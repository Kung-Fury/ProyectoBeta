package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trifulcas.mavensecurity.model.Vehiculos;

@Service
public interface IVehiculosDAO {
	List<Vehiculos> getVehiculos();

	List<Vehiculos> getVehiculos(int id);
	
	void save(Vehiculos vehiculo);

	Vehiculos getVehiculo(int idvehiculo);
	
	void delete(Vehiculos vehiculo);
}
