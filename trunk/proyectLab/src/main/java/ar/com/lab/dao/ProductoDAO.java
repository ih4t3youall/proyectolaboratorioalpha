package ar.com.lab.dao;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.lab.helpers.Tiempo;
import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.rowmapper.DateRowMapper;
import ar.com.lab.rowmapper.ProductoControlRowMapper;
import ar.com.lab.rowmapper.ProductoControlSolIntRowMapper;
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
			String sql = "insert into producto (nombre,medMax,medMin,pesoMax,pesoMin,fecha,doblePeso)values(?,?,?,?,?,now(),?)";
			jdbcTemplate.update(sql,
					new Object[] { producto.getNombre(), producto.getMedMax(),
							producto.getMedMin(), producto.getPesoMax(),
							producto.getPesoMin(),producto.isDoblePeso() });
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
					productoControl.getMedPeso(), productoControl.isError(),
					Tiempo.obtenerHora() });
		}

	}

	public List<ProductoControl> getProductosControlados() {
		String sql = "select * from producto_control";
		List<ProductoControl> query = jdbcTemplate.query(sql,
				new ProductoControlRowMapper());

		populateProductoControl(query);
		return query;

	}

	public void populateProductoControl(List<ProductoControl> query) {

		for (ProductoControl productoControl : query) {
			try {
				String sqlpProducto = "select * from producto where idProducto = ?";
				Producto queryProducto = jdbcTemplate.queryForObject(
						sqlpProducto, new Object[] { productoControl
								.getProducto().getIdProducto() },
						new ProductoRowMapper());
				productoControl.setProducto(queryProducto);
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				e.printStackTrace();
			}

		}

	}

	public List<ProductoControl> getControlProductsByDate(
			java.util.Date fechaInicial, java.util.Date fechaFinal,
			Producto producto) {

		String sql = "select * from producto_control where fecha between ? and ?  and idProducto=?";
		List<ProductoControl> query = jdbcTemplate.query(sql,
				new Object[] { fechaInicial.toString(), fechaFinal.toString(),
						producto.getIdProducto() },
				new ProductoControlRowMapper());
		return query;
	}

	public List<ProductoControl> getProductNameByDate(Date date) {

		String sql = "select  distinct idProducto from  producto_control where fecha = ?";
		List<ProductoControl> query = jdbcTemplate.query(sql,
				new Object[] { date.toString() },
				new ProductoControlSolIntRowMapper());

		populateProductoControl(query);

		for (ProductoControl productoControl : query) {
			System.out.println(productoControl.getProducto().getNombre());
		}

		return query;

	}

	public List<Date> getUsedDates() {

		String sql = "SELECT DISTINCTROW fecha FROM producto_control";
		List<Date> query = jdbcTemplate.query(sql, new DateRowMapper());
		return query;

	}

	public List<ProductoControl> getProductsInADate(Date fechaInicial,Date fechaFinal,
			Producto producto) {

		String sql = "select * from producto_control where fecha between ? and ? and idProducto = ?";
		List<ProductoControl> query = jdbcTemplate.query(sql, new Object[] {
				fechaInicial.toString(),fechaFinal.toString(), producto.getIdProducto() },
				new ProductoControlRowMapper());
		populateProductoControl(query);
		return query;

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
