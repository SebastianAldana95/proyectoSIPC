package edu.udec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.udec.entity.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {

}
