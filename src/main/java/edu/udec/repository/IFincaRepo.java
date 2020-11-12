package edu.udec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.udec.entity.Finca;

public interface IFincaRepo extends JpaRepository<Finca, Integer>{
	
	@Query(value = "SELECT f FROM Finca f WHERE f.usuario.idUsuario = :idUsuario ORDER BY f.idFinca")
	List<Finca> findByUsuarioIdUsuario(Integer idUsuario);

}
