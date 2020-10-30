package edu.udec.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.dto.NotificacionDto;
import edu.udec.entity.Notificacion;
import edu.udec.entity.Usuario;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.INotificacionRepo;
import edu.udec.repository.IUsuarioRepo;
import edu.udec.service.INotificacionService;

@Service
public class NotificacionServiceImp implements INotificacionService {

	@Autowired
	private INotificacionRepo notificacionRepo;
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public List<Notificacion> listar() {
		List<Notificacion> listaNotificaciones = notificacionRepo.findAll();
		return listaNotificaciones;
	}

	@Override
	public Notificacion listarId(Integer id) {
		
		Notificacion notificacion = notificacionRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Notificacion no encontrada"));
		
		return notificacion;
	}

	@Override
	public void eliminar(Integer id) {
		if (notificacionRepo.existsById(id)) {
			notificacionRepo.deleteById(id);
		} else {
			throw new NotFoundException("Notificacion no existe!");
		}
		
	}

	@Override
	public Notificacion guardar(Notificacion t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion guardarDto(NotificacionDto notificacionDto) {
		
		Usuario usuario = usuarioRepo.findById(notificacionDto.getUsuario().getIdUsuario()).orElseThrow(
				() -> new NotFoundException("Usuario no existe"));
		
		usuario.setIdUsuario(notificacionDto.getUsuario().getIdUsuario());
		
		Notificacion notificacion = new Notificacion();
		notificacion.setTitulo(notificacionDto.getTitulo());
		notificacion.setDescripcion(notificacionDto.getDescripcion());
		notificacion.setUsuario(usuario);
		
		return notificacionRepo.save(notificacion);
	}

	@Override
	public Notificacion editarDto(NotificacionDto notificacionDto) {
		
		if (notificacionDto.getIdNotificacion() == null) {
			throw new ArgumentRequiredException("Campo id pqr requerido");
		}
		
		Notificacion notificacion = notificacionRepo.findById(notificacionDto.getIdNotificacion()).orElseThrow(
				() -> new NotFoundException("Notificacion no encontrada"));
		
		if (notificacionDto.getTitulo() != null) {
			notificacion.setTitulo(notificacionDto.getTitulo());
		}
		if (notificacionDto.getDescripcion() != null) {
			notificacion.setDescripcion(notificacionDto.getDescripcion());
		}
		
		return notificacionRepo.save(notificacion);
	}

}
