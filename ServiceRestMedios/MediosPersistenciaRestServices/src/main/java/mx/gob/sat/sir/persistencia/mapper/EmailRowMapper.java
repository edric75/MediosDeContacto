package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.EmailModel;

public class EmailRowMapper implements RowMapper<EmailModel> {

	public EmailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmailModel emailModel = new EmailModel();
		emailModel.setRfc(rs.getString("RFC"));
		emailModel.setCurp(rs.getString("CURP"));
		emailModel.setEmail(rs.getString("EMAIL"));
		emailModel.setEmailPrincipal(rs.getString("EMAIL_PRINCIPAL"));
		emailModel.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
		emailModel.setEstatus(rs.getString("ESTATUS"));
		emailModel.setAplicativo(rs.getString("APLICATIVO"));
		emailModel.setFechaRegistroAplicativo(rs.getString("FECHA_REGISTRO_APLICATIVO"));
		emailModel.setFechaInicioVigencia(rs.getDate("FECHA_INICIO_VIGENCIA"));
		emailModel.setFechaFinVigencia(rs.getDate("FECHA_FIN_VIGENCIA"));
		emailModel.setFechaBaja(rs.getDate("FECHA_BAJA"));
		emailModel.setEstatusAplicativo(rs.getString("ESTATUS_APLICATIVO"));
		emailModel.setEmailDq(rs.getString("EMAIL_DQ"));
		emailModel.setFechaDWH(rs.getString("FECHA_DWH"));
		
		return emailModel;
	}

}
