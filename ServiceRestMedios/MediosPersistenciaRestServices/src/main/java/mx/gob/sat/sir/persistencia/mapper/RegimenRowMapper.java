package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.RegimenModel;

public class RegimenRowMapper implements RowMapper<RegimenModel> {

	public RegimenModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegimenModel regimenModel = new RegimenModel();
		regimenModel.setRfc(rs.getString("RFC"));
		regimenModel.setCurp(rs.getString("CURP"));
		regimenModel.setIdRegimen(rs.getString("ID_REGIMEN"));		
		regimenModel.setRegimen(rs.getString("REGIMEN"));
		regimenModel.setFechaAltaRegimen(rs.getDate("FECHA_ALTA_REGIMEN"));
		regimenModel.setFechaEfectivaAlta(rs.getDate("FECHA_EFECTIVA_ALTA"));
		regimenModel.setFechaBajaRegimen(rs.getDate("FECHA_BAJA_REGIMEN"));
		regimenModel.setFechaRegistroBaja(rs.getDate("FECHA_EFECTIVA_BAJA"));
		regimenModel.setFechaDWH(rs.getString("FECHA_DWH"));
		// TODO Auto-generated method stub
		return regimenModel;
	}

}
