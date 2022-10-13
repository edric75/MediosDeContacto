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

import mx.gob.sat.sir.persistencia.dao.TelefonoDao;
import mx.gob.sat.sir.persistencia.mapper.AcuseTelefonoRowMapper;
import mx.gob.sat.sir.persistencia.mapper.TelefonoRowMapper;
import mx.gob.sat.sir.persistencia.mapper.VerificacionTelefonoRowMapper;
import mx.gob.sat.sir.utileria.model.AcuseTelefonoModel;
import mx.gob.sat.sir.utileria.model.TelefonoModel;
import mx.gob.sat.sir.utileria.model.VerificacionTelefonoModel;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlConstante;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlTelefono;;

@Service
public class TelefonoDaoImpl implements TelefonoDao{
	private final static Logger logger = Logger.getLogger(TelefonoDaoImpl.class);

	@Autowired
	private DataSource dataSource;


	public List<TelefonoModel> getInfoTelefono(String tipoBusqueda, String parametroBusqueda) {
		logger.info("::: Realizando consultas para Info Telefono :::");
		List<TelefonoModel> infoTelefono = new ArrayList<TelefonoModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Telefono");
				logger.info(ConsultasSqlTelefono.getConsultaTelefonoRfc());				
				infoTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaTelefonoRfc(),
					new Object[] { parametroBusqueda }, new TelefonoRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query CURP Telefono");
				logger.info(ConsultasSqlTelefono.getConsultaTelefonoCurp());								
				infoTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaTelefonoCurp(),
					new Object[] { parametroBusqueda }, new TelefonoRowMapper());
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query EMAIL");
				logger.info(ConsultasSqlTelefono.getConsultaTelefonoEmail());												
				infoTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaTelefonoEmail(),
					new Object[] { parametroBusqueda }, new TelefonoRowMapper());
			}
			logger.info("Informacion de base de datos Telefono::: " + infoTelefono.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros infoTelefono para el RFC " + parametroBusqueda + " :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta infoTelefono ::: " + e.getMessage());

		}

		return infoTelefono;
	}


	public List<VerificacionTelefonoModel> getVerificacionTelefono(String tipoBusqueda, String parametroBusqueda) {
		logger.info("::: Realizando consultas para Info Verificacion Telefono :::");
		List<VerificacionTelefonoModel> infoVerificacionTelefono = new ArrayList<VerificacionTelefonoModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Verificacion Telefono ");
				logger.info(ConsultasSqlTelefono.getConsultaVerificacionTelefonoRfc());					
				infoVerificacionTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaVerificacionTelefonoRfc(),
					new Object[] { parametroBusqueda }, new VerificacionTelefonoRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query CURP Verificacion Telefono ");
				logger.info(ConsultasSqlTelefono.getConsultaVerificacionTelefonoCurp());					
				infoVerificacionTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaVerificacionTelefonoCurp(),
						new Object[] { parametroBusqueda }, new VerificacionTelefonoRowMapper());				
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query Verificacion Telefono EMAIL ");
				logger.info(ConsultasSqlTelefono.getConsultaVerificacionTelefonoEmail());				
				infoVerificacionTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaVerificacionTelefonoEmail(),
					new Object[] { parametroBusqueda }, new VerificacionTelefonoRowMapper());
			}

			logger.info("Informacion de base de datos verificacion Telefono ::: " + infoVerificacionTelefono.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros infoVerificacionTelefono para el RFC " + parametroBusqueda + " :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta infoVerificacionTelefono ::: " + e.getMessage());
		}

		return infoVerificacionTelefono;
	}


	public List<AcuseTelefonoModel> getAcuseTelefono(String tipoBusqueda, String parametroBusqueda) {
		logger.info("::: Realizando consultas para Info Acuse Telefono :::");
		List<AcuseTelefonoModel> infoAcuseTelefono = new ArrayList<AcuseTelefonoModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Acuse ");		
				logger.info(ConsultasSqlTelefono.getConsultaAcuseTelefonoRfc());				
			infoAcuseTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaAcuseTelefonoRfc(),
					new Object[] { parametroBusqueda}, new AcuseTelefonoRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query CURP Acuse ");			
				logger.info(ConsultasSqlTelefono.getConsultaAcuseTelefonoCurp());				
			infoAcuseTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaAcuseTelefonoCurp(),
					new Object[] { parametroBusqueda }, new AcuseTelefonoRowMapper());				
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query Telefono Acuse ");				
				logger.info(ConsultasSqlTelefono.getConsultaAcuseTelefonoEmail());								
				infoAcuseTelefono = jdbcTemplate.query(ConsultasSqlTelefono.getConsultaAcuseTelefonoEmail(),
						new Object[] {parametroBusqueda}, new AcuseTelefonoRowMapper());
			}
			logger.info("Informacion de base de datos Acuse Telefono ::: " + infoAcuseTelefono.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros infoAcuseTelefono para el RFC " + parametroBusqueda + " :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta infoAcuseTelefono ::: " + e.getMessage());

		}

		return infoAcuseTelefono;
	}

}
