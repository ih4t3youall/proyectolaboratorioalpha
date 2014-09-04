package ar.com.lab.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
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
		
		
		setVisible(true);
		setSize(400,400);
		
	}
	
	
	
	
}
