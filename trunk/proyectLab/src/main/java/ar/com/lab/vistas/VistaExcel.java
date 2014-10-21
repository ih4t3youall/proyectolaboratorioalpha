package ar.com.lab.vistas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.listeners.ListenerGenerarExcel;
import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;
import ar.com.objetos.Comparador;

public class VistaExcel extends JPanel {

	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");
	protected ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");

	private JComboBox<Date> fechaInicial;
	private JComboBox<Date> fechaFinal;
	private JComboBox<Producto> seleccionarProducto;
	private JButton aceptar, cancelar;

	public VistaExcel() {

		setName("VistaExcel");
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		fechaInicial = new JComboBox<Date>();
		fechaFinal = new JComboBox<Date>();
		seleccionarProducto = new JComboBox<Producto>();
		List<Date> diasCargados = productoBO.obtenerDiasCargados();

		for (Date date1 : diasCargados) {

			fechaInicial.addItem(date1);
			fechaFinal.addItem(date1);
		}

		Date date = (Date) fechaInicial.getSelectedItem();

		List<Producto> obtenerProductosEnFecha = productoBO.obtenerTodosLosProductos();
				
		Collections.sort(obtenerProductosEnFecha,new Comparador());
		for (Producto producto : obtenerProductosEnFecha) {
			seleccionarProducto.addItem(producto);
		}

		

		setLayout(new FlowLayout());

		aceptar.addActionListener(new ListenerGenerarExcel(this));
		cancelar.addActionListener(new ListenerCancelar(this));
		add(new JLabel("Fecha inicial"));
		add(fechaInicial);
		add(new JLabel("Fecha final"));
		add(fechaFinal);
		add(seleccionarProducto);
		add(aceptar);
		add(cancelar);

		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);

		menuPrincipal.setSize(750, 125);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();

	}

	public Producto getSeleccionarProducto() {

		return (Producto)seleccionarProducto.getSelectedItem();

	}

	public Date getSeleccionarDateInicial() {

		return (Date)fechaInicial.getSelectedItem();

	}
	
	public Date getSeleccionarDateFinal() {

		return (Date)fechaFinal.getSelectedItem();

	}
	

}
