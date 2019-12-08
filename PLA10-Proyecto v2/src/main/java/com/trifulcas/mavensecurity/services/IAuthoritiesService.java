package com.trifulcas.mavensecurity.services;

import java.util.List;

import com.trifulcas.mavensecurity.model.Authorities;

public interface IAuthoritiesService {
	void save(Authorities autoridad);

	Authorities getAuthority(String autoridad);
	
	void delete(Authorities autoridad);
	
	List<Authorities> getAuthority();
}