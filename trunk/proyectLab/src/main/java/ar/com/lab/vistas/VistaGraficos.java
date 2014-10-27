package ar.com.lab.vistas;

import java.awt.FlowLayout;
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
import ar.com.lab.listeners.ListenerAceptarGraficos;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.objetos.Producto;
import ar.com.lab.spring.SpringContext;
import ar.com.objetos.Comparador;

public class VistaGraficos extends JPanel {
	private static final long serialVersionUID = 1L;
	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");

	protected ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");

	private JComboBox<String> seleccionarGrafico;
	private JComboBox<Date> seleccionarFechaInicial;
	private JComboBox<Date> seleccionarFechaFinal;
	private JComboBox<Producto> seleccionarProducto;
	private JButton aceptar, cancelar;

	public VistaGraficos() {

		setName("VistaGraficos");

		setLayout(new FlowLayout());
		List<Date> obtenerDiasCargados = productoBO.obtenerDiasCargados();
		List<Producto> productos = productoBO.obtenerTodosLosProductos();
		seleccionarFechaInicial = new JComboBox<Date>();
		seleccionarFechaFinal = new JComboBox<Date>();
		seleccionarFechaInicial.addItem(null);
		seleccionarFechaFinal.addItem(null);

		seleccionarGrafico = new JComboBox<String>();
		seleccionarProducto = new JComboBox<Producto>();

		for (Date date : obtenerDiasCargados) {
			seleccionarFechaInicial.addItem(date);
			seleccionarFechaFinal.addItem(date);

		}
		Collections.sort(productos,new Comparador());
		for (Producto producto : productos) {
			seleccionarProducto.addItem(producto);

		}

		seleccionarGrafico.addItem("Lineas");

		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		add(new JLabel("Tipo de grafico"));
		add(seleccionarGrafico);
		add(seleccionarFechaInicial);
		add(seleccionarFechaFinal);
		seleccionarProducto.setEnabled(false);
		add(seleccionarProducto);

		aceptar.setEnabled(false);
		add(aceptar);
		add(cancelar);
		seleccionarFechaInicial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (seleccionarFechaInicial.getSelectedIndex() == -1) {
					aceptar.setEnabled(false);
				} else {

					aceptar.setEnabled(true);
					seleccionarProducto.setEnabled(true);
					repaint();
					revalidate();

				}

			}
		});

		//listeners
		cancelar.addActionListener(new ListenerCancelar(this));
		aceptar.addActionListener(new ListenerAceptarGraficos(this));

		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);

		menuPrincipal.setSize(700, 700);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();

	}

	public JComboBox<String> getSeleccionarGrafico() {
		return seleccionarGrafico;
	}

	public JComboBox<Date> getSeleccionarFechaInicial() {
		return seleccionarFechaInicial;
	}

	public JComboBox<Date> getSeleccionarFechaFinal() {
		return seleccionarFechaFinal;
	}

	public Producto getSeleccionarproducto() {
		return (Producto)seleccionarProducto.getSelectedItem();
	}

}
