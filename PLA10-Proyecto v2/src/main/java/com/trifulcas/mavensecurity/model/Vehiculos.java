package com.trifulcas.mavensecurity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.trifulcas.mavensecurity.validation.ValidarPrecio;

@Entity
@Table(name = "vehiculos")
public class Vehiculos {
	@Id
	@Column(name = "idvehiculo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvehiculo;	
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH,	 CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="idcategoria")
	private Categorias categoria;
	
	@Column(name = "vehiculoModelo")
	private String vehiculoModelo;	
	
	@Column(name = "vehiculoColor")
	private String vehiculoColor;	
	
	@Column(name = "vehiculoPrecio")
	@ValidarPrecio
	private String vehiculoPrecio;	
	
	
	// GETTERS Y SETTERS
	public int getIdvehiculo() {
		return idvehiculo;
	}
	public void setIdvehiculo(int idvehiculo) {
		this.idvehiculo = idvehiculo;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public String getVehiculoModelo() {
		return vehiculoModelo;
	}
	public void setVehiculoModelo(String vehiculoModelo) {
		this.vehiculoModelo = vehiculoModelo;
	}
	public String getVehiculoColor() {
		return vehiculoColor;
	}
	public void setVehiculoColor(String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}
	public String getVehiculoPrecio() {
		return vehiculoPrecio;
	}
	public void setVehiculoPrecio(String vehiculoPrecio) {
		this.vehiculoPrecio = vehiculoPrecio;
	}	
}
