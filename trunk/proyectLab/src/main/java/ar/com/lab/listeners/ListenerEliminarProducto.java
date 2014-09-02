package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.objetos.Producto;
import ar.com.lab.spring.SpringContext;

public class ListenerEliminarProducto implements ActionListener {

	private JComboBox<Producto> productos;
	
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	
	
	public ListenerEliminarProducto(JComboBox<Producto> productos){
		
		this.productos = productos;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		productoBO.eliminarProducto((Producto)productos.getSelectedItem());
		
		

	}

}
