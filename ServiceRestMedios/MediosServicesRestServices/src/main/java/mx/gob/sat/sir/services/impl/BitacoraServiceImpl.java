package mx.gob.sat.sir.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sat.sir.persistencia.dao.BitacoraDao;
import mx.gob.sat.sir.services.BitacoraService;
import mx.gob.sat.sir.utileria.dto.EmailDto;
import mx.gob.sat.sir.utileria.model.AplicativosModel;
import mx.gob.sat.sir.utileria.model.BitacoraModel;
import mx.gob.sat.sir.utileria.model.EmailModel;


@Service
public class BitacoraServiceImpl implements BitacoraService{
	private final static Logger logger = Logger.getLogger(BitacoraServiceImpl.class);
	
	@Autowired
	BitacoraDao bitacoraDAO;
	
	public int addBitacora(String rfc,String infConsultada,String ip, String aplicativo){
		int statusBitacora = 0;
		BitacoraModel bitacora = new BitacoraModel();
		Timestamp fechaConsulta = new Timestamp(System.currentTimeMillis());
		bitacora.setRfc(rfc);
		bitacora.setInfConsultada(infConsultada);
		bitacora.setIp(ip);
		bitacora.setFechaConsulta(fechaConsulta);
		bitacora.setAplicativoConsultante(aplicativo);
		try {
			statusBitacora = bitacoraDAO.addBitacora(bitacora);
		}catch (Exception e) {
			logger.info("::: Error ServiceImpl Bitacora:");
		}
		return statusBitacora;
	}

	public AplicativosModel getAplicativos(String idAplicativo) {
		AplicativosModel aplicativos = new AplicativosModel(); 
		try {
			aplicativos = bitacoraDAO.getAplicativos(idAplicativo);
		}catch (Exception e) {
			logger.info("::: Error ServiceImpl Aplicativos:",e);
		}
		return aplicativos;
	}

}
