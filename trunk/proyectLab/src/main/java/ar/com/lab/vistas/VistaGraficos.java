package ar.com.lab.vistas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.listeners.ListenerAceptarGraficos;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;

public class VistaGraficos extends JPanel {
	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");
	
	protected ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	

	private JComboBox<String> seleccionarGrafico;
	private JComboBox<Date> seleccionarFecha;
	private JComboBox<ProductoControl> seleccionarProducto;
	private JButton aceptar, cancelar;

	public VistaGraficos() {

		setName("VistaGraficos");
		
		setLayout(new FlowLayout());
		List<Date> obtenerDiasCargados = productoBO.obtenerDiasCargados();
		
		seleccionarFecha = new JComboBox<Date>();
		seleccionarFecha.addItem(null);
		
		for (Date date : obtenerDiasCargados) {
			seleccionarFecha.addItem(date);
						
		}
		
		
		seleccionarGrafico = new JComboBox<String>();
		seleccionarProducto = new JComboBox<ProductoControl>();
		seleccionarGrafico.addItem("Lineas");

		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		add(new JLabel("Tipo de grafico"));
		add(seleccionarGrafico);
		add(seleccionarFecha);
		seleccionarProducto.setEnabled(false);
		add(seleccionarProducto);
		
		aceptar.setEnabled(false);
		add(aceptar);
		add(cancelar);
		seleccionarFecha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(seleccionarFecha.getSelectedIndex() == -1){
					aceptar.setEnabled(false);
				}else {
					
					aceptar.setEnabled(true);
					Date date = (Date)seleccionarFecha.getSelectedItem();
					  List<ProductoControl> productos = productoBO.obtenerProductosEnFecha(date);
					for (ProductoControl control : productos) {
						seleccionarProducto.addItem(control);
						
					}
					seleccionarProducto.setEnabled(true);
					seleccionarProducto.repaint();
					seleccionarProducto.revalidate();
				}
				
			}
		});
		
		cancelar.addActionListener(new ListenerCancelar(this));
		
		aceptar.addActionListener(new ListenerAceptarGraficos(this));
		
		
		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		menuPrincipal.setSize(700,700);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();
		

	}

	public JComboBox<String> getSeleccionarGrafico() {
		return seleccionarGrafico;
	}
	public JComboBox<Date>  getSeleccionarFecha() {
		return seleccionarFecha;
	}

	
	

}
