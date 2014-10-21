package ar.com.objetos;

import java.util.Comparator;

import ar.com.lab.objetos.Producto;

public class Comparador implements Comparator<Producto>{
 
    @Override
    public int compare(Producto e1, Producto e2) {
    	
    	int mayor = e1.getNombre().compareTo(e2.getNombre());
    	
    	  if(mayor < 0){
              return -1;
          } else {
              return 1;
          }
    	
    	
        
    }
}