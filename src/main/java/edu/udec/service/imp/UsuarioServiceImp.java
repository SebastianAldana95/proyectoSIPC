package edu.udec.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.entity.Rol;
import edu.udec.entity.Usuario;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.IUsuarioRepo;
import edu.udec.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepo repo;

	@Override
	public List<Usuario> listar() {
		
		return repo.findAll();
	}

	@Override
	public Usuario listarId(Integer id) {
		
		Usuario usuario = repo.findById(id).orElseThrow(
				() -> new NotFoundException("Usuario no encontrado"));
		
		return usuario;
	}

	@Override
	public Usuario guardar(Usuario t) {
		
		if(repo.existsByNick(t.getNick())) {
			throw new ArgumentRequiredException("nickname ya existe en el sistema");
		}
		//FALTA METER LA ENCRIPTACION DE LA CONTRASEÑA
		t.setEstado(1);
		t.getRol().setIdRol(4);
		t.getRol().getNombreRol();
		return repo.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		} else {
			throw new NotFoundException("Usuario no encontrado");
		}
		
	}

	@Transactional
	@Override
	public Usuario editar(Usuario usuario) {
		
		if (usuario.getIdUsuario() == null) {
			throw new ArgumentRequiredException("Campo id usuario requerido");
		}
		
		Usuario user = repo.findById(usuario.getIdUsuario()).orElseThrow(
				() -> new NotFoundException("Usuario no encontrado"));
		
		if (usuario.getCorreo() != null) {
			user.setCorreo(usuario.getCorreo());
		}
		if (usuario.getCelular() != null) {
			user.setCelular(usuario.getCelular());
		}
		if (usuario.getDireccion() != null) {
			user.setDireccion(usuario.getDireccion());
		}
		if (usuario.getFoto() != null) {
			user.setFoto(usuario.getFoto());
		}
		if (usuario.getEstado() != null) {
			user.setEstado(usuario.getEstado());
		}
		if (usuario.getRol().getIdRol() != null) {
			if (usuario.getRol().getIdRol() == 2 || usuario.getRol().getIdRol() == 3 || usuario.getRol().getIdRol() == 4 || usuario.getRol().getIdRol() == 5) {
				Rol rol = new Rol();
				rol.setIdRol(usuario.getRol().getIdRol());
				user.setRol(rol);			
			} else {
				throw new NotFoundException("Rol no existe!");
			}		
		}
		
		return repo.save(user);
	}

	@Override
	public List<Usuario> listarPorRol(Integer idRol) {
		
		if (idRol == 2 || idRol == 3 || idRol == 4 || idRol == 5) {
			
			switch (idRol) {
			case 2:
				List<Usuario> listaComerciantes = repo.findByRolIdRol(idRol);
				return listaComerciantes;
			case 3:
				List<Usuario> listaMayorista = repo.findByRolIdRol(idRol);
				return listaMayorista;
			case 4:
				List<Usuario> listaPersonaNatural = repo.findByRolIdRol(idRol);
				return listaPersonaNatural;
			case 5:
				List<Usuario> listaAgricultor = repo.findByRolIdRol(idRol);
				return listaAgricultor;
			default:
				break; 
			}	
		}
		throw new NotFoundException("Rol no existe!");
	}

}
