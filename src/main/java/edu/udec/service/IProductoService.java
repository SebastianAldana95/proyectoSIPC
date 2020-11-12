package edu.udec.service;

import java.util.List;

import edu.udec.dto.ProductoDto;
import edu.udec.entity.Producto;

public interface IProductoService extends ServiceGneneric<Producto, ProductoDto>{
	
	public Producto editarProducto(Producto t);
	public List<Producto> listarProductoPorNombreCategoria(String nombre);
	public List<Producto> listaProductoPorIdEmpresa(Integer idEmpresa);
	public List<Producto> listaProductoPorIdFinca(Integer idFinca);
}
