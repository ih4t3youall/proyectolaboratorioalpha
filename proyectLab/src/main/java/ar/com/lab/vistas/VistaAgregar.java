package ar.com.lab.vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.com.lab.helpers.SoloNumeros;
import ar.com.lab.listeners.ListenerAceptarProductoNuevo;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.listeners.ListenerFinalizarCarga;
import ar.com.lab.listeners.ListenerFocusTextField;
import ar.com.lab.objetos.Producto;
import ar.com.lab.spring.SpringContext;

public class VistaAgregar extends JPanel {

	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");

	// componentes
	private JTextField nombre = new JTextField(10);
	private JTextField pesoMax = new JTextField(10);
	private JTextField pesoMin = new JTextField(10);
	private JTextField medMax = new JTextField(10);
	private JTextField medMin = new JTextField(10);
	private JButton finalizar = new JButton("Finalizar");
	private JButton cancelar = new JButton("Cancelar");
	private JButton agregar = new JButton("+");
	private LinkedList<Producto> productos = new LinkedList<Producto>();

	public VistaAgregar() {
		setName("vistaAgregar");
		setLayout(new GridLayout(4, 4));
		
		add(new JLabel("Nombre"));
		add(nombre);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel("Medidas"));

		SoloNumeros soloNumeros = new SoloNumeros();
		medMax.addKeyListener(soloNumeros);
		medMin.addKeyListener(soloNumeros);
		pesoMax.addKeyListener(soloNumeros);
		pesoMin.addKeyListener(soloNumeros);
		pesoMax.setText("0");
		pesoMin.setText("0");
		medMax.setText("0");
		medMin.setText("0");
		
		ListenerFocusTextField listenerFocus = new ListenerFocusTextField();
		pesoMax.addFocusListener(listenerFocus);
		pesoMin.addFocusListener(listenerFocus);
		medMax.addFocusListener(listenerFocus);
		medMin.addFocusListener(listenerFocus);

		add(medMin);
		add(medMax);
//		add(checkMed);
		add(new JLabel(""));
		add(new JLabel("peso"));
		add(pesoMin);
		add(pesoMax);
//		add(checkPeso);
		add(new JLabel(""));
		add(agregar);

		add(finalizar);
		add(cancelar);
		setVisible(true);
		
		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);
		menuPrincipal.setSize(531, 140);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();
		
		agregar.addActionListener(new ListenerAceptarProductoNuevo(this));
		finalizar.addActionListener(new ListenerFinalizarCarga(this));
		cancelar.addActionListener(new ListenerCancelar(this));


		createKeyListeners();
		
	}

	public Producto getProducto() {

		Producto producto = new Producto(nombre.getText(),
				Double.parseDouble(pesoMax.getText()),
				Double.parseDouble(pesoMin.getText()),
				Double.parseDouble(medMax.getText()), Double.parseDouble(medMin
						.getText()));

		return producto;
	}

	public void addlista(Producto producto) {

		productos.add(producto);

	}

	public LinkedList<Producto> getProductos() {
		return productos;

	}


	public void reset() {
		nombre.setText("");
		medMax.setText("0");
		medMin.setText("0");
		pesoMax.setText("0");
		pesoMin.setText("0");

	}

	private void createKeyListeners(){
		
	pesoMax.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			addlista(getProducto());
			reset();
			nombre.requestFocus();
			}
			
		}
	});
		
	medMax.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				addlista(getProducto());
				reset();
				nombre.requestFocus();
				}
		}
	});
	
	
		
	}
	
}
