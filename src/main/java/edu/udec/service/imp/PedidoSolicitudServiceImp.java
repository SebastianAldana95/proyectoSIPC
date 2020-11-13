package edu.udec.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.dto.PedidoSolicitudDto;
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
	
		List<PedidoSolicitud> listaPedidos = pedidoSolicitudRepo.findAll();
		for (PedidoSolicitud pedidoSolicitud : listaPedidos) {
			pedidoSolicitud.setProducto(null);
			pedidoSolicitud.setUsuario(null);
		}
		return listaPedidos;
	}

	@Override
	public PedidoSolicitud listarId(Integer id) {
		
		/*PedidoSolicitud pedidoSolicitud = pedidoSolicitudRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Pedido o solicitud no encontrada"));

		return pedidoSolicitud;*/
		return null;
	}

	@Transactional
	@Override
	public PedidoSolicitud guardar(PedidoSolicitud t) {
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		
	}

	@Transactional
	@Override
	public PedidoSolicitudDto guardarDto(PedidoSolicitud t) {
		
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
			PedidoSolicitudDto pedidoSolicitudDto = new PedidoSolicitudDto();
			pedidoSolicitudDto.setIdUsuario(pedidoSolicitud.getUsuario().getIdUsuario());
			pedidoSolicitudDto.setIdProducto(pedidoSolicitud.getProducto().getIdProducto());
			pedidoSolicitudDto.setCantidad(pedidoSolicitud.getCantidad());
			pedidoSolicitudDto.setValorTotal(pedidoSolicitud.getValorTotal());
			pedidoSolicitudDto.setConfirmacion(pedidoSolicitud.getConfirmacion());
			pedidoSolicitudDto.setCalificacion(pedidoSolicitud.getCalificacion());
			pedidoSolicitudDto.setFecha(pedidoSolicitud.getFecha());
			return pedidoSolicitudDto;
			
			//PedidoSolicitud pedidoSolicitud = pedidoSolicitudRepo.findByIdProducto(t.getProducto().getIdProducto());			
			//return pedidoSolicitud;
			
		}
		
		throw new ArgumentRequiredException("No se pudo completar la accion se requiere un usuario y un producto!");
	}

	@Override
	public void eliminarPedidoSolicitud(Integer idProducto, Integer idUsuario) {
		
		if(idProducto != null && idUsuario != null) {
			if(usuarioRepo.existsById(idUsuario) && productoRepo.existsById(idProducto)) {
				pedidoSolicitudRepo.eliminarPedidoSolicitud(idProducto, idUsuario);
			} else {
				throw new NotFoundException("Producto o Usuario no existe!");
			}
		}
	}

	@Override
	public List<PedidoSolicitudDto> listarDto() {
		
		return null;
	}

}
