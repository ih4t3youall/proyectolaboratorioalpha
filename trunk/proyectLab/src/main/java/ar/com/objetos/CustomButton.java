package ar.com.objetos;

import javax.swing.JButton;

public class CustomButton extends JButton{

	
	private String nombreContexto;
	
	
	//es para que todos los cancelar vallan al mismo listener y yo sepa 
	//a que contexto castear
	
	public CustomButton(String nombreContexto){
		
		this.nombreContexto = nombreContexto;
		
	}
	
	
	public String getNombreContexto(){
		
		return nombreContexto;
		
	}
	
	
	
}
