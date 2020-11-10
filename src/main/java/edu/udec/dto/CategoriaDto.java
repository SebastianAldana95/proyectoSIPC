package edu.udec.dto;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import edu.udec.entity.Producto;

public class CategoriaDto {
	
	private Integer idCategoria;
	
	@NotNull(message = "El nombre de la categoria es requerido")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "idProducto", foreignKey = @ForeignKey(name = "FK_producto"))
	private Producto producto;

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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
