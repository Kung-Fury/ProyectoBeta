package com.trifulcas.mavensecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.mavensecurity.model.Categorias;
import com.trifulcas.mavensecurity.model.Vehiculos;
import com.trifulcas.mavensecurity.services.ICategoriasService;
import com.trifulcas.mavensecurity.services.IVehiculosService;

@Controller
public class AppController {

	@Autowired
	private ICategoriasService categoriasService;
	@Autowired
	private IVehiculosService vehiculosService;

	@GetMapping("/")
	public String inicio() {
		return "login";
	}
	
	@GetMapping("/index")
	public String index(Model modelo) {

		List<Categorias> categorias = categoriasService.getCategorias();

		modelo.addAttribute("categorias", categorias);

		return "index";
	}

	
	@GetMapping("/vehiculos")
	public String vehiculos(Model modelo, @RequestParam int id) {
		
		List<Vehiculos> vehiculos = vehiculosService.getVehiculos(id);
		Categorias categorias=categoriasService.getCategoria(id);
		modelo.addAttribute("vehiculos", vehiculos);
		modelo.addAttribute("categorias", categorias);

		return "vehiculos";
	}
	
}