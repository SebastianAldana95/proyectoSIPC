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

import edu.udec.dto.PedidoSolicitudDto;
import edu.udec.entity.PedidoSolicitud;
import edu.udec.service.IPedidoSolicitudService;

@RestController
@RequestMapping("/pedidosolicitudes")
public class PedidoSolicitudController {
	
	@Autowired
	private IPedidoSolicitudService pedidoSolicitudService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<PedidoSolicitud>> listarPedidosSolicitudes(){
		List<PedidoSolicitud> pedidoSolicitud = pedidoSolicitudService.listar();
		return new ResponseEntity<List<PedidoSolicitud>>(pedidoSolicitud, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<PedidoSolicitud> listarPorId(@PathVariable Integer id) {
		PedidoSolicitud pedidoSolicitud = pedidoSolicitudService.listarId(id);
		return new ResponseEntity<PedidoSolicitud>(pedidoSolicitud, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<PedidoSolicitudDto> guardarPedidoSolicitud(@Valid @RequestBody PedidoSolicitud obj){
		PedidoSolicitudDto pedidoSolicitud = pedidoSolicitudService.guardarDto(obj);
		return new ResponseEntity<PedidoSolicitudDto>(pedidoSolicitud, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{idProducto}/{idUsuario}")
	public ResponseEntity<Object> borrarPedidoSolicitud(@PathVariable Integer idProducto, @PathVariable Integer idUsuario){
		pedidoSolicitudService.eliminarPedidoSolicitud(idProducto, idUsuario);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
