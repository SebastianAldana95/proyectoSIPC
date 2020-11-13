package edu.udec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.udec.entity.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findOneByNick(String nick);
	boolean existsByNick(String nick);
	
	@Query(value = "SELECT u FROM Usuario u WHERE u.rol.idRol = :idRol ORDER BY u.idUsuario")
	List<Usuario> findByRolIdRol(Integer idRol);
}
