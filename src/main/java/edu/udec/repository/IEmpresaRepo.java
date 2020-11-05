package edu.udec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.udec.entity.Empresa;

public interface IEmpresaRepo extends JpaRepository<Empresa, Integer>{

}
