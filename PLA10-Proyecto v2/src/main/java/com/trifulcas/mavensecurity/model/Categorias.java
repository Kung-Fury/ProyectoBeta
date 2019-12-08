package com.trifulcas.mavensecurity.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias {
	@Id
	@Column(name = "idcategoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcategoria;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="categoria", cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Vehiculos> vehiculos;
	
	@Column(name = "categoriaNombre")
	private String categoriaNombre;
	
	public List<Vehiculos> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculos> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public void addVehiculos(Vehiculos vehiculo) {
		if (vehiculos == null) {
			vehiculos = new ArrayList<Vehiculos>();
		}
		vehiculos.add(vehiculo);
		vehiculo.setCategoria(this);
	}

	public Categorias() {
	}
	
	public Categorias(String categoriaNombre) {
		super();
		this.categoriaNombre = categoriaNombre;	
	}
		
		// GETTERS Y SETTERS
		public int getIdcategoria() {
			return idcategoria;
		}
		public void setIdcategoria(int idcategoria) {
			this.idcategoria = idcategoria;
		}
		public String getCategoriaNombre() {
			return categoriaNombre;
		}
		public void setCategoriaNombre(String categoriaNombre) {
			this.categoriaNombre = categoriaNombre;
		}
}
