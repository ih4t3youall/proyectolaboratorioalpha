package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.objetos.Producto;
import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.VistaAgregar;

public class ListenerFinalizarCarga implements ActionListener {

	private VistaAgregar vistaAgregar;
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");

	public ListenerFinalizarCarga(VistaAgregar vistaAgregar) {
		this.vistaAgregar = vistaAgregar;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		LinkedList<Producto> productos = vistaAgregar.getProductos();

		productoBO.guardarListaProductos(productos);
		JOptionPane.showMessageDialog(null,
				"Se han agregado " + productos.size() + " productos.");
		productos.clear();

	}

}
