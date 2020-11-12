package edu.udec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.udec.entity.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{
	
	@Query(value = "SELECT pd FROM Producto pd WHERE pd.categoria.nombre like %:nombre% ORDER BY pd.categoria.idCategoria")
	public List<Producto> findByCategoriaNombre(String nombre);
	
	@Query(value = "SELECT pd FROM Producto pd WHERE pd.empresa.idEmpresa = :idEmpresa ORDER BY pd.empresa.idEmpresa")
	public List<Producto> findByEmpresaIdEmpresa(Integer idEmpresa);
	
	@Query(value = "SELECT pd FROM Producto pd WHERE pd.finca.idFinca = :idFinca ORDER BY pd.finca.idFinca")
	public List<Producto> findByFincaIdFinca(Integer idFinca);

}
