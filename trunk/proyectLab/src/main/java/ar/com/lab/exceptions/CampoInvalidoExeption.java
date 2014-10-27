package ar.com.lab.exceptions;

import javax.swing.JOptionPane;

public class CampoInvalidoExeption extends Exception {
	private static final long serialVersionUID = 1L;
	public CampoInvalidoExeption(String string){
		
		JOptionPane.showMessageDialog(null, string);
		
	}
	
	
	
}
