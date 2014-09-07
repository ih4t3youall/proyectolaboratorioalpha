package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ar.com.lab.objetos.Producto;
import ar.com.lab.vistas.VistaAgregar;

public class ListenerAceptarProductoNuevo implements ActionListener {

	
	private VistaAgregar vistaAgregar;
	public ListenerAceptarProductoNuevo(VistaAgregar vistaAgregar) {
		this.vistaAgregar = vistaAgregar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Producto producto = vistaAgregar.getProducto();
		
		
		if (producto.getMedMax() > producto.getMedMin() || producto.getPesoMax() > producto.getPesoMin() ){
			
			vistaAgregar.addlista(producto);
			
			
		}else {
			String nl = System.getProperty("line.separator");
			JOptionPane.showMessageDialog(null, "El peso o la medida no son coherentes."+nl+"El primer casillero representa el minimo"+nl
					+ "y el segundo casillero representa el maximo ,"+nl+" el maximo no puede ser menor que el minimo en ambos casos.");
			
		}
		vistaAgregar.reset();
		
		
		
	}

	
	
}
