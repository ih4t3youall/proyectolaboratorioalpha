package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.MenuPrincipal;
import ar.com.lab.vistas.VistaAgregar;
import ar.com.lab.vistas.VistaControlar;
import ar.com.lab.vistas.VistaEliminar;
import ar.com.lab.vistas.VistaExcel;
import ar.com.lab.vistas.VistaGraficos;
import ar.com.lab.vistas.VistaModificar;

public class ListenerCancelar implements ActionListener {

	private Object contexto;
	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");

	public ListenerCancelar(Object contexto) {
		this.contexto = contexto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String padre = ((JButton) e.getSource()).getParent().getName();

		if (padre.equals("vistaAgregar")) {

			VistaAgregar vistaAgregar = (VistaAgregar) contexto;
			int size = vistaAgregar.getProductos().size();
			int confirmado = 0;
			if (size != 0) {

				confirmado = JOptionPane.showConfirmDialog(vistaAgregar,
						"Tiene " + size
								+ " productos sin agregar,desea eliminarlos? ");
			} else {
				confirmado = 0;

			}

			if (JOptionPane.OK_OPTION == confirmado) {
				vistaAgregar.removeAll();
				menuPrincipal.remove(vistaAgregar);
			}

		}
		if (padre.equals("vistaEliminar")) {

			VistaEliminar vistaEliminar = (VistaEliminar) contexto;
			vistaEliminar.removeAll();
			menuPrincipal.remove(vistaEliminar);
		}

		if (padre.equals("vistaControlar")) {

			VistaControlar vistaControlar = (VistaControlar) contexto;
			int size = vistaControlar.getListaProductoControl().size();
			int confirmado = 0;
			if (size != 0) {

				confirmado = JOptionPane.showConfirmDialog(vistaControlar,
						"Tiene " + size
								+ " productos sin agregar,desea eliminarlos? ");
			} else {
				confirmado = 0;

			}

			if (JOptionPane.OK_OPTION == confirmado) {
				vistaControlar.removeAll();
				menuPrincipal.remove(vistaControlar);
			}
		}
		if (padre.equals("vistaModificar")) {
			VistaModificar vistaModificar = (VistaModificar) contexto;
			vistaModificar.removeAll();
			menuPrincipal.remove(vistaModificar);

		}
		if (padre.equals("VistaGraficos")) {
			VistaGraficos vistaGraficos = (VistaGraficos) contexto;
			vistaGraficos.removeAll();
			menuPrincipal.remove(vistaGraficos);

		}

		if (padre.equals("VistaExcel")) {
			VistaExcel vistaExcel = (VistaExcel) contexto;
			vistaExcel.removeAll();
			menuPrincipal.remove(vistaExcel);

		}

		menuPrincipal.repaint();
		menuPrincipal.revalidate();

	}

}
