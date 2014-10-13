package ar.com.lab.exceptions;

import javax.swing.JOptionPane;

public class CampoInvalidoExeption extends Exception {

	public CampoInvalidoExeption(String string){
		
		JOptionPane.showMessageDialog(null, string);
		
	}
	
	
	
}
