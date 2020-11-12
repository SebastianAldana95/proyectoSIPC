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

import edu.udec.dto.FincaDto;
import edu.udec.entity.Finca;
import edu.udec.service.IFincaService;

@RestController
@RequestMapping("/fincas")
public class FincaController {
	
	@Autowired
	private IFincaService fincaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Finca>> listarFincas(){
		List<Finca> listaFincas = fincaService.listar();
		return new ResponseEntity<List<Finca>>(listaFincas, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Finca> listarPorId(@PathVariable Integer id) {
		Finca finca = fincaService.listarId(id);
		return new ResponseEntity<Finca>(finca, HttpStatus.OK);
	}
	
	@GetMapping("/listarIdUsuario/{idUsuario}")
	public ResponseEntity<List<Finca>> listarFincasPorIdUsuario(@PathVariable Integer idUsuario){
		List<Finca> listaFincas = fincaService.listaFincaPorIdUsuario(idUsuario);
		return new ResponseEntity<List<Finca>>(listaFincas, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Finca> guardarFinca(@Valid @RequestBody FincaDto obj){
		Finca finca = fincaService.guardarDto(obj);
		return new ResponseEntity<Finca>(finca, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> borrarFinca(@PathVariable Integer id){
		fincaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Finca> editar(@RequestBody FincaDto obj) {
		Finca finca = fincaService.editarDto(obj);
		return new ResponseEntity<Finca>(finca, HttpStatus.OK);
	}

}
