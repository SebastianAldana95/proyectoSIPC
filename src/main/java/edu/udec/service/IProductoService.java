package edu.udec.service;

import edu.udec.dto.ProductoDto;
import edu.udec.entity.Producto;

public interface IProductoService extends ServiceGneneric<Producto, ProductoDto>{
	
	public Producto editarProducto(Producto t);
}
