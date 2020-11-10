package edu.udec.service;

import edu.udec.dto.CategoriaDto;
import edu.udec.entity.Categoria;

public interface ICategoriaService extends ServiceGneneric<Categoria, CategoriaDto>{

	public Categoria guardarCategoriaDto(CategoriaDto categoriaDto);
	
}
