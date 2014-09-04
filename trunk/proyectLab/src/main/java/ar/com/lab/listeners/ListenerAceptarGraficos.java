package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;

import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ar.com.lab.bo.ProductoBO;
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
		
		
		String tipoGrafico = (String)contexto.getSeleccionarGrafico().getSelectedItem();
		
		
		if(tipoGrafico.equals("Lineas")){
			
			GeneradorGraficos generadorGraficos = new GeneradorGraficos("Grafico Lineas");
			List<ProductoControl> obtenerControlProductosPorFecha = productoBO.obtenerControlProductosPorFecha((Date)contexto.getSeleccionarFecha().getSelectedItem());
			
			
			 XYSeriesCollection generarDatasetProyectedValues = generadorGraficos.generarDatasetProyectedValues(obtenerControlProductosPorFecha);
			ChartPanel grafica = generadorGraficos.crearGrafica(generarDatasetProyectedValues);
			menuPrincipal.setResizable(true);
			
			contexto.removeAll();
			contexto.add(grafica);
			contexto.repaint();
			contexto.revalidate();
			JButton volver =  new JButton("volver");
			volver.addActionListener(new ListenerCancelar(contexto));
			contexto.add(volver);
		}
		
		

	}

}
