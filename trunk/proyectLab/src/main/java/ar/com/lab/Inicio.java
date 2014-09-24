package ar.com.lab;

import ar.com.lab.cargando.PantallaCargandoMain;
import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.MenuPrincipal;

public class Inicio {

	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext.getContext()
			.getBean("menuPrincipal");
	public Inicio(){
		
		menuPrincipal.inicio();
		new PantallaCargandoMain();
		menuPrincipal.setVisible(true);
		
	}
	
	
}
