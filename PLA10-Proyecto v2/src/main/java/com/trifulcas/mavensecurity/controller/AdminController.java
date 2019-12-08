package com.trifulcas.mavensecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.mavensecurity.model.Authorities;
import com.trifulcas.mavensecurity.model.Categorias;
import com.trifulcas.mavensecurity.model.User;
import com.trifulcas.mavensecurity.model.Vehiculos;
import com.trifulcas.mavensecurity.services.IAuthoritiesService;
import com.trifulcas.mavensecurity.services.ICategoriasService;
import com.trifulcas.mavensecurity.services.IUserService;
import com.trifulcas.mavensecurity.services.IVehiculosService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ICategoriasService categoriaService;
	@Autowired
	private IVehiculosService vehiculoService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IAuthoritiesService authorityService;

	@GetMapping("/deletecategoria")
	public String deleteCategory(@RequestParam("idcategoria") int idcategoria) {
		Categorias categoria = categoriaService.getCategoria(idcategoria);
		categoriaService.delete(categoria);

		return "redirect:/index";
	}

	@GetMapping("/deletevehiculo")
	public String deleteVehiculo(@RequestParam("idvehiculo") int idvehiculo) {
		Vehiculos vehiculo = vehiculoService.getVehiculo(idvehiculo);
		int idcategoria=vehiculo.getCategoria().getIdcategoria();
		vehiculoService.delete(vehiculo);

		return "redirect:/vehiculos?id="+idcategoria;
	}
	
	@GetMapping("/adduser")
	public String addUser(Model modelo) {
		User usuario = new User();
		modelo.addAttribute(usuario);
		Authorities autoridad = new Authorities();  // Se han añadido las 2 siguientes líneas de autoridad
		modelo.addAttribute(autoridad);
		return "form-usuario";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") User usuario) {
		userService.save(usuario);
		return "redirect:/admin/index-usuarios";
	}	
	
	@PostMapping("/saveauthority")
	public String saveAutoridad(@ModelAttribute("authority") Authorities autoridad) {
		authorityService.save(autoridad);
		return "redirect:/admin/index-usuarios";
	}	

	@GetMapping("updateuser")
	public String updateUser(@RequestParam("username") String username, Model modelo) {
		User usuario = userService.getUser(username);
		modelo.addAttribute(usuario);
		return "form-usuario";
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("username") String username) {
		User usuario = userService.getUser(username);
		userService.delete(usuario);

		return "redirect:/admin/index-usuarios";
	}
	
	@GetMapping("/index-usuarios")
	public String usuarios(Model modelo) {

		List<User> usuarios = userService.getUser();
		modelo.addAttribute("user", usuarios);
		
		List<Authorities> authorities = authorityService.getAuthority();
		modelo.addAttribute("authority", authorities);

		return "index-usuarios";
	}	
}