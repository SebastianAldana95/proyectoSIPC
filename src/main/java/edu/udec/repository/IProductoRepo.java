package edu.udec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.udec.entity.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
