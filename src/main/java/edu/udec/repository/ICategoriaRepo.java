package edu.udec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.udec.entity.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {

	@Query(value = "SELECT ca FROM Categoria ca WHERE ca.nombre like %:nombre% ORDER BY ca.idCategoria")
	public List<Categoria> findByNombre(String nombre);
	
}
