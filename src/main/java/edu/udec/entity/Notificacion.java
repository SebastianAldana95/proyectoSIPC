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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Notificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idNotificacion;
	
	@NotNull(message = "El campo titulo es requerido")
	@Column(name = "titulo", nullable = false, length = 25)
	private String titulo;
	
	@NotNull(message = "El descripcion titulo es requerido")
	@Column(name = "descripcion", nullable = false, length = 60)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_usuario"))
	private Usuario usuario;

	public Integer getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(Integer idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

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

	@JsonIgnore
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
