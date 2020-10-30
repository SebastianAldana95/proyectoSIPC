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

import edu.udec.dto.NotificacionDto;
import edu.udec.entity.Notificacion;
import edu.udec.service.INotificacionService;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
	
	@Autowired
	INotificacionService notificacionService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Notificacion>> listarNotificacion(){
		List<Notificacion> listaNotificaciones = notificacionService.listar();
		return new ResponseEntity<List<Notificacion>>(listaNotificaciones, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Notificacion> listarNotificacionPorId(@PathVariable Integer id){
		Notificacion notificacion = notificacionService.listarId(id);
		return new ResponseEntity<Notificacion>(notificacion, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Notificacion> guardarNotificacion(@Valid @RequestBody NotificacionDto obj){
		Notificacion notificacion = notificacionService.guardarDto(obj);
		return new ResponseEntity<Notificacion>(notificacion, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> borrarNotificacion(@PathVariable Integer id){
		notificacionService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Notificacion> editar(@RequestBody NotificacionDto obj) {
		Notificacion notificacion = notificacionService.editarDto(obj);
		return new ResponseEntity<Notificacion>(notificacion, HttpStatus.OK);
	}

}
