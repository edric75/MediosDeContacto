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

import mx.gob.sat.sir.persistencia.dao.EmailDao;
import mx.gob.sat.sir.persistencia.mapper.AcuseMailRowMapper;
import mx.gob.sat.sir.persistencia.mapper.EmailRowMapper;
import mx.gob.sat.sir.persistencia.mapper.VerificacionMailRowMapper;
import mx.gob.sat.sir.utileria.model.AcuseMailModel;
import mx.gob.sat.sir.utileria.model.EmailModel;
import mx.gob.sat.sir.utileria.model.VerificacionMailModel;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlConstante;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlEmail;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlTelefono;

@Service
public class EmailDaoImpl implements EmailDao{
	
	private final static Logger logger = Logger.getLogger(EmailDaoImpl.class);

	@Autowired
	private DataSource dataSource;


	public List<EmailModel> getinfoEmail(String tipoBusqueda, String parametroBusqueda) {
		List<EmailModel> infoEmail = new ArrayList<EmailModel>();
		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info(" QUERY RFC Email ");				
				logger.info(ConsultasSqlEmail.getConsultaEmailRfc());								
				infoEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaEmailRfc(),
						new Object[] { parametroBusqueda }, new EmailRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info(" QUERY CURP Email ");
				logger.info(ConsultasSqlEmail.getConsultaEmailCurp());	
				infoEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaEmailCurp(),
						new Object[] { parametroBusqueda }, new EmailRowMapper());				
			}else if(tipoBusqueda.equals("3")){
				logger.info(" QUERY EMAIL ");		
				logger.info(ConsultasSqlEmail.getConsultaEmailEmail());	
				infoEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaEmailEmail(),
						new Object[] { parametroBusqueda }, new EmailRowMapper());				
			}
			logger.info("Informacion de base de datos Email ::: " + infoEmail.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros para el RFC Email" + parametroBusqueda + " info Email :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta info Email ::: " + e.getMessage());
		}

		return infoEmail;
	
	}


	public List<VerificacionMailModel> getInfoVerificacionMail(String tipoBusqueda, String parametroBusqueda) {
		List<VerificacionMailModel> infoVerificacionEmail = new ArrayList<VerificacionMailModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Verificacion Mail ");
				logger.info(ConsultasSqlEmail.getConsultaVerificacionEmailRfc());
				infoVerificacionEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaVerificacionEmailRfc(),
						new Object[] { parametroBusqueda}, new VerificacionMailRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query CURP Verificacion Mail ");				
				logger.info(ConsultasSqlEmail.getConsultaVerificacionEmailCurp());				
				infoVerificacionEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaVerificacionEmailCurp(),
						new Object[] { parametroBusqueda }, new VerificacionMailRowMapper());
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query Verificacion Email ");
				logger.info(ConsultasSqlEmail.getConsultaVerificacionEmailEmail());								
				infoVerificacionEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaVerificacionEmailEmail(),
						new Object[] { parametroBusqueda }, new VerificacionMailRowMapper());
			}
			logger.info("Informacion de base de datos Verificacion Mail::: " + infoVerificacionEmail.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros para el RFC Verificacion" + parametroBusqueda + " infoVerificacionEmail :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta info infoVerificacionEmail ::: " + e.getMessage());
	
		}

		return infoVerificacionEmail;
	}


	public List<AcuseMailModel> getInfoAcuseMail(String tipoBusqueda, String parametroBusqueda) {
		List<AcuseMailModel> infoVerificacionAcuseEmail = new ArrayList<AcuseMailModel>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(tipoBusqueda.equals("1")){
				logger.info("Query RFC Acuse Mail");		
				logger.info(ConsultasSqlEmail.getConsultaAcuseEmailRfc());								
				infoVerificacionAcuseEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaAcuseEmailRfc(),
						new Object[] { parametroBusqueda}, new AcuseMailRowMapper());
			}else if(tipoBusqueda.equals("2")){
				logger.info("Query CURP Acuse Mail");				
				logger.info(ConsultasSqlEmail.getConsultaAcuseEmailCurp());												
				infoVerificacionAcuseEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaAcuseEmailCurp(),
						new Object[] { parametroBusqueda}, new AcuseMailRowMapper());				
			}else if(tipoBusqueda.equals("3")){
				logger.info("Query Email Acuse Mail");
				logger.info(ConsultasSqlEmail.getConsultaAcuseEmailEmail());																
				infoVerificacionAcuseEmail = jdbcTemplate.query(ConsultasSqlEmail.getConsultaAcuseEmailEmail(),
						new Object[] { parametroBusqueda}, new AcuseMailRowMapper());	
			}
			logger.info("Informacion de base de datos Acuse Mail ::: " + infoVerificacionAcuseEmail.size());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros para el RFC Acuse" + parametroBusqueda + " infoVerificacionAcuseEmail :::");
		} catch (DataAccessException e) {
			logger.error("Ocurrio un erro al momento de realizar la consulta info infoVerificacionAcuseEmail ::: " + e.getMessage());
		}

		return infoVerificacionAcuseEmail;
	}

}
