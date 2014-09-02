package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ar.com.lab.vistas.GeneradorGraficos;
import ar.com.lab.vistas.VistaGraficos;

public class ListenerAceptarGraficos implements ActionListener {
	
	private VistaGraficos contexto;

	public ListenerAceptarGraficos(VistaGraficos vistaGraficos) {

		contexto = vistaGraficos;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String tipoGrafico = (String)contexto.getSeleccionarGrafico().getSelectedItem();
		
		
		if(tipoGrafico.equals("Lineas")){
			
			GeneradorGraficos generadorGraficos = new GeneradorGraficos("Pesos");
			
		}
		
		

	}

}
