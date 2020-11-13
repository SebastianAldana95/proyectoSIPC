package edu.udec.service;

import java.util.List;

import edu.udec.dto.PedidoSolicitudDto;
import edu.udec.entity.PedidoSolicitud;

public interface IPedidoSolicitudService extends ServiceGneneric<PedidoSolicitud, PedidoSolicitudDto>{

	public PedidoSolicitudDto guardarDto(PedidoSolicitud t);
	public void eliminarPedidoSolicitud(Integer idProducto, Integer idUsuario);
	public List<PedidoSolicitudDto> listarDto();
}
