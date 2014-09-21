package ar.com.lab.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;

public class ProductoControlSolIntRowMapper  implements RowMapper<ProductoControl> {

	@Override
	public ProductoControl mapRow(ResultSet rs, int arg1) throws SQLException {

		ProductoControl prod = new ProductoControl();
		Producto producto = new Producto();
		producto.setIdProducto(rs.getInt("idProducto"));
		prod.setProducto(producto);
		return prod;
				
	}

}
