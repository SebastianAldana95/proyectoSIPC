package edu.udec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.udec.entity.Pqr;

public interface IPqrRepo extends JpaRepository<Pqr, Integer>{
	
	Pqr findBySolicitud(String solicitud);

}
