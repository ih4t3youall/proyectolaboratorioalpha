package ar.com.lab.vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.helpers.SoloNumeros;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.listeners.ListenerFinalizarControl;
import ar.com.lab.listeners.ListenerModificarControl;
import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;
import ar.com.objetos.Comparador;

public class VistaControlar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	protected JComboBox<Producto> productos;
	protected JTextField pesoMedio, medMedio;
	private JButton agregar, finalizar, cancelar, modificar;
	protected LinkedList<ProductoControl> listaProductoControl;
	private JLabel labelPeso = new JLabel("Peso");
	private JLabel labelMedida = new JLabel("Medida");

	public VistaControlar() {

		setName("vistaControlar");

		setLayout(new GridLayout(0, 3));
		// init
		productos = new JComboBox<Producto>();
		listaProductoControl = new LinkedList<ProductoControl>();
		List<Producto> obtenerTodosLosProductos = productoBO
				.obtenerTodosLosProductos();
		productos.addItem(new Producto("Seleccione"));

		pesoMedio = new JTextField(10);
		medMedio = new JTextField(10);
		SoloNumeros soloNumeros = new SoloNumeros();
		pesoMedio.addKeyListener(soloNumeros);
		medMedio.addKeyListener(soloNumeros);

		agregar = new JButton("+");
		finalizar = new JButton("Finalizar");
		cancelar = new JButton("Cancelar");
		modificar = new JButton("Modificar");

		add(new JLabel(""));
		add(new JLabel("Controlar"));
		add(new JLabel(""));

		pesoMedio.setEnabled(false);
		medMedio.setEnabled(false);

		
		
		Collections.sort(obtenerTodosLosProductos,new Comparador());
		
		for (Producto producto : obtenerTodosLosProductos) {
			productos.addItem(producto);
		}
		
		
		add(productos);
		add(labelPeso);
		add(labelMedida);

		add(new JLabel("Media"));
		add(pesoMedio);
		add(medMedio);

		add(agregar);
		add(finalizar);
		add(cancelar);
		add(modificar);
		add(new JLabel());

		modificar.addActionListener(new ListenerModificarControl(
				listaProductoControl, this));

		
		
		
		productos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = (Producto) productos.getSelectedItem();
				pesoMedio.setEnabled(false);
				medMedio.setEnabled(false);
				if (producto.getNombre().equals("Seleccione")) {
					pesoMedio.setText("");
					medMedio.setText("");

				} else {
					boolean flag = false;
					if (producto.getPesoMax() > 0) {
						pesoMedio.setEnabled(true);
						pesoMedio.requestFocus();
						flag = true;
					}
					if (producto.getMedMax() > 0) {
						medMedio.setEnabled(true);
						if (!flag) {
							medMedio.requestFocus();

						}
					}

					if (producto.isDoblePeso()) {

						labelPeso.setText("Producto A");
						labelPeso.repaint();
						labelMedida.setText("Producto B");
						labelMedida.repaint();
						
					}else {
						labelPeso.setText("Peso");
						labelPeso.repaint();
						labelMedida.setText("Medida");
						labelMedida.repaint();
						
						
					}

				}

			}
		});

		crearKeyListeners();

		agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				control();

			}

		});

		cancelar.addActionListener(new ListenerCancelar(this));

		finalizar.addActionListener(new ListenerFinalizarControl(this));

		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);
		menuPrincipal.setSize(620, 145);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();

	}

	private void crearKeyListeners() {
		medMedio.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					control();

				}

			}
		});

		pesoMedio.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					control();

				}

			}

		});

	}

	private void agregarAlista() {
		Producto producto = (Producto) productos.getSelectedItem();
		boolean error = false;
		if (pesoMedio.isEnabled()) {

			if (!(producto.getPesoMin() < Double.parseDouble(pesoMedio
					.getText()))
					&& !(Double.parseDouble(pesoMedio.getText()) < producto
							.getPesoMax())) {
				error = true;
			}
		}

		if (medMedio.isEnabled()) {
			if (!(producto.getMedMin() < Double.parseDouble(medMedio.getText()) && Double
					.parseDouble(medMedio.getText()) < producto.getMedMax())) {

				error = true;

			}
		}

		ProductoControl productoControl = new ProductoControl(producto,
				Double.parseDouble(medMedio.getText()),
				Double.parseDouble(pesoMedio.getText()), error);
		listaProductoControl.add(productoControl);
		medMedio.setText("");
		pesoMedio.setText("");

	}

	public LinkedList<ProductoControl> getListaProductoControl() {

		return listaProductoControl;

	}

	public void control() {

		if (medMedio.isEnabled() && pesoMedio.isEnabled()) {
			if (medMedio.getText().equals("")) {
				medMedio.requestFocus();
			} else {
				if (!medMedio.getText().equals("")) {
					agregarAlista();
					pesoMedio.requestFocus();
				} else {

					JOptionPane.showMessageDialog(null,
							"Debe completar ambos campos.");
				}
			}

		}

		if (medMedio.isEnabled() && !pesoMedio.isEnabled()) {

			if (!medMedio.getText().equals("")) {
				pesoMedio.setText("0");
				agregarAlista();
			} else {
				JOptionPane.showMessageDialog(null,
						"debe completar la medida media.");
				medMedio.requestFocus();

			}

		}

		if (!medMedio.isEnabled() && pesoMedio.isEnabled()) {

			if (!pesoMedio.getText().equals("")) {

				medMedio.setText("0");
				agregarAlista();

			} else {
				JOptionPane.showMessageDialog(null,
						"debe completar el peso medio.");
				pesoMedio.requestFocus();

			}

		}

	}

}
