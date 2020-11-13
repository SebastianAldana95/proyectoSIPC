package edu.udec.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.udec.entity.PedidoSolicitud;

public interface IPedidoSolicitudRepo extends JpaRepository<PedidoSolicitud, Integer>{

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO pedido_solicitud(id_producto, id_usuario, cantidad, valor_total, calificacion, confirmacion, fecha)"
			+ "VALUES(:idProducto, :idUsuario, :cantidad, :valorTotal, :calificacion, :confirmacion, current_timestamp)", nativeQuery = true)
	public void guardar(@Param("idProducto") Integer idProducto, @Param("idUsuario") Integer idUsuario, @Param("cantidad") Integer cantidad, @Param("valorTotal") Integer valorTotal, @Param("calificacion") Integer calificacion, @Param("confirmacion") String confirmacion);
	
	@Query(value = "SELECT * FROM pedido_solicitud ps WHERE ps.id_producto = :idProducto", nativeQuery = true)
	public PedidoSolicitud findByIdProducto(@Param("idProducto") Integer idProducto);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM pedido_solicitud WHERE id_usuario = :idUsuario AND id_producto = :idProducto" ,nativeQuery = true)
	public void eliminarPedidoSolicitud(@Param("idProducto") Integer idProducto, @Param("idUsuario") Integer idUsuario);
	
	@Query(value = "SELECT * FROM pedido_solicitud", nativeQuery = true)
	public List<PedidoSolicitud> listarTodoDto();
}
