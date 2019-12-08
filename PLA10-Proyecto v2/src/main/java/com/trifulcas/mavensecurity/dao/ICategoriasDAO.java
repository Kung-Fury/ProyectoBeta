package com.trifulcas.mavensecurity.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trifulcas.mavensecurity.model.Categorias;

@Service
public interface ICategoriasDAO {
	List<Categorias> getCategorias();

	void save(Categorias categoria);

	Categorias getCategoria(int idcategoria);
	
	void delete(Categorias categoria);
}
