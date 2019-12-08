package com.trifulcas.mavensecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trifulcas.mavensecurity.dao.ICategoriasDAO;
import com.trifulcas.mavensecurity.model.Categorias;

@Service("categoriasService")
public class CategoriasService implements ICategoriasService {

	@Autowired
	private ICategoriasDAO categoriasDAO;

	@Override
	@Transactional
	public List<Categorias> getCategorias() {
		return categoriasDAO.getCategorias();
	}

	@Override
	@Transactional
	public void save(Categorias categoria) {
		categoriasDAO.save(categoria);
	}

	@Override
	@Transactional
	public Categorias getCategoria(int idcategoria) {
		
		return categoriasDAO.getCategoria(idcategoria);
	}

	@Override
	@Transactional
	public void delete(Categorias categoria) {
		categoriasDAO.delete(categoria);
	}
}