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
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idProducto;
	
	@NotNull(message = "El codigo del producto es requerido")
	@Column(name = "codigo", nullable = false)
	private Integer codigo;
	
	@NotNull(message = "El nombre del producto es requerido")
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@NotNull(message = "La descripcion del producto es requerido")
	@Column(name = "descripcion", nullable = false, length = 80)
	private String descripcion;
	
	@NotNull(message = "La foto del producto es requerido")
	@Column(name = "foto", nullable = false)
	private String foto;
	
	@NotNull(message = "El precio unitario es requerido")
	@Column(name = "precio_unitario", nullable = false)
	private Integer precioUnitario;
	
	@NotNull(message = "El precio mayorista es requerido")
	@Column(name = "precio_mayorista", nullable = false)
	private Integer precioMayorista;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa", foreignKey = @ForeignKey(name = "FK_empresa"))
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "idFinca", foreignKey = @ForeignKey(name = "FK_finca"))
	private Finca finca;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getPrecioMayorista() {
		return precioMayorista;
	}

	public void setPrecioMayorista(Integer precioMayorista) {
		this.precioMayorista = precioMayorista;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Finca getFinca() {
		return finca;
	}

	public void setFinca(Finca finca) {
		this.finca = finca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}
	
	

}
