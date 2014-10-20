package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.objetos.Producto;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.VistaControlar;
import ar.com.lab.vistas.VistaResultadoCarga;
import ar.com.objetos.ResultadoCarga;

public class ListenerFinalizarControl implements ActionListener {

	private VistaControlar vistaControlar;
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");

	public ListenerFinalizarControl(VistaControlar vistaControlar) {

		this.vistaControlar = vistaControlar;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		LinkedList<ProductoControl> listaProductoControl = vistaControlar
				.getListaProductoControl();

		productoBO.guardarProductoControl(listaProductoControl);

		double pesoMaximo = 0;
		double pesoMinimo = 9999999;
		double medidaMaxima = 0;
		double medidaMinima = 9999999;
		double diferencia = 0;
		int errorMedida = 0;
		int errorPeso = 0;
		ResultadoCarga resultado = new ResultadoCarga();

		for (ProductoControl productoControl : listaProductoControl) {

			Producto producto = productoControl.getProducto();

			if (productoControl.getMedMedia() < medidaMinima) {
				medidaMinima = productoControl.getMedMedia();

			}

			if (productoControl.getMedMedia() > medidaMaxima) {
				medidaMaxima = productoControl.getMedMedia();

			}

			if (productoControl.getMedPeso() < pesoMinimo) {
				pesoMinimo = productoControl.getMedPeso();
			}
			if (productoControl.getMedPeso() > pesoMaximo) {
				pesoMaximo = productoControl.getMedPeso();

			}

			if (producto.getMedMax() < productoControl.getMedMedia()
					|| producto.getMedMin() > productoControl.getMedMedia()) {
				errorMedida++;
			}

			if (producto.getPesoMax() < productoControl.getMedPeso()
					|| producto.getPesoMin() > productoControl.getMedPeso()) {
				errorPeso++;
			}

		}

		resultado.setErrorPeso(errorPeso);
		resultado.setErrorMedida(errorMedida);
		resultado.setDiferencia(diferencia);
		resultado.setMedidaMaxima(medidaMaxima);
		resultado.setMedidaMinima(medidaMinima);
		resultado.setPesoMaximo(pesoMaximo);
		resultado.setPesoMinimo(pesoMinimo);
		resultado.setCantidadDeMuestras(listaProductoControl.size());
		Producto producto = listaProductoControl.get(0).getProducto();
		resultado.setNombreProducto(producto.getNombre());
		double pesoMax = producto.getPesoMax();
		if (pesoMax != 0) {
			resultado.setPesoMaximoEstablecido(pesoMax);
			resultado.setPesoMinimoEstablecido(producto.getPesoMin());
		}

		double medMax = producto.getMedMax();

		if (medMax != 0) {
			resultado.setMedidaMaximoEstablecido(medMax);
			resultado.setMedidaMinimoEstablecido(producto.getMedMin());

		}

		new VistaResultadoCarga(resultado);

		JOptionPane.showMessageDialog(null, "Se agregaron "
				+ listaProductoControl.size() + " controles.");

		listaProductoControl.clear();

	}

}
