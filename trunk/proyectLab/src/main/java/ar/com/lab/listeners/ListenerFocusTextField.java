package ar.com.lab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.EventListener;

import javax.swing.JTextField;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

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
