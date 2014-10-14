package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.objetos.Producto;
import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.VistaEliminar;

public class ListenerEliminarProducto implements ActionListener {

	private JComboBox<Producto> productos;
	
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	private VistaEliminar vistaEliminar;
	
	public ListenerEliminarProducto(JComboBox<Producto> productos,VistaEliminar vistaEliminar){
		
		this.productos = productos;
		this.vistaEliminar = vistaEliminar;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Producto producto =(Producto)productos.getSelectedItem();
		productoBO.eliminarProducto(producto);
		vistaEliminar.refresh();
		JOptionPane.showMessageDialog(null, "El producto "+producto.getNombre()+" ah sido eliminado exitosamente.");
		

	}

}
