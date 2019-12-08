package com.trifulcas.mavensecurity.services;

import java.util.List;

import com.trifulcas.mavensecurity.model.Vehiculos;

public interface IVehiculosService {
	List<Vehiculos> getVehiculos();
	
	List<Vehiculos> getVehiculos(int id);

	void save(Vehiculos vehiculo);

	Vehiculos getVehiculo(int idvehiculo);

	void delete(Vehiculos vehiculo);
}