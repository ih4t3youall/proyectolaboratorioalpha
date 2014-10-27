package ar.com.lab.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class ListenerFocusTextField  implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		JTextField source = (JTextField)e.getSource();
		if(source.getText().equals("") || source.getText().equals("0"))
		source.setText("");
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField source = (JTextField)e.getSource();
		if(source.getText().equals("")){
			source.setText("0");
			
		}
		
		
	}




	
	
	
	
	
}
