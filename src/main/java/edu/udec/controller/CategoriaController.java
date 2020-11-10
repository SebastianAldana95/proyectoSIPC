package edu.udec.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.udec.dto.CategoriaDto;
import edu.udec.entity.Categoria;
import edu.udec.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Categoria>> listarCategorias(){
		List<Categoria> listaCategorias = categoriaService.listar();
		return new ResponseEntity<List<Categoria>>(listaCategorias, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Categoria> listarPorId(@PathVariable Integer id) {
		Categoria categoria = categoriaService.listarId(id);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Categoria> guardarCategoria(@Valid @RequestBody CategoriaDto obj){
		Categoria categoria = categoriaService.guardarCategoriaDto(obj);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> borrarCategoria(@PathVariable Integer id){
		categoriaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
