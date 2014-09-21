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
import javax.swing.JPanel;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.listeners.ListenerCancelar;
import ar.com.lab.listeners.ListenerGenerarExcel;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;

public class VistaExcel extends JPanel {

	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");
	protected ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");

	private JComboBox<Date> comboDate;
	private JComboBox<ProductoControl> seleccionarProducto;
	private JButton aceptar, cancelar;

	public VistaExcel() {

		setName("VistaExcel");
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		comboDate = new JComboBox<Date>();
		seleccionarProducto = new JComboBox<ProductoControl>();
		List<Date> diasCargados = productoBO.obtenerDiasCargados();

		for (Date date1 : diasCargados) {

			comboDate.addItem(date1);
		}

		Date date = (Date) comboDate.getSelectedItem();

		List<ProductoControl> obtenerProductosEnFecha = productoBO
				.obtenerProductosEnFecha(date);

		for (ProductoControl productoControl : obtenerProductosEnFecha) {
			seleccionarProducto.addItem(productoControl);
		}

		comboDate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				seleccionarProducto.removeAllItems();
				Date date = (Date) comboDate.getSelectedItem();
				List<ProductoControl> obtenerProductosEnFecha = productoBO
						.obtenerProductosEnFecha(date);

				for (ProductoControl productoControl : obtenerProductosEnFecha) {
					seleccionarProducto.addItem(productoControl);
				}

			}
		});

		setLayout(new FlowLayout());

		aceptar.addActionListener(new ListenerGenerarExcel(this));
		cancelar.addActionListener(new ListenerCancelar(this));

		add(comboDate);
		add(seleccionarProducto);
		add(aceptar);
		add(cancelar);

		menuPrincipal.add(this);
		menuPrincipal.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		menuPrincipal.setSize(537, 125);
		menuPrincipal.repaint();
		menuPrincipal.revalidate();

	}

	public JComboBox<ProductoControl> getSeleccionarProducto() {

		return seleccionarProducto;

	}

	public JComboBox<Date> getSeleccionarDate() {

		return comboDate;

	}

}
