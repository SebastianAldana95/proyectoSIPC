package edu.udec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCategoria;
	
	@NotNull(message = "El nombre de la categoria es requerido")
	@Column(name = "nombre", nullable = false)
	private String nombre;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
