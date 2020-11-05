package edu.udec.service;

import edu.udec.dto.EmpresaDto;
import edu.udec.entity.Empresa;

public interface IEmpresaService extends ServiceGneneric<Empresa, EmpresaDto>{
	
	public Empresa guardarDto(EmpresaDto empresaDto);
	public Empresa editarDto(EmpresaDto empresaDto);

}
