package edu.udec.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.dto.EmpresaDto;
import edu.udec.entity.Empresa;
import edu.udec.entity.Usuario;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.IEmpresaRepo;
import edu.udec.repository.IUsuarioRepo;
import edu.udec.service.IEmpresaService;

@Service
public class EmpresaServiceImp implements IEmpresaService{

	@Autowired
	private IEmpresaRepo empresaRepo;
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public List<Empresa> listar() {
		return empresaRepo.findAll();
	}

	@Override
	public Empresa listarId(Integer id) {
		
		Empresa empresa = empresaRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Empresa no encontrada"));
		
		return empresa;
	}

	@Override
	public Empresa guardar(Empresa t) {
		
		/*Usuario usuario = usuarioRepo.findById(t.getUsuario().getIdUsuario()).orElseThrow(
				() -> new NotFoundException("Usuario no existe"));
		
		t.setEstado(1);
		t.setUsuario(usuario);
		
		if (t.getUsuario().getRol().getIdRol() == 2 || t.getUsuario().getRol().getIdRol() == 3) {
			return empresaRepo.save(t);
		}
		throw new ArgumentRequiredException("No tiene permisos para realizar esta accion!");
		*/
		
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		if (empresaRepo.existsById(id)) {
			empresaRepo.deleteById(id);
		} else {
			throw new NotFoundException("Empresa no existe!");
		}
		
	}

	@Override
	public Empresa guardarDto(EmpresaDto empresaDto) {
		Usuario usuario = usuarioRepo.findById(empresaDto.getUsuario().getIdUsuario()).orElseThrow(
				() -> new NotFoundException("Usuario no existe"));
		
		empresaDto.setEstado(1);
		empresaDto.setUsuario(usuario);
		
		Empresa empresa = new Empresa();
		empresa.setCelular(empresaDto.getCelular());
		empresa.setCorreo(empresaDto.getCorreo());
		empresa.setDireccion(empresaDto.getDireccion());
		empresa.setEstado(1);
		empresa.setFoto(empresaDto.getFoto());
		empresa.setNombre(empresaDto.getNombre());
		empresa.setRut(empresaDto.getRut());
		empresa.setTelefono(empresaDto.getTelefono());
		empresa.setTipo(empresaDto.getTipo());
		empresa.setUsuario(usuario);
		
		if (empresa.getUsuario().getRol().getIdRol() == 2 || empresa.getUsuario().getRol().getIdRol() == 3) {
			return empresaRepo.save(empresa);
		}
		throw new ArgumentRequiredException("No tiene permisos para realizar esta accion!");
	}

	@Override
	public Empresa editarDto(EmpresaDto empresaDto) {
		
		if (empresaDto.getIdEmpresa() == null) {
			throw new ArgumentRequiredException("Campo id empresa requerido");
		}
		
		Empresa empresa = empresaRepo.findById(empresaDto.getIdEmpresa()).orElseThrow(
				() -> new NotFoundException("Empresa no encontrada"));
		
		if (empresaDto.getCelular() != null) {
			empresa.setCelular(empresaDto.getCelular());
		}
		if (empresaDto.getCorreo() != null) {
			empresa.setCorreo(empresaDto.getCorreo());
		}
		if (empresaDto.getDireccion() != null) {
			empresa.setDireccion(empresaDto.getDireccion());
		}
		if (empresaDto.getFoto() != null) {
			empresa.setFoto(empresaDto.getFoto());
		}
		if (empresaDto.getTelefono() != null) {
			empresa.setTelefono(empresaDto.getTelefono());
		}
		
		return empresaRepo.save(empresa);
	}

}
