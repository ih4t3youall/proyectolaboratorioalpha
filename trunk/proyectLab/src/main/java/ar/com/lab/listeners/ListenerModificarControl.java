package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.vistas.VistaControlar;
import ar.com.lab.vistas.VistaModificarProductoControl;

public class ListenerModificarControl implements ActionListener {

	private LinkedList<ProductoControl> listaProductoControl;
	private VistaControlar vistaControlar;
	
	public ListenerModificarControl(LinkedList<ProductoControl> listaProductoControl, VistaControlar vistaControlar){
		
		this.listaProductoControl = listaProductoControl;
		this.vistaControlar = vistaControlar;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		new VistaModificarProductoControl(vistaControlar,listaProductoControl);
		
		
		
		
	}

	
	
	


}
