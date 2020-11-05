package edu.udec.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name =  "pedido_solicitud")
@IdClass(PedidoSolicitudPK.class)
public class PedidoSolicitud {
	
	@Id
	private Usuario usuario;
	
	@Id
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "valor_total", nullable = false)
	private Integer valorTotal;
	
	@Column(name = "confirmacion", nullable = false)
	private String confirmacion;
	
	@Column(name = "calificacion", nullable = false)
	private Integer calificacion;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	@Column(name = "fecha")
	private LocalDateTime fecha;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

}
