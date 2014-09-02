package ar.com.lab.helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import sun.awt.AWTAccessor.KeyEventAccessor;

public class SoloNumeros implements KeyListener {

	
	
	public SoloNumeros(){

	}

	@Override
	public void keyTyped(KeyEvent e) {


		int k = (int) e.getKeyChar();
		if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

		e.consume();
		JOptionPane.showMessageDialog(null, "No puede ingresar Letras!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
		} 	
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
}
