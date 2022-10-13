package mx.gob.sat.sir.persistencia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mx.gob.sat.sir.persistencia.dao.BitacoraDao;
import mx.gob.sat.sir.persistencia.mapper.AplicativosRowMapper;
import mx.gob.sat.sir.utileria.model.AplicativosModel;
import mx.gob.sat.sir.utileria.model.BitacoraModel;
import mx.gob.sat.sir.utileria.sql.ConsultasSqlConstante;

@Service
public class BitacoraDaoImpl implements BitacoraDao {
	private final static Logger logger = Logger.getLogger(BitacoraDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	public int addBitacora(BitacoraModel bitacora){
    	int status = 0;
    	String sql = "INSERT INTO ET_MCEODNI1.BITACORA(CRITERIO_CONSULTADO, FECHA, IP, INF_CONSULTADA, APLICATIVO_CONSULTANTE) VALUES(?,?,?,?,?)";
    	Connection conn = null;
    	PreparedStatement ps = null;
	    
	        try {
	        conn = dataSource.getConnection();
	        ps = conn.prepareStatement(sql);    			        
 	        ps.setString(1, bitacora.getRfc());	        
 	        ps.setTimestamp(2,bitacora.getFechaConsulta());	    
 	        ps.setString(3, bitacora.getIp());	     	        
 	        ps.setString(4, bitacora.getInfConsultada());	        	        
 	        ps.setString(5,bitacora.getAplicativoConsultante());
 	        ps.addBatch();
 	        ps.executeBatch();
 	        status = 1;
 	    } catch (SQLException e) {		    	
 	    	logger.error( "Error insert Bitacora");	    	
 	    	logger.error( "failed!", e );
 	    } finally {
 	        if (conn != null) {
 	            try {           	            	
 	            conn.close(); 	            
 	            } catch (SQLException e) {
 	            	logger.error("Ocurio un error bitacora");
 	            }
 	        }
 	        if(ps != null){
 	            try {
					ps.close();
				} catch (SQLException e) {
 	            	logger.error("Ocurio un error bitacora");
				} 	
 	        }
 	    }
    	
    	return status;
    }

	public AplicativosModel getAplicativos(String idAplicativo) {
		AplicativosModel aplicativos = new AplicativosModel();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			aplicativos = jdbcTemplate.queryForObject(ConsultasSqlConstante.CONSULTA_APLICATIVOS.getSql(),
					new Object[] { idAplicativo }, new AplicativosRowMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.debug("::: No se encontraron registros para el ID Aplicativo " + idAplicativo + ":::");
		} catch (DataAccessException e) {
			logger.error(
					"Ocurrio un erro al momento de realizar la consulta Aplicativos Permitidos ::: " + e.getMessage());
		}
		return aplicativos;
	}
}
