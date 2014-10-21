package ar.com.lab.rowmapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.lab.objetos.Producto;

public class ProductoRowMapper implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int arg1) throws SQLException {

		Producto producto = new Producto();
		producto.setIdProducto(rs.getInt("idProducto"));
		producto.setNombre(rs.getString("nombre"));
		producto.setMedMax(rs.getDouble("medMax"));
		producto.setMedMin(rs.getDouble("medMin"));
		producto.setPesoMax(rs.getDouble("pesoMax"));
		producto.setPesoMin(rs.getDouble("pesoMin"));
		producto.setDoblePeso(rs.getBoolean("doblePeso"));

		return producto;
	}

}
