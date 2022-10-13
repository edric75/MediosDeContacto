package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.AcuseMailModel;

public class AcuseMailRowMapper implements RowMapper<AcuseMailModel>{

	public AcuseMailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AcuseMailModel acuseMail = new AcuseMailModel();
		acuseMail.setRfc(rs.getString("RFC"));
		acuseMail.setCurp(rs.getString("CURP"));
		acuseMail.setEmail(rs.getString("EMAIL"));
		acuseMail.setAplicativo(rs.getString("APLICATIVO"));
		acuseMail.setFechaEmision(rs.getDate("FECHA_EMISION"));
		acuseMail.setCadenaAcuse(rs.getString("CADENA_ACUSE"));
		acuseMail.setFolioAcuse(rs.getString("FOLIO_ACUSE"));
		acuseMail.setFechaDWH(rs.getString("FECHA_DWH"));
		return acuseMail;
	}

}
