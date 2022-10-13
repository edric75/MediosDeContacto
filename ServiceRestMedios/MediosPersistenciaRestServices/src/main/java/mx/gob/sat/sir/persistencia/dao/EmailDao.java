package mx.gob.sat.sir.persistencia.dao;

import java.util.List;

import mx.gob.sat.sir.utileria.model.AcuseMailModel;
import mx.gob.sat.sir.utileria.model.EmailModel;
import mx.gob.sat.sir.utileria.model.VerificacionMailModel;

public interface EmailDao {
	List<EmailModel> getinfoEmail(String tipoBusqueda, String parametroBusqueda);
	
	List<VerificacionMailModel> getInfoVerificacionMail(String tipoBusqueda, String parametroBusqueda);
	
	List<AcuseMailModel> getInfoAcuseMail(String tipoBusqueda, String parametroBusqueda);
}
