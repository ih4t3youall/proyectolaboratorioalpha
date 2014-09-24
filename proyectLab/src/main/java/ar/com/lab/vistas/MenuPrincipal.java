package ar.com.lab.vistas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ar.com.objetos.BarraMenu;

public class MenuPrincipal extends JFrame {

	
	public MenuPrincipal(){
		

		setJMenuBar(new BarraMenu(this));
		
		
		
		
			
		
	}
	
	public void inicio(){
		
//		JPanel panel = new JPanel();
//		UtilDateModel model = new UtilDateModel();
//		JDatePanelImpl datePanel = new JDatePanelImpl(model);
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
//		panel.add(datePicker);
//		add(panel);
		
		
//		setVisible(true);
		setSize(400,400);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height = screenSize.getHeight();
		double width = screenSize.getWidth();
		height = (height/2)-(400/2);
		width= (width/2) -(400/2);
		setLocation((int) width,(int)height);
		
	}
	
	
	
	
}
