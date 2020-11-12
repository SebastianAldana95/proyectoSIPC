package edu.udec.service;

import java.util.List;

import edu.udec.dto.FincaDto;
import edu.udec.entity.Finca;

public interface IFincaService extends ServiceGneneric<Finca, FincaDto> {
	
	public Finca guardarDto(FincaDto fincaDto);
	public Finca editarDto(FincaDto fincaDto);
	public List<Finca> listaFincaPorIdUsuario(Integer idUsuario);

}
