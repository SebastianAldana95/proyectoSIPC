package edu.udec.dto;

public class ProductoDto {
	
	private Integer idProducto;
	private Integer codigo;
	private String nombre;
	private String descripcion;
	private String foto;
	private Integer precioUnitario;
	private Integer precioMayorista;
	private Integer idEmpresa;
	private Integer idFinca;
	
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
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdFinca() {
		return idFinca;
	}
	public void setIdFinca(Integer idFinca) {
		this.idFinca = idFinca;
	}

}
