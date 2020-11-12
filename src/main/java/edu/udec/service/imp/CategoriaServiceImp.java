package edu.udec.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.entity.Categoria;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.ICategoriaRepo;
import edu.udec.service.ICategoriaService;

@Service
public class CategoriaServiceImp implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepo categoriaRepo;

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
		
		/*if (t.getProducto().getIdProducto() == null) {
			throw new ArgumentRequiredException("IdProducto es requerido");
		} else {
			if(!productoRepo.existsById(categoriaDto.getProducto().getIdProducto())) {
				throw new NotFoundException("Producto no encontrado");
			}
		}*/
		
		return categoriaRepo.save(t);
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
	public Categoria editarCategoria(Categoria categoria) {
		
		if (categoria.getIdCategoria() == null ) {
			throw new ArgumentRequiredException("Campo id categoria es requerido");
		}
		
		Categoria newCategoria = categoriaRepo.findById(categoria.getIdCategoria()).orElseThrow(
				() -> new NotFoundException("Categoria no encontrada"));
		
		if (categoria.getNombre() != null ) {
			newCategoria.setNombre(categoria.getNombre());
		}
		
		return categoriaRepo.save(newCategoria);
	}

	@Override
	public List<Categoria> listarPorNombreCategoria(String nombre) {
		
		List<Categoria> categorias = categoriaRepo.findByNombre(nombre);
		return categorias;
	}

}
