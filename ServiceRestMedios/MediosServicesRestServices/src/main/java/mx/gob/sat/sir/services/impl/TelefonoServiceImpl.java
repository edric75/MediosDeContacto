package mx.gob.sat.sir.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sat.sir.persistencia.dao.TelefonoDao;
import mx.gob.sat.sir.services.TelefonoService;
import mx.gob.sat.sir.utileria.dto.AcuseTelefonoDto;
import mx.gob.sat.sir.utileria.dto.TelefonoDto;
import mx.gob.sat.sir.utileria.dto.VerificacionTelefonoDto;
import mx.gob.sat.sir.utileria.model.AcuseTelefonoModel;
import mx.gob.sat.sir.utileria.model.TelefonoModel;
import mx.gob.sat.sir.utileria.model.VerificacionTelefonoModel;

@Service
public class TelefonoServiceImpl implements TelefonoService {
	private final static Logger logger = Logger.getLogger(TelefonoService.class);

	@Autowired
	TelefonoDao telefonoDao;
	
	public TelefonoDto getInformacionTelefono(String tipoBusqueda, String parametroBusqueda) {
		TelefonoDto infoTelefonoDto = new TelefonoDto(); 
		List<TelefonoModel> infoTelefono = new ArrayList<TelefonoModel>();
		try {
			infoTelefono =telefonoDao.getInfoTelefono(tipoBusqueda,parametroBusqueda);
			infoTelefonoDto.setInformacionTelefono(infoTelefono);
		}catch (Exception e) {
			logger.info("::: Error ServiceImpl Informacion Telefono");
		}
		return infoTelefonoDto;
	}

	public VerificacionTelefonoDto getVerificacionTelefono(String tipoBusqueda, String parametroBusqueda) {
		VerificacionTelefonoDto infoTelefonoDto = new VerificacionTelefonoDto(); 
		List<VerificacionTelefonoModel> infoTelefono = new ArrayList<VerificacionTelefonoModel>();
		try {
			infoTelefono =telefonoDao.getVerificacionTelefono(tipoBusqueda,parametroBusqueda);
			infoTelefonoDto.setVerificacionTeleono(infoTelefono);
		}catch (Exception e) {
			logger.info("::: Error ServiceImpl Verificacion Telefono:");
		}
		return infoTelefonoDto;
	}

	public AcuseTelefonoDto getAcuseTelefono(String tipoBusqueda, String parametroBusqueda) {
		AcuseTelefonoDto infoTelefonoDto = new AcuseTelefonoDto(); 
		List<AcuseTelefonoModel> infoTelefono = new ArrayList<AcuseTelefonoModel>();
		try {
			infoTelefono =telefonoDao.getAcuseTelefono(tipoBusqueda,parametroBusqueda);
			infoTelefonoDto.setInformacionAcuseTelefono(infoTelefono);
		}catch (Exception e) {
			logger.info("::: Error ServiceImpl Acuse Telefono:");
		}
		return infoTelefonoDto;
	}

}
