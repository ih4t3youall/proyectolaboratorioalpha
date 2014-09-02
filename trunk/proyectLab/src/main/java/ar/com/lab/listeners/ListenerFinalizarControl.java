package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.VistaControlar;

public class ListenerFinalizarControl implements ActionListener {

	private VistaControlar vistaControlar;
	private ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	
	public ListenerFinalizarControl(VistaControlar vistaControlar){
		
		this.vistaControlar = vistaControlar;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		LinkedList<ProductoControl> listaProductoControl = vistaControlar.getListaProductoControl();
		
		productoBO.guardarProductoControl(listaProductoControl);
		
		JOptionPane.showMessageDialog(null, "Se agregaron "+listaProductoControl.size()+" controles.");
		listaProductoControl.clear();
		
		

	}

}
