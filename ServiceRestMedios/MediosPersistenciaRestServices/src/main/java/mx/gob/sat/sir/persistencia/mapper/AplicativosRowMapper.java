package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.AplicativosModel;

public class AplicativosRowMapper implements RowMapper<AplicativosModel> {

	public AplicativosModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AplicativosModel aplicativosnModel = new AplicativosModel();
		aplicativosnModel.setIdAplicativo(rs.getString("ID_APLICATIVO"));
		aplicativosnModel.setNombreAplicativo(rs.getString("NOMBRE_APLICATIVO"));
	
		return aplicativosnModel;
	}
}
