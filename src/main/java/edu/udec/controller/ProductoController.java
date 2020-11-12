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

import edu.udec.entity.Producto;
import edu.udec.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productosService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listarProductos(){
		List<Producto> listaProductos = productosService.listar();
		return new ResponseEntity<List<Producto>>(listaProductos, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable Integer id) {
		Producto producto = productosService.listarId(id);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@GetMapping("/listarNombreCategoria/{nombre}")
	public ResponseEntity<List<Producto>> listarPorNombreCategoria(@PathVariable String nombre) {
		List<Producto> productos = productosService.listarProductoPorNombreCategoria(nombre);
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/listarIdEmpresa/{idEmpresa}")
	public ResponseEntity<List<Producto>> listarPorIdEmpresa(@PathVariable Integer idEmpresa) {
		List<Producto> productos = productosService.listaProductoPorIdEmpresa(idEmpresa);
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/listarIdFinca/{idFinca}")
	public ResponseEntity<List<Producto>> listarPorIdFinca(@PathVariable Integer idFinca) {
		List<Producto> productos = productosService.listaProductoPorIdFinca(idFinca);
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Producto> guardarProducto(@Valid @RequestBody Producto obj){
		Producto producto = productosService.guardar(obj);
		return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> borrarProducto(@PathVariable Integer id){
		productosService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Producto> editarProducto(@RequestBody Producto obj) {
		Producto producto = productosService.editarProducto(obj);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

}
