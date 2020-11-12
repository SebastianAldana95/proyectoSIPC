package edu.udec.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.udec.entity.Categoria;
import edu.udec.entity.Empresa;
import edu.udec.entity.Finca;
import edu.udec.entity.Producto;
import edu.udec.exception.ArgumentRequiredException;
import edu.udec.exception.NotFoundException;
import edu.udec.repository.ICategoriaRepo;
import edu.udec.repository.IEmpresaRepo;
import edu.udec.repository.IFincaRepo;
import edu.udec.repository.IProductoRepo;
import edu.udec.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private IProductoRepo productoRepo;
	
	@Autowired
	private IEmpresaRepo empresaRepo;
	
	@Autowired
	private IFincaRepo fincaRepo;
	
	@Autowired
	private ICategoriaRepo categoriaRepo;

	@Override
	public List<Producto> listar() {
		return productoRepo.findAll();
	}

	@Override
	public Producto listarId(Integer id) {
		
		Producto producto = productoRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Producto no encontrado"));
		
		return producto;
	}

	@Transactional
	@Override
	public Producto guardar(Producto t) {
		
		if ((t.getEmpresa() == null) && (t.getFinca() == null)) {
			throw new ArgumentRequiredException("Se requiere una empresa o una finca para realizar esta accion!");
		}
		
		if (t.getCategoria() == null) {
			throw new ArgumentRequiredException("Se requiere una categoria para crear el producto!");
		}
	
		if(t.getFinca() == null) {
			
			Empresa empresa = empresaRepo.findById(t.getEmpresa().getIdEmpresa()).orElseThrow(
					() -> new NotFoundException("Empresa no existe"));
			
			Producto producto = new Producto();
			producto.setCodigo(t.getCodigo());
			producto.setDescripcion(t.getDescripcion());
			producto.setFoto(t.getFoto());
			producto.setNombre(t.getNombre());
			producto.setPrecioUnitario(t.getPrecioUnitario());
			producto.setPrecioMayorista(t.getPrecioMayorista());
			producto.setEmpresa(empresa);
			
			if (t.getCategoria().getIdCategoria() == null ) {
				Categoria categoria = new Categoria();
				categoria.setNombre(t.getCategoria().getNombre());
				
				categoriaRepo.save(categoria);
				producto.setCategoria(categoria);
			} else {
				Categoria categoria = categoriaRepo.findById(t.getCategoria().getIdCategoria()).orElseThrow(
						() -> new NotFoundException("Categoria no existe"));
				producto.setCategoria(categoria);
			}
			
			if (empresa.getUsuario().getRol().getIdRol() == 2 || empresa.getUsuario().getRol().getIdRol() == 3) {
				return productoRepo.save(producto);
			}

		}
		if (t.getEmpresa() == null) {
			
			Finca finca = fincaRepo.findById(t.getFinca().getIdFinca()).orElseThrow(
					() -> new NotFoundException("Finca no existe"));
			
			Producto producto = new Producto();
			producto.setCodigo(t.getCodigo());
			producto.setDescripcion(t.getDescripcion());
			producto.setFoto(t.getFoto());
			producto.setNombre(t.getNombre());
			producto.setPrecioUnitario(t.getPrecioUnitario());
			producto.setPrecioMayorista(t.getPrecioMayorista());
			producto.setFinca(finca);
			
			if (t.getCategoria().getIdCategoria() == null ) {
				Categoria categoria = new Categoria();
				categoria.setNombre(t.getCategoria().getNombre());
				
				categoriaRepo.save(categoria);
				producto.setCategoria(categoria);
			} else {
				Categoria categoria = categoriaRepo.findById(t.getCategoria().getIdCategoria()).orElseThrow(
						() -> new NotFoundException("Categoria no existe"));
				producto.setCategoria(categoria);
			}
			
			if (finca.getUsuario().getRol().getIdRol() == 5) {
				return productoRepo.save(producto);
			}
			
		}
		
		throw new ArgumentRequiredException("Se requiere una empresa o una finca para realizar esta accion!2");
	}

	@Override
	public void eliminar(Integer id) {
		
		if (productoRepo.existsById(id)) {
			productoRepo.deleteById(id);
		} else {
			throw new NotFoundException("Producto no existe!");
		}
		
	}

	@Override
	public Producto editarProducto(Producto t) {
		
		if (t.getIdProducto() == null) {
			throw new ArgumentRequiredException("Campo id producto requerido");
		}
		
		if ((t.getEmpresa() == null) && (t.getFinca() == null)) {
			throw new ArgumentRequiredException("Se requiere una empresa o una finca para realizar esta accion!");
		}
		
		if (t.getCategoria() == null) {
			throw new ArgumentRequiredException("Se requiere una categoria para editar el producto!");
		}
		
		Producto producto = productoRepo.findById(t.getIdProducto()).orElseThrow(
				() -> new NotFoundException("Producto no encontrado"));
		
		if (t.getFinca() == null ) {
			Empresa empresa = empresaRepo.findById(t.getEmpresa().getIdEmpresa()).orElseThrow(
					() -> new NotFoundException("Empresa no existe"));
			
			if (t.getCodigo() != null) {
				producto.setCodigo(t.getCodigo());
			}
			if (t.getDescripcion() != null) {
				producto.setDescripcion(t.getDescripcion());
			}
			if (t.getFoto() != null) {
				producto.setFoto(t.getFoto());
			}
			if (t.getNombre() != null) {
				producto.setNombre(t.getNombre());
			}
			if (t.getPrecioMayorista() != null) {
				producto.setPrecioMayorista(t.getPrecioMayorista());
			}
			if (t.getPrecioUnitario() != null) {
				producto.setPrecioUnitario(t.getPrecioUnitario());
			}
			
			if (t.getCategoria() != null) {
				if (t.getCategoria().getIdCategoria() == null ) {
					Categoria categoria = new Categoria();
					categoria.setNombre(t.getCategoria().getNombre());	
					categoriaRepo.save(categoria);
					producto.setCategoria(categoria);
				} else {
					Categoria categoria = categoriaRepo.findById(t.getCategoria().getIdCategoria()).orElseThrow(
							() -> new NotFoundException("Categoria no existe"));
					producto.setCategoria(categoria);
				}
			}
			
			if (empresa.getUsuario().getRol().getIdRol() == 2 || empresa.getUsuario().getRol().getIdRol() == 3) {
				return productoRepo.save(producto);
			}			
		}
		
		if (t.getEmpresa() == null) {
			
			Finca finca = fincaRepo.findById(t.getFinca().getIdFinca()).orElseThrow(
					() -> new NotFoundException("Finca no existe"));
			
			if (t.getCodigo() != null) {
				producto.setCodigo(t.getCodigo());
			}
			if (t.getDescripcion() != null) {
				producto.setDescripcion(t.getDescripcion());
			}
			if (t.getFoto() != null) {
				producto.setFoto(t.getFoto());
			}
			if (t.getNombre() != null) {
				producto.setNombre(t.getNombre());
			}
			if (t.getPrecioMayorista() != null) {
				producto.setPrecioMayorista(t.getPrecioMayorista());
			}
			if (t.getPrecioUnitario() != null) {
				producto.setPrecioUnitario(t.getPrecioUnitario());
			}
			
			if (t.getCategoria() != null) {
				if (t.getCategoria().getIdCategoria() == null ) {
					Categoria categoria = new Categoria();
					categoria.setNombre(t.getCategoria().getNombre());	
					categoriaRepo.save(categoria);
					producto.setCategoria(categoria);
				} else {
					Categoria categoria = categoriaRepo.findById(t.getCategoria().getIdCategoria()).orElseThrow(
							() -> new NotFoundException("Categoria no existe"));
					producto.setCategoria(categoria);
				}
			}
			
			if (finca.getUsuario().getRol().getIdRol() == 5) {
				return productoRepo.save(producto);
			}
			
		}
		
		throw new ArgumentRequiredException("Se requiere una empresa o una finca para realizar esta accion!");
		
	}

	@Override
	public List<Producto> listarProductoPorNombreCategoria(String nombre) {
		List<Producto> productos = productoRepo.findByCategoriaNombre(nombre);
		return productos;
	}

	@Override
	public List<Producto> listaProductoPorIdEmpresa(Integer idEmpresa) {
		if (empresaRepo.existsById(idEmpresa)) {
			List<Producto> productos = productoRepo.findByEmpresaIdEmpresa(idEmpresa);
			return productos;
		} else {
			throw new NotFoundException("Empresa no existe!");
		}
	}

	@Override
	public List<Producto> listaProductoPorIdFinca(Integer idFinca) {
		if (fincaRepo.existsById(idFinca)) {
			List<Producto> productos = productoRepo.findByFincaIdFinca(idFinca);
			return productos;
		} else {
			throw new NotFoundException("Finca no existe!");
		}
	}
	

}
