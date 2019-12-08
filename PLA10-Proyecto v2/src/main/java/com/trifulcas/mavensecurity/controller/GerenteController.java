package com.trifulcas.mavensecurity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.mavensecurity.model.Categorias;
import com.trifulcas.mavensecurity.model.Vehiculos;
import com.trifulcas.mavensecurity.services.ICategoriasService;
import com.trifulcas.mavensecurity.services.IVehiculosService;

@Controller
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	private ICategoriasService categoriaService;
	@Autowired
	private IVehiculosService vehiculosService;

	@GetMapping("/addcategoria")
	public String addCategorias(Model modelo) {
		Categorias categoria = new Categorias();
		modelo.addAttribute(categoria);
		return "form-categoria";
	}

	@PostMapping("/savecategoria")
	public String saveCategorias(@ModelAttribute("categoria") Categorias categoria) {

		categoriaService.save(categoria);
		return "redirect:/index";
	}

	@GetMapping("updatecategoria")
	public String updateCategorias(@RequestParam("idcategoria") int idcategoria, Model modelo) {

		Categorias categoria = categoriaService.getCategoria(idcategoria);
		modelo.addAttribute(categoria);
		return "form-categoria";
	}

	@GetMapping("/addvehiculo")
	public String addproduct(Model modelo) {
		Vehiculos vehiculo = new Vehiculos();
		modelo.addAttribute(vehiculo);

		List<Categorias> categorias = categoriaService.getCategorias();
		modelo.addAttribute("categorias", categorias);

		return "form-vehiculoNuevo";
	}

	@RequestMapping(path = "/savevehiculos", method = RequestMethod.POST)
	public String saveVehiculos(@Valid @ModelAttribute("vehiculos") Vehiculos vehiculo, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) { 
			List<Categorias> categorias = categoriaService.getCategorias();
			modelo.addAttribute("categorias", categorias);
			return "form-vehiculoNuevo";}
		else { 
				
				vehiculosService.save(vehiculo);
				
			
			return "redirect:/index"; 
			}
	}

	@GetMapping("updatevehiculo")
	public String updateVehiculo(@Valid @RequestParam("idvehiculo") int idvehiculo, Model modelo ) {
		List<Categorias> categorias = categoriaService.getCategorias();
		Vehiculos vehiculo = vehiculosService.getVehiculo(idvehiculo);
		modelo.addAttribute("categorias", categorias);
		
		modelo.addAttribute(vehiculo);
			return "form-vehiculoNuevo";
		}
	

}