package edu.udec.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.dto.CategoriaDto;
import edu.udec.entity.Categoria;
import edu.udec.entity.Producto;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.ICategoriaRepo;
import edu.udec.repository.IProductoRepo;
import edu.udec.service.ICategoriaService;

@Service
public class CategoriaServiceImp implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepo categoriaRepo;
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public List<Categoria> listar() {
		
		return categoriaRepo.findAll();
	}

	@Override
	public Categoria listarId(Integer id) {
		
		Categoria categoria = categoriaRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Categoria no encontrada"));
		
		return categoria;
	}

	@Override
	public Categoria guardar(Categoria t) {
		/*
		if (t.getProducto() != null ) {
			Producto producto = productoRepo.findById(t.getProducto().getIdProducto()).orElseThrow(
					() -> new NotFoundException("Producto no existe"));
			
			Categoria categoria = new Categoria();
			categoria.setNombre(t.getNombre());
			categoria.setProducto(producto);
			categoria.getProducto().setEmpresa(null);
			categoria.getProducto().setFinca(null);
			return categoriaRepo.save(categoria);
		}
		
		t.getProducto().setEmpresa(null);
		t.getProducto().setFinca(null);
		return categoriaRepo.save(t);
		*/
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		
		if (categoriaRepo.existsById(id)) {
			categoriaRepo.deleteById(id);
		} else {
			throw new NotFoundException("Categoria no existe!");
		}
		
	}

	@Override
	public Categoria guardarCategoriaDto(CategoriaDto categoriaDto) {
		
		if (categoriaDto.getProducto() != null ) {
			Producto producto = productoRepo.findById(categoriaDto.getProducto().getIdProducto()).orElseThrow(
					() -> new NotFoundException("Producto no existe"));
			
			Categoria categoria = new Categoria();
			categoria.setNombre(categoriaDto.getNombre());
			categoria.setProducto(producto);
			categoria.getProducto().setEmpresa(null);
			categoria.getProducto().setFinca(null);
			return categoriaRepo.save(categoria);
		}
		
		Categoria categoria = new Categoria();
		categoria.setNombre(categoriaDto.getNombre());
		return categoriaRepo.save(categoria);
		
	}

}
