package ar.com.lab.vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ar.com.lab.helpers.SoloNumeros;
import ar.com.lab.objetos.ProductoControl;

public class VistaModificarProductoControl extends JFrame {
	private static final long serialVersionUID = 1L;
	private Vector<JTextField> pesos = new Vector<JTextField>();
	private Vector<JTextField> medidas = new Vector<JTextField>();
	private JButton aceptar, cancelar;
	private LinkedList<ProductoControl> listaProductoControl;

	public VistaModificarProductoControl(VistaControlar vistaControlar,
			LinkedList<ProductoControl> listaProductoControlParam) {
		listaProductoControl = listaProductoControlParam;
		setLayout(new GridLayout(0, 2));

		add(new JLabel("Medida"));
		add(new JLabel("Peso"));

		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		int size = listaProductoControl.size();

		JTextField peso;
		JTextField medida;
		int contador = 0;
		medidas.setSize(size);
		pesos.setSize(size);
		int descuento = 0;

		if (size < 10) {
			descuento = size;
		} else {
			descuento = 10;

		}

		SoloNumeros soloNumeros = new SoloNumeros();
		for (int i = size - descuento; i < size; i++) {

			ProductoControl productoControl = listaProductoControl.get(i);
			medida = new JTextField();
			medida.addKeyListener(soloNumeros);
			medida.setText(String.valueOf(productoControl.getMedMedia()));
			medidas.set(contador, medida);
			peso = new JTextField();
			peso.setText(String.valueOf(productoControl.getMedPeso()));
			peso.addKeyListener(soloNumeros);
			pesos.set(contador, peso);
			add(medida);
			add(peso);

			contador++;
		}

		add(aceptar);
		add(cancelar);

		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int descuento = 0;
				int size = listaProductoControl.size();
				if (size < 10) {
					descuento = size;
				} else {
					descuento = 10;

				}

				int contador = 0;
				for (int i = size - descuento; i < size; i++) {
					ProductoControl productoControl = listaProductoControl
							.get(i);
					productoControl.setMedMedia(Double.parseDouble(medidas.get(
							contador).getText()));
					productoControl.setMedPeso(Double.parseDouble(pesos.get(
							contador).getText()));

					contador++;
				}

				setVisible(false);
				// para controlar que ande
				// for (int i = 0; i < listaProductoControl.size(); i++) {
				//
				// System.out.println(listaProductoControl.get(i).getMedMedia());
				// System.out.println(listaProductoControl.get(i).getMedPeso());
				// }

			}
		});

		setLocation(400, 400);
		setSize(750, 35 * pesos.size() + 35 + 35);
		setVisible(true);

	}

}
