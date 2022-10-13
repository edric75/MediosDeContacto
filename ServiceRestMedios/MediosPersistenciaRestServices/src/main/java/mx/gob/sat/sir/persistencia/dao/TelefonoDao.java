package mx.gob.sat.sir.persistencia.dao;
import java.util.List;

import mx.gob.sat.sir.utileria.model.AcuseTelefonoModel;
import mx.gob.sat.sir.utileria.model.TelefonoModel;
import mx.gob.sat.sir.utileria.model.VerificacionTelefonoModel;

public interface TelefonoDao {
	
	List<TelefonoModel> getInfoTelefono(String tipoBusqueda, String parametroBusqueda);
	
	List<VerificacionTelefonoModel> getVerificacionTelefono(String tipoBusqueda, String parametroBusqueda);
	
	List<AcuseTelefonoModel> getAcuseTelefono(String tipoBusqueda, String parametroBusqueda);
}
