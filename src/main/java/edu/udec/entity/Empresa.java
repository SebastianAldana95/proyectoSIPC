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
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idEmpresa;
	
	@NotNull(message = "El tipo de la empresa es requerido")
	@Column(name = "tipo", nullable = false, length = 45)
	private String tipo;
	
	@NotNull(message = "El campo nombre es requerido")
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@NotNull(message = "El campo correo es requerido")
	@Email(message = "el correo debe ser valido")
	@Column(name = "correo", nullable = false)
	private String correo;
	
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
	
	@NotNull(message = "El campo RUT es requerido")
	@Column(name = "rut", nullable = false)
	private String rut;
	
	@Column(name = "foto", nullable = false)
	private String foto;
	
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_usuario"))
	private Usuario usuario;
	
	public Empresa() {
	}

	public Empresa(Integer idEmpresa, @NotNull(message = "El campo nombre es requerido") String nombre,
			@NotNull(message = "El campo correo es requerido") @Email(message = "el correo debe ser valido") String correo,
			@NotNull(message = "El campo direccion es requerido") String direccion,
			@Pattern(regexp = "[0-9]+", message = "El telefono solo puede tener números") String telefono,
			@Pattern(regexp = "[0-9]+", message = "El celular solo puede tener números") @NotEmpty(message = "El campo celular no puede estar vacio") @NotNull(message = "El campo celular es requerido") String celular) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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
