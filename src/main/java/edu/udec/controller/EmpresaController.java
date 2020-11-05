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

import edu.udec.dto.EmpresaDto;
import edu.udec.entity.Empresa;
import edu.udec.service.IEmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Empresa>> listarEmpresas(){
		List<Empresa> listaEmpresas = empresaService.listar();
		return new ResponseEntity<List<Empresa>>(listaEmpresas, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Empresa> listarPorId(@PathVariable Integer id) {
		Empresa empresa = empresaService.listarId(id);
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
				
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Empresa> guardarEmpresa(@Valid @RequestBody EmpresaDto obj){
		Empresa empresa = empresaService.guardarDto(obj);
		return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> borrarEmpresa(@PathVariable Integer id){
		empresaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Empresa> editar(@RequestBody EmpresaDto obj) {
		Empresa empresa = empresaService.editarDto(obj);
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}
	

}
