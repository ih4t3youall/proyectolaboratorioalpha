package ar.com.lab.cargando;

import javax.swing.ImageIcon;

public class PantallaCargandoMain {

	  PantallaCargando screen;

	  public PantallaCargandoMain() {
	    inicioPantalla();
		screen.velocidadDeCarga();
	  }

	  private void inicioPantalla() {
		  
//	    ImageIcon myImage = new ImageIcon("src/resources/imagenes/pantallaDeCarga/logoParsecs.jpg");
		  ImageIcon myImage=null;
		  try{
	    myImage = new ImageIcon(this.getClass().getResource("/java/ar/com/lab/imagenes/logoParsecs.jpg"));
		  }catch (Exception e) {
			System.out.println("Error al cargar la imagen");
		}
	    
	    screen = new PantallaCargando(myImage);
	    screen.setLocationRelativeTo(null);
	    screen.setProgresoMax(100);
	    screen.setVisible(true);
	  }

	}