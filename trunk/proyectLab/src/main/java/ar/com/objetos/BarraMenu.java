package ar.com.objetos;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ar.com.lab.config.ConfMenuBars;
import ar.com.lab.listeners.ListenerArchivoMenuBar;
import ar.com.lab.vistas.MenuPrincipal;

public class BarraMenu extends JMenuBar {

	
	private static final long serialVersionUID = 1L;
	
	
	public BarraMenu(MenuPrincipal menuPrincipal){
		
		
		JMenu archivo = new JMenu("archivo");
		add(archivo);
		ListenerArchivoMenuBar listener = new ListenerArchivoMenuBar(menuPrincipal);
		
		
		for (int i = 0; i < ConfMenuBars.ARCHIVO.length; i++) {
			JMenuItem jMenuItem = new JMenuItem(ConfMenuBars.ARCHIVO[i]);
			jMenuItem.addActionListener(listener);
			archivo.add(jMenuItem);
			
			
		}
		
		
		
		
		
		
	}
	
}
