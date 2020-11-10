package edu.udec.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.entity.PedidoSolicitud;
import edu.udec.entity.Producto;
import edu.udec.entity.Usuario;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.IPedidoSolicitudRepo;
import edu.udec.repository.IProductoRepo;
import edu.udec.repository.IUsuarioRepo;
import edu.udec.service.IPedidoSolicitudService;

@Service
public class PedidoSolicitudServiceImp implements IPedidoSolicitudService{

	@Autowired
	private IPedidoSolicitudRepo pedidoSolicitudRepo;
	
	@Autowired
	private IProductoRepo productoRepo;
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public List<PedidoSolicitud> listar() {
	
		return pedidoSolicitudRepo.findAll();
	}

	@Override
	public PedidoSolicitud listarId(Integer id) {
		
		PedidoSolicitud pedidoSolicitud = pedidoSolicitudRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Pedido o solicitud no encontrada"));

		return pedidoSolicitud;
	}

	@Transactional
	@Override
	public PedidoSolicitud guardar(PedidoSolicitud t) {
		
		int i = 2;
		/*
		if ((t.getUsuario() != null) && (t.getProducto() != null)) {
			Usuario usuario = usuarioRepo.findById(t.getUsuario().getIdUsuario()).orElseThrow(
					() -> new NotFoundException("Usuario no existe"));
			
			Producto producto = productoRepo.findById(t.getProducto().getIdProducto()).orElseThrow(
					() -> new NotFoundException("Producto no existe"));
			
			// Calculo del valor total para persona natural
			Integer valorTotal = null;		
			if(usuario.getRol().getIdRol() == 4) {		
				valorTotal = producto.getPrecioUnitario() * t.getCantidad();
			}
			// Calculo del valor total para un comerciante o mayorista	
			if(usuario.getRol().getIdRol() == 2 || usuario.getRol().getIdRol() == 3) {
				valorTotal = producto.getPrecioMayorista() * t.getCantidad();
			}
			
			PedidoSolicitud pedidoSolicitud = new PedidoSolicitud();
			pedidoSolicitud.setCantidad(t.getCantidad());
			pedidoSolicitud.setValorTotal(valorTotal);
			pedidoSolicitud.setConfirmacion(t.getConfirmacion());
			pedidoSolicitud.setCalificacion(t.getCalificacion());
			pedidoSolicitud.setUsuario(usuario);
			pedidoSolicitud.setProducto(producto);	
			
			return pedidoSolicitudRepo.save(pedidoSolicitud);
		}
		
		throw new ArgumentRequiredException("No se pudo completar la accion se requiere un usuario y un producto!");
		
		*/
		
		if ((t.getUsuario() != null) && (t.getProducto() != null)) {
			Usuario usuario = usuarioRepo.findById(t.getUsuario().getIdUsuario()).orElseThrow(
					() -> new NotFoundException("Usuario no existe"));
			
			Producto producto = productoRepo.findById(t.getProducto().getIdProducto()).orElseThrow(
					() -> new NotFoundException("Producto no existe"));
			
			// Calculo del valor total para persona natural
			Integer valorTotal = null;		
			if(usuario.getRol().getIdRol() == 4) {		
				valorTotal = producto.getPrecioUnitario() * t.getCantidad();
			}
			// Calculo del valor total para un comerciante o mayorista	
			if(usuario.getRol().getIdRol() == 2 || usuario.getRol().getIdRol() == 3) {
				valorTotal = producto.getPrecioMayorista() * t.getCantidad();
			}
			
			//LocalDateTime fecha = LocalDateTime.now();
			
			pedidoSolicitudRepo.guardar(t.getProducto().getIdProducto(), t.getUsuario().getIdUsuario(), t.getCantidad(), valorTotal, t.getCalificacion(), t.getConfirmacion());
			//return t;
			
			PedidoSolicitud pedidoSolicitud = pedidoSolicitudRepo.findByIdProducto(t.getProducto().getIdProducto());
			return pedidoSolicitud;
			
			//PedidoSolicitud pedidoSolicitud = pedidoSolicitudRepo.findByIdProducto(t.getProducto().getIdProducto());			
			//return pedidoSolicitud;
			
		}
		
		throw new ArgumentRequiredException("No se pudo completar la accion se requiere un usuario y un producto!");
		
	}

	@Override
	public void eliminar(Integer id) {
		
		if (pedidoSolicitudRepo.existsById(id)) {
			pedidoSolicitudRepo.deleteById(id);
		} else {
			throw new NotFoundException("Pedido o solicitud no existe!");
		}
		
		
	}

}
