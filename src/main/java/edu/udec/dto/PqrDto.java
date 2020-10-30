package edu.udec.dto;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import edu.udec.entity.Usuario;

public class PqrDto {
	
	private Integer idPqr;
	
	@NotNull(message = "El campo solicitud es requerido")
	@Column(name = "solicitud", nullable = false, length = 25)
	private String solicitud;
	
	@NotNull(message = "El campo motivo es requerido")
	@Column(name = "motivo", nullable = false, length = 120)
	private String motivo;
	
	@NotNull(message = "Objeto Usuario atributo id es requerido")
	@ManyToOne
	@JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_usuario"))
	private Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getIdPqr() {
		return idPqr;
	}

	public void setIdPqr(Integer idPqr) {
		this.idPqr = idPqr;
	}
	
	

}
