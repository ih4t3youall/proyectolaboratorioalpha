package ar.com.lab.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.lab.objetos.ProductoControl;

public class DateRowMapper implements RowMapper<Date> {

	@Override
	public Date mapRow(ResultSet rs, int arg1) throws SQLException {

		Date date = rs.getDate("fecha");
		return date;
				
	}

}
