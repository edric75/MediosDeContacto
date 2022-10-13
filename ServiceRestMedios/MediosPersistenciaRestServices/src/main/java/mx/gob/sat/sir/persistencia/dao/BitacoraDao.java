package mx.gob.sat.sir.persistencia.dao;

import mx.gob.sat.sir.utileria.model.AplicativosModel;
import mx.gob.sat.sir.utileria.model.BitacoraModel;

public interface BitacoraDao {
	
	public int addBitacora(BitacoraModel bitacora);
	
	public AplicativosModel getAplicativos(String idAplicativo);
}
