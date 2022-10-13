package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.AcuseTelefonoModel;

public class AcuseTelefonoRowMapper implements RowMapper<AcuseTelefonoModel> {

	public AcuseTelefonoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AcuseTelefonoModel acuseModel = new AcuseTelefonoModel();
		acuseModel.setRfc(rs.getString("RFC"));
		acuseModel.setCurp(rs.getString("CURP"));
		acuseModel.setTelefono(rs.getString("TELEFONO"));
		acuseModel.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
		acuseModel.setCadenaAcuse(rs.getString("CADENA_ACUSE"));
		acuseModel.setFolioAcuse(rs.getInt("FOLIO_ACUSE"));
		acuseModel.setFechaDWH(rs.getString("FECHA_DWH"));
		return acuseModel;
	}

}
