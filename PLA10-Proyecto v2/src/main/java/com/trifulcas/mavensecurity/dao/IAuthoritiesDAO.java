package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trifulcas.mavensecurity.model.Authorities;

@Service
public interface IAuthoritiesDAO {

	void save(Authorities autoridad);

	Authorities getAuthority(String autoridad);
	
	void delete(Authorities autoridad);
	
	List<Authorities> getAuthority();
}