package edu.udec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.udec.entity.Empresa;

public interface IEmpresaRepo extends JpaRepository<Empresa, Integer>{

	@Query(value = "SELECT e FROM Empresa e WHERE e.usuario.idUsuario = :idUsuario ORDER BY e.idEmpresa")
	List<Empresa> findByUsuarioIdUsuario(Integer idUsuario); 
}
