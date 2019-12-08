package com.trifulcas.mavensecurity.services;

import java.util.List;

import com.trifulcas.mavensecurity.model.Categorias;

public interface ICategoriasService {
	List<Categorias> getCategorias();

	void save(Categorias categoria);

	Categorias getCategoria(int idcategoria);

	void delete(Categorias categoria);
}