package edu.udec.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.dto.PqrDto;
import edu.udec.entity.Pqr;
import edu.udec.entity.Usuario;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.IPqrRepo;
import edu.udec.repository.IUsuarioRepo;
import edu.udec.service.IPqrService;

@Service
public class PqrServiceImp implements IPqrService{

	@Autowired
	private IPqrRepo repo;
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public List<Pqr> listar() {
		List<Pqr> listaPqr = repo.findAll();
		
		return listaPqr;
	}

	@Override
	public Pqr listarId(Integer id) {
		
		Pqr pqr = repo.findById(id).orElseThrow(
				() -> new NotFoundException("Pqr no encontrada"));
		return pqr;
	}

	@Override
	public Pqr guardar(Pqr t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		} else {
			throw new NotFoundException("Pqr no existe!");
		}
		
	}

	@Override
	public Pqr guardarDto(PqrDto pqrDto) {
		
		Usuario usuario = usuarioRepo.findById(pqrDto.getUsuario().getIdUsuario()).orElseThrow(
				() -> new NotFoundException("Usuario no existe"));
		usuario.setIdUsuario(pqrDto.getUsuario().getIdUsuario());
		
		Pqr pqr = new Pqr();
		pqr.setMotivo(pqrDto.getMotivo());
		pqr.setSolicitud(pqrDto.getSolicitud());
		pqr.setUsuario(usuario);
		
		return repo.save(pqr);
	}

	@Override
	public Pqr editarDto(PqrDto pqrDto) {
		
		if (pqrDto.getIdPqr() == null) {
			throw new ArgumentRequiredException("Campo id pqr requerido");
		}
		
		Pqr pqr = repo.findById(pqrDto.getIdPqr()).orElseThrow(
				() -> new NotFoundException("Pqr no encontrada"));
		
		if (pqrDto.getMotivo() != null) {
			pqr.setMotivo(pqrDto.getMotivo());
		}
		if (pqrDto.getSolicitud() != null) {
			pqr.setSolicitud(pqrDto.getSolicitud());
		}
		
		return repo.save(pqr);
	}

}
