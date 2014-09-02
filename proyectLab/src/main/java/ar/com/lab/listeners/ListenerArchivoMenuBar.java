package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import ar.com.lab.config.ConfMenuBars;
import ar.com.lab.vistas.GeneradorGraficos;
import ar.com.lab.vistas.MenuPrincipal;
import ar.com.lab.vistas.VistaAgregar;
import ar.com.lab.vistas.VistaControlar;
import ar.com.lab.vistas.VistaEliminar;
import ar.com.lab.vistas.VistaGraficos;
import ar.com.lab.vistas.VistaModificar;

public class ListenerArchivoMenuBar implements ActionListener {

	String[] archivo = ConfMenuBars.ARCHIVO;
	private MenuPrincipal menuPrincipal;

	public ListenerArchivoMenuBar(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem menuItem = (JMenuItem) e.getSource();

		String text = menuItem.getText();
		if (text.equals(archivo[0])) {
			// agregar
			new VistaAgregar();

		}
		if (text.equals(archivo[1])) {

			// controlar
			new VistaControlar();
		}
		if (text.equals(archivo[2])) {
			// eliminar
			new VistaEliminar();
		}
		if (text.equals(archivo[3])) {
			// modificar
			new VistaModificar();
		}
		if (text.equals(archivo[4])) {
			// modificar
			new VistaGraficos();
		}
	

	}

}
