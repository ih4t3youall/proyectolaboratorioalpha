package ar.com.lab.vistas;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.listeners.ListenerEliminarProducto;
import ar.com.lab.objetos.Producto;
import ar.com.lab.spring.SpringContext;

public class VistaEliminar extends JPanel {

	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	private JButton eliminar, cancelar;

	private JComboBox<Producto> productos;

	public VistaEliminar() {
		setLayout(new FlowLayout());
		setName("vistaEliminar");
		productos = new JComboBox<Producto>();
		eliminar = new JButton("Eliminar");
		cancelar = new JButton("Cancelar");

		cargarProductos();

		add(productos);
		add(eliminar);
		add(cancelar);

		eliminar.addActionListener(new ListenerEliminarProducto(productos, this));
		cancelar.addActionListener(new ListenerCancelar(this));

		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);
		menuPrincipal.setSize(531, 140);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();

	}

	public void cargarProductos() {

		List<Producto> obtenerTodosLosProductos = productoBO
				.obtenerTodosLosProductos();

		for (Producto producto : obtenerTodosLosProductos) {

			productos.addItem(producto);

		}

	}

	public void refresh() {

		productos.removeAllItems();
		cargarProductos();
		productos.revalidate();
		productos.repaint();
		this.repaint();
		this.revalidate();
		
	}

}
