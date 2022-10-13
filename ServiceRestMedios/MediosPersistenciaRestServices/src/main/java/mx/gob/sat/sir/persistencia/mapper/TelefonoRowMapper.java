package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.TelefonoModel;

public class TelefonoRowMapper implements RowMapper<TelefonoModel>{

	public TelefonoModel mapRow(ResultSet rs, int rowNum) throws SQLException  {
		TelefonoModel telefonoModel = new TelefonoModel();
		
		telefonoModel.setRfc(rs.getString("RFC"));
		telefonoModel.setCurp(rs.getString("CURP"));
		telefonoModel.setTelefono(rs.getString("TELEFONO"));
		telefonoModel.setTelefonoPrincipal(rs.getString("TELEFONO_PRINCIPAL"));
		telefonoModel.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
		telefonoModel.setEstatus(rs.getString("ESTATUS"));
		telefonoModel.setAplicativo(rs.getString("APLICATIVO"));
		telefonoModel.setFechaRegistroAplicativo(rs.getString("FECHA_REGISTRO_APLICATIVO"));
		telefonoModel.setFechaInicioVigencia(rs.getDate("FECHA_INICIO_VIGENCIA"));
		telefonoModel.setFechaFinVigencia(rs.getDate("FECHA_FIN_VIGENCIA"));
		telefonoModel.setFechaBaja(rs.getDate("FECHA_BAJA"));
		telefonoModel.setEstatusAplicativo(rs.getString("ESTATUS_APLICATIVO"));
		telefonoModel.setTelefonoDq(rs.getString("TELEFONO_DQ"));
		telefonoModel.setFechaDWH(rs.getString("FECHA_DWH"));
		
		return telefonoModel;
	}

}
