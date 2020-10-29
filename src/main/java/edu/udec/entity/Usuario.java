package edu.udec.entity;

import java.time.LocalDate;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@NotNull(message = "El campo cedula es requerido")
	@Pattern(regexp = "[0-9]+", message="El campo cedula solo puede contener numeros")
	@Size(min = 6, max = 12, message="El campo cedula solo puede tener entre 6 y 12 caracteres")
	@Column(name = "cedula", nullable = false, length = 12)
	private String cedula;
	
	@NotNull(message = "El campo nombre es requerido")
	@Column(name = "nombre", nullable = false, length = 35)
	private String nombre;
	
	@NotNull(message = "El campo apellido es requerido")
	@Column(name = "apellido", nullable = false, length = 35)
	private String apellido;
	
	@NotNull(message = "El campo fechaNac es requerido")
	@Column(name = "fecha_nac", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private LocalDate fechaNac;
	
	@Email(message = "el correo debe ser valido")
	@Column(name = "correo", nullable = false)
	private String correo;
	
	@Pattern(regexp = "[0-9]+", message="El campo celular solo puede contener numeros")
	@Column(name = "celular", nullable = false)
	private String celular;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "foto", nullable = false)
	private String foto;
	
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@Column(name = "nick", nullable = false, length = 20, unique = true)
	private String nick;
	
	@Column(columnDefinition = "TEXT", name = "contrasena", nullable = false)
	private String contrasena;
	
	@NotNull(message = "Objeto rol atributo id es requerido")
	@ManyToOne
	@JoinColumn(name = "idRol", foreignKey = @ForeignKey(name = "FK_rol"))
	private Rol rol;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	

}
