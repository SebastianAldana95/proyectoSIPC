package edu.udec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.udec.entity.Finca;

public interface IFincaRepo extends JpaRepository<Finca, Integer>{

}
