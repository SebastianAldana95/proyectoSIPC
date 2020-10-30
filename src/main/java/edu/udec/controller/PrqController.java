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

import edu.udec.dto.PqrDto;
import edu.udec.entity.Pqr;
import edu.udec.service.IPqrService;

@RestController
@RequestMapping("/pqrs")
public class PrqController {
	
	@Autowired
	IPqrService pqrService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Pqr>> listarPqrs(){
		List<Pqr> listaPqrs = pqrService.listar();
		return new ResponseEntity<List<Pqr>>(listaPqrs, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Pqr> listarPqrsPorId(@PathVariable Integer id){
		Pqr pqr = pqrService.listarId(id);
		return new ResponseEntity<Pqr>(pqr, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Pqr> guardarPqr(@Valid @RequestBody PqrDto obj){
		Pqr pqr = pqrService.guardarDto(obj);
		return new ResponseEntity<Pqr>(pqr, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> borrarPqr(@PathVariable Integer id){
		pqrService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Pqr> editar(@RequestBody PqrDto obj) {
		Pqr pqr = pqrService.editarDto(obj);
		return new ResponseEntity<Pqr>(pqr, HttpStatus.OK);
	}
	

}
