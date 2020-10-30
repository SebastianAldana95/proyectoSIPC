package edu.udec.dto;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import edu.udec.entity.Usuario;

public class NotificacionDto {
	
	private Integer idNotificacion;
	
	@NotNull(message = "El campo titulo es requerido")
	@Column(name = "titulo", nullable = false, length = 25)
	private String titulo;
	
	@NotNull(message = "El descripcion titulo es requerido")
	@Column(name = "descripcion", nullable = false, length = 60)
	private String descripcion;
	
	@NotNull(message = "El objeto usuario es requerido")
	@ManyToOne
	@JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_usuario"))
	private Usuario usuario;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(Integer idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

}
