package ar.com.lab.vistas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.listeners.ListenerAceptarGraficos;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.spring.SpringContext;

public class VistaGraficos extends JPanel {
	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");
	
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	

	private JComboBox<String> seleccionarGrafico;
	private JButton aceptar, cancelar;

	public VistaGraficos() {

		setLayout(new FlowLayout());

		seleccionarGrafico = new JComboBox<String>();
		seleccionarGrafico.addItem("Lineas");

		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		add(seleccionarGrafico);
		add(aceptar);
		add(cancelar);
		
		productoBO.obtenerTodosLosProductosControlados();
		
		cancelar.addActionListener(new ListenerCancelar(this));
		
		aceptar.addActionListener(new ListenerAceptarGraficos(this));
		
		
		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);
		menuPrincipal.setSize(300, 150);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();
		

	}

	public JComboBox<String> getSeleccionarGrafico() {
		return seleccionarGrafico;
	}


	
	

}
