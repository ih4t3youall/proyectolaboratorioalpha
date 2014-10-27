package ar.com.lab.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;

public class ProductoControlRowMapper implements RowMapper<ProductoControl> {

	@Override
	public ProductoControl mapRow(ResultSet rs, int arg1) throws SQLException {

		ProductoControl productoControl = new ProductoControl();
		productoControl.setIdProductoControl(rs.getInt("idProducto_control"));
		productoControl.setProducto(new Producto(rs.getInt("idProducto")));
		productoControl.setMedMedia(rs.getDouble("medMedia"));
		productoControl.setMedPeso(rs.getDouble("medPeso"));
		productoControl.setError(rs.getBoolean("error"));
		productoControl.setFecha(rs.getDate("fecha"));
		productoControl.setHora(rs.getString("hora"));

		return productoControl;
	}

}
