package mx.gob.sat.sir.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sat.sir.persistencia.dao.MediosContactoDao;
import mx.gob.sat.sir.services.MediosContactoService;
import mx.gob.sat.sir.utileria.dto.AutenticacionDto;
import mx.gob.sat.sir.utileria.dto.ContribuyenteDto;
import mx.gob.sat.sir.utileria.dto.RegimenDto;
import mx.gob.sat.sir.utileria.model.AutenticacionModel;
import mx.gob.sat.sir.utileria.model.ContribuyenteModel;
import mx.gob.sat.sir.utileria.model.RegimenModel;

@Service
public class MediosContactoServiceImpl implements MediosContactoService {
	private final static Logger logger = Logger.getLogger(MediosContactoServiceImpl.class);

	@Autowired
	MediosContactoDao mediosContactoDao;

	public ContribuyenteDto getInfoContribuyente(String tipoBusqueda, String parametroBusqueda) {
		ContribuyenteDto infoContribuyenteDto = new ContribuyenteDto();
		List<ContribuyenteModel> infoContribuyente = new ArrayList<ContribuyenteModel>();
		try {
			infoContribuyente = mediosContactoDao.getinfoContribuyenteDAO(tipoBusqueda, parametroBusqueda);
			infoContribuyenteDto.setInformacionContribuyente(infoContribuyente);
		} catch (Exception e) {
			logger.info("::: Error ServiceImpl medios de contacto:");
		}
		return infoContribuyenteDto;
	}

	public RegimenDto getInfoRegimen(String tipoBusqueda, String parametroBusqueda) {
		RegimenDto infoRegimenDto = new RegimenDto();
		List<RegimenModel> infoRegimen = new ArrayList<RegimenModel>();
		try {
			infoRegimen = mediosContactoDao.getInfoRegimen(tipoBusqueda,parametroBusqueda);
			infoRegimenDto.setInformacionRegimen(infoRegimen);
		} catch (Exception e) {
			logger.info("::: Error ServiceImpl medios de contacto Regimen:");
		}
		return infoRegimenDto;
	}

	public AutenticacionDto getInfoAutenticacion(String tipoBusqueda, String parametroBusqueda) {
		AutenticacionDto infoAutenticacionnDto = new AutenticacionDto();
		List<AutenticacionModel> infoAutenticacion = new ArrayList<AutenticacionModel>();
		try {
			infoAutenticacion = mediosContactoDao.getInfoAutenticacion(tipoBusqueda,parametroBusqueda);
			infoAutenticacionnDto.setInformacionAutenticacion(infoAutenticacion);
		} catch (Exception e) {
			logger.info("::: Error ServiceImpl medios de contacto Autenticacion:");
		}
		return infoAutenticacionnDto;
	}


}
