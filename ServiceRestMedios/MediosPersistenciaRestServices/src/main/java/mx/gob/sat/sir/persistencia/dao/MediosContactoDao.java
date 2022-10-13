package mx.gob.sat.sir.persistencia.dao;

import java.util.List;

import mx.gob.sat.sir.utileria.model.AutenticacionModel;
import mx.gob.sat.sir.utileria.model.ContribuyenteModel;
import mx.gob.sat.sir.utileria.model.RegimenModel;

public interface MediosContactoDao {
	
	List<ContribuyenteModel> getinfoContribuyenteDAO(String tipoBusqueda, String parametroBusqueda);	
	
	List<RegimenModel> getInfoRegimen(String tipoBusqueda, String parametroBusqueda);
	
	List<AutenticacionModel> getInfoAutenticacion(String tipoBusqueda, String parametroBusqueda);
}
