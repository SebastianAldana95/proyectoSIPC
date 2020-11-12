package edu.udec.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.dto.FincaDto;
import edu.udec.entity.Finca;
import edu.udec.entity.Usuario;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.IFincaRepo;
import edu.udec.repository.IUsuarioRepo;
import edu.udec.service.IFincaService;

@Service
public class FincaServiceImp implements IFincaService {

	@Autowired
	private IFincaRepo fincaRepo;

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public List<Finca> listar() {
		return fincaRepo.findAll();
	}

	@Override
	public Finca listarId(Integer id) {
		Finca finca = fincaRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Finca no encontrada"));
		
		return finca;
	}

	@Override
	public Finca guardar(Finca t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		
		if (fincaRepo.existsById(id)) {
			fincaRepo.deleteById(id);
		} else {
			throw new NotFoundException("Finca no existe!");
		}
		
	}

	@Override
	public Finca guardarDto(FincaDto fincaDto) {
		
		Usuario usuario = usuarioRepo.findById(fincaDto.getUsuario().getIdUsuario()).orElseThrow(
				() -> new NotFoundException("Usuario no existe"));
		
		fincaDto.setEstado(1);
		fincaDto.setUsuario(usuario);
		
		Finca finca = new Finca();
		finca.setCelular(fincaDto.getCelular());
		finca.setCorreo(fincaDto.getCorreo());
		finca.setDireccion(fincaDto.getDireccion());
		finca.setEstado(1);
		finca.setFoto(fincaDto.getFoto());
		finca.setNombre(fincaDto.getNombre());
		finca.setTelefono(fincaDto.getTelefono());
		finca.setUsuario(usuario);
		
		if (finca.getUsuario().getRol().getIdRol() == 5) {
			return fincaRepo.save(finca);
		}
		throw new ArgumentRequiredException("No tiene permisos para realizar esta accion!");
		
	}

	@Override
	public Finca editarDto(FincaDto fincaDto) {
		
		if (fincaDto.getIdFinca() == null) {
			throw new ArgumentRequiredException("Campo id finca es requerido");
		}
		
		Finca finca = fincaRepo.findById(fincaDto.getIdFinca()).orElseThrow(
				() -> new NotFoundException("Finca no encontrada"));
		
		if (fincaDto.getCelular() != null) {
			finca.setCelular(fincaDto.getCelular());
		}
		if (fincaDto.getCorreo() != null) {
			finca.setCorreo(fincaDto.getCorreo());
		}
		if (fincaDto.getDireccion() != null) {
			finca.setDireccion(fincaDto.getDireccion());
		}
		if (fincaDto.getFoto() != null) {
			finca.setFoto(fincaDto.getFoto());
		}
		if (fincaDto.getTelefono() != null) {
			finca.setTelefono(fincaDto.getTelefono());
		}
		
		return fincaRepo.save(finca);
	}

	@Override
	public List<Finca> listaFincaPorIdUsuario(Integer idUsuario) {
		if (usuarioRepo.existsById(idUsuario)) {
			List<Finca> listaFincas = fincaRepo.findByUsuarioIdUsuario(idUsuario);
			return listaFincas;
		} else {
			throw new NotFoundException("Finca no existe!");
		}
	}

}
