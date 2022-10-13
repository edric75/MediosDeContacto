package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.VerificacionMailModel;

public class VerificacionMailRowMapper implements RowMapper<VerificacionMailModel>{

	public VerificacionMailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		VerificacionMailModel verificacionMailModel = new VerificacionMailModel();
		verificacionMailModel.setRfc(rs.getString("RFC"));
		verificacionMailModel.setCurp(rs.getString("CURP"));
		verificacionMailModel.setEmail(rs.getString("EMAIL"));
		verificacionMailModel.setAplicativo(rs.getString("APLICATIVO"));
		verificacionMailModel.setEnvioVerificacion(rs.getString("ENVIO_VERIFICACION"));
		verificacionMailModel.setFechaEnvioVerificacion(rs.getString("FECHA_ENVIO_VERIFICACION"));
		verificacionMailModel.setFechaVerificacion(rs.getString("FECHA_VERIFICACION"));
		verificacionMailModel.setEstatusVerificacion(rs.getString("ESTATUS_VERIFICACION"));
		verificacionMailModel.setCausaNoVerificADA(rs.getString("CAUSA_NO_VERIFICADO"));
		verificacionMailModel.setFechaDWH(rs.getString("FECHA_DWH"));
		
		return verificacionMailModel;
	}

}
