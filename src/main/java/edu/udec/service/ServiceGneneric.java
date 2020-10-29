package edu.udec.service;

import java.util.List;

public interface ServiceGneneric<T, TDto> {
	
	public List<T> listar();
	public T listarId(Integer id);
	public T guardar(T t);
	public void eliminar(Integer id);

}
