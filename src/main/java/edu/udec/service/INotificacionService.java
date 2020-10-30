package edu.udec.service;

import edu.udec.dto.NotificacionDto;
import edu.udec.entity.Notificacion;

public interface INotificacionService extends ServiceGneneric<Notificacion, NotificacionDto>{

	public Notificacion guardarDto(NotificacionDto notificacionDto);
	public Notificacion editarDto(NotificacionDto notificacionDto);
}
