package ar.com.lab.vistas;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;

public class GeneradorGraficos extends JPanel {

	private String chartTitle;

	private static Color COLOR_SERIE_1 = new Color(255, 128, 64);

	private static Color COLOR_SERIE_2 = new Color(28, 84, 140);

	private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);

	private static Color COLOR_FONDO_GRAFICA = Color.white;

	public GeneradorGraficos(String chartTitle) {

		this.chartTitle = chartTitle;

	}

	// barras

	public ChartPanel crearGrafica(XYSeriesCollection dataset) {

		final JFreeChart chart = ChartFactory.createXYLineChart(
				"Tiempos de entrenamientos", "Vuelta", "Tiempo (segundos)",
				dataset, PlotOrientation.VERTICAL, true, // uso de leyenda
				false, // uso de tooltips
				false // uso de urls
				);
		// color de fondo de la gráfica
		chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);

		final XYPlot plot = (XYPlot) chart.getPlot();
		configurarPlot(plot);

		final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		configurarDomainAxis(domainAxis);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		configurarRangeAxis(rangeAxis);

		final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		configurarRendered(renderer);

		// we put the chart into a panel
		ChartPanel chartPanel = new ChartPanel(chart);
		// default size
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

		return chartPanel;
	}

	// configuramos el contenido del gráfico (damos un color a las líneas que
	// sirven de guía)
	private void configurarPlot(XYPlot plot) {
		plot.setDomainGridlinePaint(COLOR_RECUADROS_GRAFICA);
		plot.setRangeGridlinePaint(COLOR_RECUADROS_GRAFICA);
	}

	// configuramos el eje X de la gráfica (se muestran números enteros y de uno
	// en uno)
	private void configurarDomainAxis(NumberAxis domainAxis) {
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis.setTickUnit(new NumberTickUnit(1));
	}

	// configuramos el eje y de la gráfica (números enteros de dos en dos y
	// rango entre 120 y 135)
	private void configurarRangeAxis(NumberAxis rangeAxis) {
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setTickUnit(new NumberTickUnit(2));
		rangeAxis.setRange(120, 135);
	}

	// configuramos las líneas de las series (añadimos un círculo en los puntos
	// y asignamos el color de cada serie)
	private void configurarRendered(XYLineAndShapeRenderer renderer) {
		renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesShapesVisible(1, true);
		renderer.setSeriesPaint(0, COLOR_SERIE_1);
		renderer.setSeriesPaint(1, COLOR_SERIE_2);
	}

	// barras

	// DefaultPieDataset pieDataset = new DefaultPieDataset();
	// pieDataset.setValue("Linux", 29);
	// pieDataset.setValue("Mac", 20);
	// pieDataset.setValue("Windows", 51);

	public void generarPieDataSet(LinkedList<ProductoControl> productosControl) {

		// DefaultPieDataset pieDataset = new DefaultPieDataset();
		// int contador = 0;
		// for (ProductoControl productosControl : productosControl) {
		// contador++;
		// pieDataset.setValue(contador,productosControl.getp);
		//
		//
		// }

	}

	public XYSeries[] generarDatasetProyectedValues(
			LinkedList<ProductoControl> productosControl) {
		int contador = 0;
		XYSeries seriePeso = new XYSeries("Peso");
		XYSeries serieMedida = new XYSeries("Medida");
		for (ProductoControl productoControl : productosControl) {
			contador++;
			seriePeso.add(contador, productoControl.getMedPeso());
			serieMedida.add(contador, productoControl.getMedMedia());
			final XYSeriesCollection collection = new XYSeriesCollection();
			collection.addSeries(seriePeso);
			collection.addSeries(serieMedida);
		}
		XYSeries[] series ={seriePeso,serieMedida};
		return series;
		
		
	}

	public ChartPanel devolverTorta(DefaultPieDataset pieDataset) {
		// This will create the dataset

		PieDataset dataset = pieDataset;
		// based on the dataset we create the chart
		JFreeChart chart = ChartFactory.createPieChart3D(chartTitle, // chart
																		// title
				dataset, // data
				true, // include legend
				true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		// we put the chart into a panel
		ChartPanel chartPanel = new ChartPanel(chart);
		// default size
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		// add it to our application
		return chartPanel;

	}

}