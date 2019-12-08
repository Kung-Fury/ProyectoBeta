package com.trifulcas.mavensecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trifulcas.mavensecurity.dao.IAuthoritiesDAO;
import com.trifulcas.mavensecurity.model.Authorities;

@Service("authoritiesService")
public class AuthoritiesService implements IAuthoritiesService {

	@Autowired
	private IAuthoritiesDAO authorityDAO;

	@Override
	@Transactional
	public void save(Authorities autoridad) {
		authorityDAO.save(autoridad);
	}

	@Override
	@Transactional
	public Authorities getAuthority(String autoridad) {
		return authorityDAO.getAuthority(autoridad);
	}

	@Override
	@Transactional
	public void delete(Authorities autoridad) {
		authorityDAO.delete(autoridad);
	}

	@Override
	@Transactional
	public List<Authorities> getAuthority() {
		return authorityDAO.getAuthority();
	}
}