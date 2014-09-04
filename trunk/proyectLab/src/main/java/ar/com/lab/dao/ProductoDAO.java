package ar.com.lab.dao;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.lab.helpers.Tiempo;
import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.rowmapper.DateRowMapper;
import ar.com.lab.rowmapper.ProductoControlRowMapper;
import ar.com.lab.rowmapper.ProductoRowMapper;

public class ProductoDAO {

	private JdbcTemplate jdbcTemplate;

	public List<Producto> getProductos() {

		String sql = "select * from producto;";
		List<Producto> query = jdbcTemplate.query(sql, new ProductoRowMapper());

		return query;

	}

	public void getProductosById() {

	}

	public void saveProductos(LinkedList<Producto> productos) {

		for (Producto producto : productos) {
			String sql = "insert into producto (nombre,medMax,medMin,pesoMax,pesoMin,fecha)values(?,?,?,?,?,now())";
			jdbcTemplate.update(sql,
					new Object[] { producto.getNombre(), producto.getMedMax(),
							producto.getMedMin(), producto.getPesoMax(),
							producto.getPesoMin() });
		}

	}

	public void deleteProducto(Producto producto) {
		String sql = "delete from producto where idProducto=?";
		jdbcTemplate.update(sql, new Object[] { producto.getIdProducto() });
	}



	public void modifyProducts(LinkedList<Producto> productosModificados) {
		for (Producto producto : productosModificados) {

			String sql = "update producto set nombre=?, medMax=?, medMin=?, pesoMax=?, pesoMin=? where idProducto=?";
			jdbcTemplate.update(sql,
					new Object[] { producto.getNombre(), producto.getMedMax(),
							producto.getMedMin(), producto.getPesoMax(),
							producto.getPesoMin(), producto.getIdProducto() });

		}

	}

	
	public void saveListaProductoControl(
			LinkedList<ProductoControl> listaProductoControl) {

		for (ProductoControl productoControl : listaProductoControl) {
			String sql = "insert into producto_control (idProducto,medMedia,medPeso,error,fecha,hora)values(?,?,?,?,now(),?)";
			jdbcTemplate.update(sql, new Object[] {
					productoControl.getProducto().getIdProducto(),
					productoControl.getMedMedia(),
					productoControl.getMedPeso(),
					productoControl.isError(),
					Tiempo.obtenerHora() });
		}

	}
	
	public void getProductosControlados() {
		String sql = "select * from producto_control;";
		List<ProductoControl> query = jdbcTemplate.query(sql,
				new ProductoControlRowMapper());

		for (ProductoControl productoControl : query) {

			String sqlpProducto = "select * from producto where idProducto = ?;";
			Producto queryProducto = jdbcTemplate.queryForObject(sql,
					new Object[] { productoControl.getProducto().getIdProducto() }, new ProductoRowMapper());
			productoControl.setProducto(queryProducto);

		}

	}
	
	
	public List<ProductoControl> getControlProductsByDate(java.util.Date date) {
	
				String sql = "select * from producto_control where fecha = ?";
				List<ProductoControl> query = jdbcTemplate.query(sql,new Object[]{date}, new ProductoControlRowMapper());
				return query;
		
	}
	
	
	public List<ProductoControl> getProductByDate(Date date) {
	String sql = "select * from producto_control where fecha = ?";
	List<ProductoControl> query = jdbcTemplate.query(sql, new Object[]{date},new ProductoControlRowMapper());
	return query;
		
	}

	
	public List<Date> getUsedDates(){
		
		String sql = "SELECT DISTINCTROW fecha FROM producto_control";
		List<Date> query = jdbcTemplate.query(sql,new DateRowMapper());
		return query;
		
	}

	public void saveProducto(Producto producto) {

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




}
