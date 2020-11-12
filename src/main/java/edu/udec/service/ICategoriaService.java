package edu.udec.service;

import java.util.List;

import edu.udec.dto.CategoriaDto;
import edu.udec.entity.Categoria;

public interface ICategoriaService extends ServiceGneneric<Categoria, CategoriaDto>{

	public Categoria editarCategoria(Categoria categoria);
	public List<Categoria> listarPorNombreCategoria(String nombre);
	
}
