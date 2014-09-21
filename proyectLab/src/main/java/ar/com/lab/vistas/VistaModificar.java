package ar.com.lab.vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import ar.com.lab.objetos.Producto;
import ar.com.lab.spring.SpringContext;

public class VistaModificar extends JPanel {

	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	private JTextField pesoMax = new JTextField(10);
	private JTextField pesoMin = new JTextField(10);
	private JTextField medMax = new JTextField(10);
	private JTextField medMin = new JTextField(10);
	private JComboBox<Producto> productos;
	private JButton cambiarNombre, aceptar,cancelar;
	protected List<Producto> obtenerTodosLosProductos;
	public VistaModificar() {

		setName("vistaModificar");
		setLayout(new GridLayout(5, 5));
		
		//init
		cambiarNombre = new JButton("Cambiar Nombre");
		aceptar =  new JButton("Aceptar");
		cancelar = new JButton("cancelar");

		productos = new JComboBox<Producto>();
		obtenerTodosLosProductos = productoBO
				.obtenerTodosLosProductos();
		productos.addItem(new Producto("Seleccione"));
		for (Producto producto : obtenerTodosLosProductos) {

			productos.addItem(producto);

		}

		medMax.setEnabled(false);
		medMin.setEnabled(false);
		pesoMax.setEnabled(false);
		pesoMin.setEnabled(false);
		
		SoloNumeros soloNumeros = new SoloNumeros();
		medMax.addKeyListener(soloNumeros);
		medMin.addKeyListener(soloNumeros);
		pesoMax.addKeyListener(soloNumeros);
		pesoMin.addKeyListener(soloNumeros);
		
	
		
		add(new JLabel("Producto: "));
		add(productos);
		add(cambiarNombre);
		add(new JLabel());
		add(new JLabel("Medidas"));

		
		pesoMax.setText("0");
		pesoMin.setText("0");
		medMax.setText("0");
		medMin.setText("0");

		add(medMin);
		add(medMax);
		add(new JLabel(""));
		add(new JLabel("peso"));
		add(pesoMin);
		add(pesoMax);
		add(new JLabel(""));
		add(new JLabel(""));

		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		setVisible(true);
		
		add(aceptar);
		add(cancelar);

		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);
		menuPrincipal.setSize(531, 140);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();

		cambiarNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String showInputDialog = JOptionPane.showInputDialog("Ingrese nuevo nombre.");
				((Producto)(productos.getSelectedItem())).setNombre(showInputDialog);
				productos.revalidate();
				productos.repaint();
				
				
			}
		});
		
		productos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = (Producto) productos.getSelectedItem();

				if (producto.getNombre().equals("Seleccione")) {

					medMax.setEnabled(false);
					medMin.setEnabled(false);
					pesoMax.setEnabled(false);
					pesoMin.setEnabled(false);

				} else {

					medMax.setEnabled(true);
					medMin.setEnabled(true);
					pesoMax.setEnabled(true);
					pesoMin.setEnabled(true);
					producto.getNombre();
					medMin.setText(String.valueOf(producto.getMedMin()));
					medMax.setText(String.valueOf(producto.getMedMax()));
					pesoMin.setText(String.valueOf(producto.getPesoMin()));
					pesoMax.setText(String.valueOf(producto.getPesoMax()));
				}

			}
		});

		cancelar.addActionListener(new ListenerCancelar(this));
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Producto productoaux = (Producto)productos.getSelectedItem();
				productoaux.setMedMax(Double.parseDouble(medMax.getText()));
				productoaux.setMedMin(Double.parseDouble(medMin.getText()));
				productoaux.setPesoMax(Double.parseDouble(pesoMax.getText()));
				productoaux.setPesoMin(Double.parseDouble(pesoMin.getText()));
				
				
				LinkedList<Producto> productosModificados = new LinkedList<Producto>();
				for (Producto producto : obtenerTodosLosProductos) {
					productosModificados.add(producto);
				}
				
				productoBO.modificarProductos(productosModificados);
				
				JOptionPane.showMessageDialog(null, "El producto ah sido modificado");
				
				
			}
		});
		
	}

}
