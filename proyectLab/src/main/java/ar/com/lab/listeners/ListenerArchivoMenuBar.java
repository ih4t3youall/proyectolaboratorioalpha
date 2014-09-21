package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ar.com.lab.config.ConfMenuBars;
import ar.com.lab.vistas.MenuPrincipal;
import ar.com.lab.vistas.VistaAgregar;
import ar.com.lab.vistas.VistaControlar;
import ar.com.lab.vistas.VistaEliminar;
import ar.com.lab.vistas.VistaExcel;
import ar.com.lab.vistas.VistaGraficos;
import ar.com.lab.vistas.VistaModificar;

public class ListenerArchivoMenuBar implements ActionListener {

	String[] archivo = ConfMenuBars.ARCHIVO;
	private MenuPrincipal menuPrincipal;
	private JPanel panel;

	public ListenerArchivoMenuBar(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
		panel = null;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem menuItem = (JMenuItem) e.getSource();

		String text = menuItem.getText();

		if (panel != null) {

			menuPrincipal.remove(panel);
			
		}

		if (text.equals(archivo[0])) {
			// agregar
			panel = new VistaAgregar();
		}
		if (text.equals(archivo[1])) {

			// controlar
			panel = new VistaControlar();
		}
		if (text.equals(archivo[2])) {
			// eliminar
			panel = new VistaEliminar();
		}
		if (text.equals(archivo[3])) {
			// modificar
			panel = new VistaModificar();
		}
		if (text.equals(archivo[4])) {
			// modificar
			panel = new VistaGraficos();
		}
		if (text.equals(archivo[5])) {
			//excel
			panel = new VistaExcel();
			
		}

	}

}
