package mx.gob.sat.sir.services;

import mx.gob.sat.sir.utileria.dto.AcuseMailDto;
import mx.gob.sat.sir.utileria.dto.EmailDto;
import mx.gob.sat.sir.utileria.dto.VerificacionMailDto;

public interface EmailService {
	
	EmailDto getInfoEmail(String tipoBusqueda, String parametroBusqueda);
	
	VerificacionMailDto getVerificacionMail(String tipoBusqueda, String parametroBusqueda);
	
	AcuseMailDto getAcuseMail(String tipoBusqueda, String parametroBusqueda);
}
