package mx.gob.sat.sir.services;

import mx.gob.sat.sir.utileria.model.AplicativosModel;

public interface BitacoraService {

	public int addBitacora(String rfc,String infConsultada,String ip, String aplicativo);
	public AplicativosModel getAplicativos(String idAplicativo);
}
