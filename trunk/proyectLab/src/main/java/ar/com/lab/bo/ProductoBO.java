package ar.com.lab.bo;

import java.util.LinkedList;
import java.util.List;

import ar.com.lab.dao.ProductoDAO;
import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;

public class ProductoBO {

	private ProductoDAO productoDAO;

	public void guardarListaProductos(LinkedList<Producto> productos) {

		productoDAO.saveProductos(productos);

	}
	
	public void obtenerTodosLosProductosControlados() {

		
		productoDAO.getProductosControlados();
		
	}


	public void eliminarProducto(Producto producto) {

		productoDAO.deleteProducto(producto);

	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public List<Producto> obtenerTodosLosProductos() {
		
		List<Producto> productos = productoDAO.getProductos();
		return productos;
	}

	public void guardarProductoControl(
			LinkedList<ProductoControl> listaProductoControl) {
		productoDAO.saveListaProductoControl(listaProductoControl);
		
	}

	public void modificarProductos(LinkedList<Producto> productosModificados) {
		productoDAO.modifyProducts(productosModificados);
		
	}

	
}
