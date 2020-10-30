package edu.udec.service;

import edu.udec.dto.PqrDto;
import edu.udec.entity.Pqr;

public interface IPqrService extends ServiceGneneric<Pqr, PqrDto>{
	
	public Pqr guardarDto(PqrDto pqrDto);
	public Pqr editarDto(PqrDto pqrDto);

}
