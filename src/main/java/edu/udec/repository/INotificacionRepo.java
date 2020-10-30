package edu.udec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.udec.entity.Notificacion;

public interface INotificacionRepo extends JpaRepository<Notificacion, Integer> {

}
