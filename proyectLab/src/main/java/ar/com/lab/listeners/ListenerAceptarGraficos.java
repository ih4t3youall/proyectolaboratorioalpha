package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeriesCollection;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.exceptions.CampoInvalidoExeption;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.GeneradorGraficos;
import ar.com.lab.vistas.MenuPrincipal;
import ar.com.lab.vistas.VistaGraficos;

public class ListenerAceptarGraficos implements ActionListener {

	private VistaGraficos contexto;

	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");

	private MenuPrincipal menuPrincipal = (MenuPrincipal) SpringContext
			.getContext().getBean("menuPrincipal");

	public ListenerAceptarGraficos(VistaGraficos vistaGraficos) {

		contexto = vistaGraficos;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String tipoGrafico = (String) contexto.getSeleccionarGrafico()
				.getSelectedItem();
		try {
			if (tipoGrafico.equals("Lineas")) {

				GeneradorGraficos generadorGraficos = new GeneradorGraficos(
						"Grafico Lineas");
				List<ProductoControl> obtenerControlProductosPorFecha = productoBO
						.obtenerControlProductosPorFecha(
								(Date) contexto.getSeleccionarFechaInicial()
										.getSelectedItem(), (Date) contexto
										.getSeleccionarFechaFinal()
										.getSelectedItem(), contexto
										.getSeleccionarproducto());

				if (obtenerControlProductosPorFecha.size() == 0)
					throw new CampoInvalidoExeption(
							"Este producto no contiene controles en el rango de fechas seleccioando.");

				double medMax = obtenerControlProductosPorFecha.get(0)
						.getProducto().getMedMax();
				double pesoMax = obtenerControlProductosPorFecha.get(0)
						.getProducto().getPesoMax();

				XYSeriesCollection generarDatasetProyectedValues = null;
				JPanel panel = new JPanel();
				if (pesoMax == 0 && medMax != 0) {
					// solo med
					generarDatasetProyectedValues = generadorGraficos
							.generarDatasetProyectedValues(
									obtenerControlProductosPorFecha, 0);
					ChartPanel crearGrafica = generadorGraficos
							.crearGrafica(generarDatasetProyectedValues);
					panel.add(crearGrafica);
					JFrame frame = new JFrame();
					frame.setResizable(true);
					frame.setSize(500, 500);
					frame.add(panel);
					frame.setVisible(true);
					frame.requestFocus();
					frame.requestFocusInWindow();

				} else {
					if (pesoMax != 0 && medMax == 0) {
						// solo peso
						generarDatasetProyectedValues = generadorGraficos
								.generarDatasetProyectedValues(
										obtenerControlProductosPorFecha, 1);
						ChartPanel crearGrafica = generadorGraficos
								.crearGrafica(generarDatasetProyectedValues);
						panel.add(crearGrafica);
						JFrame frame = new JFrame();
						frame.setResizable(true);
						frame.setSize(700, 700);
						frame.add(panel);
						frame.setVisible(true);
						frame.requestFocus();
						frame.requestFocusInWindow();
					} else {
						XYSeriesCollection graf1 = generadorGraficos
								.generarDatasetProyectedValues(
										obtenerControlProductosPorFecha, 1);
						XYSeriesCollection graf2 = generadorGraficos
								.generarDatasetProyectedValues(
										obtenerControlProductosPorFecha, 0);
						ChartPanel crearGrafica = generadorGraficos
								.crearGrafica(graf1);
						ChartPanel crearGrafica1 = generadorGraficos
								.crearGrafica(graf2);
						panel.add(crearGrafica);

						JFrame frame = new JFrame();
						frame.setResizable(true);
						frame.setSize(700, 700);
						frame.add(panel);
						frame.setVisible(true);
						frame.requestFocus();
						frame.requestFocusInWindow();
						JPanel panel2 = new JPanel();
						panel2.add(crearGrafica1);

						JFrame frame2 = new JFrame();
						frame2.setResizable(true);
						frame2.setSize(700, 700);
						frame2.add(panel2);
						frame2.setVisible(true);
						frame2.requestFocus();
						frame2.requestFocusInWindow();

					}

				}

				menuPrincipal.setResizable(true);

			}
		} catch (CampoInvalidoExeption e1) {

			e1.printStackTrace();

		}

	}
}
