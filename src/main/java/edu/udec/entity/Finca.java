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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Finca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idFinca;
	
	@NotNull(message = "El nombre de la finca es requerido")
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@NotNull(message = "El campo direccion es requerido")
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Pattern(regexp = "[0-9]+", message="El telefono solo puede tener números")
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	@Pattern(regexp = "[0-9]+", message="El celular solo puede tener números")
	@NotEmpty(message = "El campo celular no puede estar vacio")
	@NotNull(message = "El campo celular es requerido")
	@Column(name = "celular", nullable = false)
	private String celular;
	
	@NotNull(message = "El campo correo es requerido")
	@Email(message = "el correo debe ser valido")
	@Column(name = "correo", nullable = false)
	private String correo;
	
	@Column(name = "foto", nullable = false)
	private String foto;
	
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_usuario"))
	private Usuario usuario;

	public Integer getIdFinca() {
		return idFinca;
	}

	public void setIdFinca(Integer idFinca) {
		this.idFinca = idFinca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@JsonIgnore
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
