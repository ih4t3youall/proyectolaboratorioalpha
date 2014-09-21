package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ar.com.lab.vistas.VistaControlar;
import ar.com.lab.vistas.VistaExcel;

public class ListenerGenerico implements ActionListener {

	private VistaExcel vista;
	
	public ListenerGenerico(VistaExcel vistaAgregar) {
		this.vista = vistaAgregar;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		int height = vista.getHeight();
		int width = vista.getWidth();
		
		JOptionPane.showMessageDialog(null, "height:"+height+" width"+width);
		
	}
	
	
}
