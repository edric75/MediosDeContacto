package mx.gob.sat.sir.persistencia.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mx.gob.sat.sir.persistencia.dao.MediosContactoDao;
import mx.gob.sat.sir.persistencia.mapper.AutenticacionRowMapper;
import mx.gob.sat.sir.persistencia.mapper.InfoContribuyenteRowMapper;
import mx.gob.sat.sir.persistencia.mapper.RegimenRowMapper;
import mx.gob.sat.sir.utileria.model.AutenticacionModel;
import mx.gob.sat.sir.utileria.model.ContribuyenteModel;
import mx.gob.sat.sir.utileria.model.RegimenModel;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlConstante;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlContribuyente;

@Service
public class MediosContacoDaoImpl implements MediosContactoDao {
	private final static Logger logger = Logger.getLogger(MediosContacoDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	public List<ContribuyenteModel> getinfoContribuyenteDAO(String tipoBusqueda, String parametroBusqueda) {
		List<ContribuyenteModel> infoContribuyente = new ArrayList<ContribuyenteModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Info Contribytente");									
				infoContribuyente = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaContribuyenteRfc(),
					new Object[] { parametroBusqueda}, new InfoContribuyenteRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query CURP Info Contribytente");									
				infoContribuyente = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaContribuyenteCurp(),
					new Object[] { parametroBusqueda }, new InfoContribuyenteRowMapper());				
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query Email Contribuyente");														
				infoContribuyente = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaContribuyenteEmail(),
					new Object[] { parametroBusqueda}, new InfoContribuyenteRowMapper());
			}
			logger.info("Informacion de base de datos Contribueynete ::: " + infoContribuyente.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros para el RFC(cONTRIBUYENTE) " + parametroBusqueda + " :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta ::: " + e);
		}

		return infoContribuyente;
	}

	public List<RegimenModel> getInfoRegimen(String tipoBusqueda, String parametroBusqueda) {
		List<RegimenModel> infoRegimen = new ArrayList<RegimenModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Regimen");																			
				infoRegimen = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaRegimenRfc(),
						new Object[] { parametroBusqueda}, new RegimenRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query CURP Regimen ");																				
				infoRegimen = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaRegimenCurp(),
						new Object[] { parametroBusqueda}, new RegimenRowMapper());				
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query Correo Regimen");					
				infoRegimen = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaRegimenEmail(),
						new Object[] { parametroBusqueda}, new RegimenRowMapper());
			}
			logger.info("Informacion de base de datos Regimen ::: " + infoRegimen.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros para el RFC Regimen " + parametroBusqueda + " infoRegimen :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta infoRegimen ::: " + e);
		}
		
		return infoRegimen;
	}

	public List<AutenticacionModel> getInfoAutenticacion(String tipoBusqueda, String parametroBusqueda) {
		List<AutenticacionModel> infoRegimen = new ArrayList<AutenticacionModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Autenticacion");			
				logger.info(ConsultasSqlContribuyente.getConsultaAutenticacionRfc());					
				infoRegimen = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaAutenticacionRfc(),
						new Object[] { parametroBusqueda }, new AutenticacionRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query Curp Autenticacion");				
				logger.info(ConsultasSqlContribuyente.getConsultaAutenticacionCurp());				
				infoRegimen = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaAutenticacionCurp(),
						new Object[] { parametroBusqueda }, new AutenticacionRowMapper());				
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query Correo Autenticacion");			
				logger.info(ConsultasSqlContribuyente.getConsultaAutenticacionEmail());					
				infoRegimen = jdbcTemplate.query(ConsultasSqlContribuyente.getConsultaAutenticacionEmail(),
						new Object[] { parametroBusqueda }, new AutenticacionRowMapper());
			}
			logger.info("Informacion de base de datos Autenticacion ::: " + infoRegimen.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros para el RFC Aut" + parametroBusqueda + " Autenticacion :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta Autenticacion ::: " + e.getMessage());
		}
		
		return infoRegimen;
	}

}
