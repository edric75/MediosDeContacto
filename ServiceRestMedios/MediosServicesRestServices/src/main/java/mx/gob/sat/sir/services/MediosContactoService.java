package mx.gob.sat.sir.services;

import mx.gob.sat.sir.utileria.dto.AutenticacionDto;
import mx.gob.sat.sir.utileria.dto.ContribuyenteDto;
import mx.gob.sat.sir.utileria.dto.RegimenDto;

public interface MediosContactoService {
	
	ContribuyenteDto getInfoContribuyente(String tipoBusqueda, String parametroBusqueda);
	
	RegimenDto getInfoRegimen(String tipoBusqueda, String parametroBusqueda);
	
	AutenticacionDto getInfoAutenticacion(String tipoBusqueda, String parametroBusqueda);

}
