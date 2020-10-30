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
public class Pqr {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idPqr;
	
	@NotNull(message = "El campo solicitud es requerido")
	@Column(name = "solicitud", nullable = false, length = 25)
	private String solicitud;
	
	@NotNull(message = "El campo motivo es requerido")
	@Column(name = "motivo", nullable = false, length = 60)
	private String motivo;
	
	@NotNull(message = "Objeto Usuario atributo id es requerido")
	@ManyToOne
	@JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_usuario"))
	private Usuario usuario;

	public Integer getIdPqr() {
		return idPqr;
	}

	public void setIdPqr(Integer idPqr) {
		this.idPqr = idPqr;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@JsonIgnore
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
