package edu.udec.service;

import edu.udec.dto.FincaDto;
import edu.udec.entity.Finca;

public interface IFincaService extends ServiceGneneric<Finca, FincaDto> {
	
	public Finca guardarDto(FincaDto fincaDto);
	public Finca editarDto(FincaDto fincaDto);

}
