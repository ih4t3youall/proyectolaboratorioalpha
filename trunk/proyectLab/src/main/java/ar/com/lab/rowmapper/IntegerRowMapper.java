package ar.com.lab.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;

public class IntegerRowMapper  implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet rs, int arg1) throws SQLException {


		return rs.getInt(1);
	}

}
