package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.AutenticacionModel;

public class AutenticacionRowMapper implements RowMapper<AutenticacionModel> {

	public AutenticacionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AutenticacionModel autenticacionModel = new AutenticacionModel();
		autenticacionModel.setRfc(rs.getString("RFC"));
		autenticacionModel.setCurp(rs.getString("CURP"));
		autenticacionModel.setAutenticacion(rs.getString("EFIRMA_CONTRASENA"));
		autenticacionModel.setFechaDWH(rs.getString("FECHA_DWH"));
		return autenticacionModel;
	}

}
