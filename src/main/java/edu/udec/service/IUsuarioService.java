package edu.udec.service;

import java.util.List;

import edu.udec.entity.Usuario;

public interface IUsuarioService extends ServiceGneneric<Usuario, Integer> {

	public Usuario editar(Usuario usuario);
	public List<Usuario> listarPorRol(Integer idRol);
}
