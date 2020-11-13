package edu.udec.dto;

import java.time.LocalDateTime;

public class PedidoSolicitudDto {
	
	private Integer idUsuario;
	private Integer idProducto;
	private Integer cantidad;
	private Integer valorTotal;
	private String confirmacion;
	private Integer calificacion;
	private LocalDateTime fecha;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
