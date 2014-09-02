package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ar.com.lab.objetos.Producto;
import ar.com.lab.vistas.VistaAgregar;

public class ListenerAceptarProductoNuevo implements ActionListener {

	
	private VistaAgregar vistaAgregar;
	public ListenerAceptarProductoNuevo(VistaAgregar vistaAgregar) {
		this.vistaAgregar = vistaAgregar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Producto producto = vistaAgregar.getProducto();
		
		
		if (producto.getMedMax() < producto.getMedMin() || producto.getPesoMax() < producto.getPesoMin() ){
			
			vistaAgregar.addlista(producto);
			
			
		}
		vistaAgregar.reset();
		
		
		
	}

	
	
}
