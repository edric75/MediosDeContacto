package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.VerificacionTelefonoModel;

public class VerificacionTelefonoRowMapper implements RowMapper<VerificacionTelefonoModel>{

	public VerificacionTelefonoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		VerificacionTelefonoModel verificacionTelefono = new VerificacionTelefonoModel();
		verificacionTelefono.setRfc(rs.getString("RFC"));
		verificacionTelefono.setCurp(rs.getString("CURP"));
		verificacionTelefono.setTelefono(rs.getString("TELEFONO"));
		verificacionTelefono.setEnvioVerificacion(rs.getString("ENVIO_VERIFICACION"));
		verificacionTelefono.setFechaEnvioVerificacion(rs.getString("FECHA_ENVIO_VERIFICACION"));
		verificacionTelefono.setFechaVerificacion(rs.getString("FECHA_VERIFICACION"));
		verificacionTelefono.setEstatus(rs.getString("ESTATUS"));
		verificacionTelefono.setCausaNoVerificado(rs.getString("CAUSA_NO_VERIFICADO"));
		verificacionTelefono.setFechaDWH(rs.getString("FECHA_DWH"));
		return verificacionTelefono;
	}
}
