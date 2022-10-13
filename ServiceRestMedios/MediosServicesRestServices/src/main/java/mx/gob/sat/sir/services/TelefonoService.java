package mx.gob.sat.sir.services;

import mx.gob.sat.sir.utileria.dto.AcuseTelefonoDto;
import mx.gob.sat.sir.utileria.dto.TelefonoDto;
import mx.gob.sat.sir.utileria.dto.VerificacionTelefonoDto;

public interface TelefonoService {

	TelefonoDto getInformacionTelefono(String tipoBusqueda, String parametroBusqueda);
	
	VerificacionTelefonoDto getVerificacionTelefono(String tipoBusqueda, String parametroBusqueda);
	
	AcuseTelefonoDto getAcuseTelefono(String tipoBusqueda, String parametroBusqueda);
}
