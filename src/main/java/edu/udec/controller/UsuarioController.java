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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.udec.entity.Usuario;
import edu.udec.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> listaUsuarios = usuarioService.listar();
		return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable Integer id) {
		Usuario usuario = usuarioService.listarId(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
				
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuario> guardarUsuario(@Valid @RequestBody Usuario obj){
		Usuario usuario = usuarioService.guardar(obj);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> borrarUsuario(@PathVariable Integer id){
		usuarioService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Usuario> editar(@RequestBody Usuario obj) {
		Usuario usuario = usuarioService.editar(obj);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}
