package edu.udec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCategoria;
	
	@Column(name = "nombre", nullable = false, length = 45)
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
