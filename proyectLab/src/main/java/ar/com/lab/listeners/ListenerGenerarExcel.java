package ar.com.lab.listeners;



import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ar.com.lab.bo.ProductoBO;
import ar.com.lab.objetos.ProductoControl;
import ar.com.lab.spring.SpringContext;
import ar.com.lab.vistas.VistaExcel;

import org.apache.poi.ss.usermodel.Row;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ListenerGenerarExcel implements ActionListener {

	private VistaExcel contexto;

	protected ProductoBO productoBO = (ProductoBO) SpringContext.getContext()
			.getBean("productoBO");
	
	public ListenerGenerarExcel(VistaExcel vistaExcel) {
		this.contexto = vistaExcel;

	}

	
	private String[] ENCABEZADO ={"Fecha","Hora","Peso","Medida"}; 
	@Override
	public void actionPerformed(ActionEvent e) {

		
		JFileChooser jfc = new JFileChooser();
		
		jfc.showSaveDialog(null);	
		
		File archivoXLS = jfc.getSelectedFile();
		
		try {
			archivoXLS.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		java.util.List<ProductoControl> productosEnFecha = productoBO.getProductosEnFecha((Date)contexto.getSeleccionarDate().getSelectedItem(),(ProductoControl)contexto.getSeleccionarProducto().getSelectedItem());
		
		
		   
        /*Se crea el libro de excel usando el objeto de tipo Workbook*/
        Workbook libro = new HSSFWorkbook();
        /*Se inicializa el flujo de datos con el archivo xls*/
        FileOutputStream archivo=null;
		try {
			archivo = new FileOutputStream(archivoXLS);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
        Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
        
        Row titulo = hoja.createRow(0);
        Cell celda0 = titulo.createCell(0);
        celda0.setCellValue("Nombre Producto:");
        
        titulo.createCell(1).setCellValue(productosEnFecha.get(0).getProducto().getNombre());
        
        
        
        Row fila = hoja.createRow(1);
        for (int i = 0 ; i< ENCABEZADO.length; i++){
        
        	
            fila.createCell(i).setCellValue(ENCABEZADO[i]);
            
        	
        }
        
        int k = 0;
        for (int i = 2; i < productosEnFecha.size()+2; i++) {
        	fila = hoja.createRow(i);
        	
        	fila.createCell(0).setCellValue(productosEnFecha.get(k).getFecha().toString());
        	fila.createCell(1).setCellValue(productosEnFecha.get(k).getHora());
        	fila.createCell(2).setCellValue(productosEnFecha.get(k).getMedPeso());
        	fila.createCell(3).setCellValue(productosEnFecha.get(k).getMedMedia());
        	k++;
			
		}        
        
//        for(int f=0;f<10;f++){
//            Row fila = hoja.createRow(f);
//            
//            for(int c=0;c<5;c++){
//                Cell celda = fila.createCell(c);
//                
//                if(f==0){
//                    celda.setCellValue("Encabezado #"+c);
//                }else{
//                    celda.setCellValue("Valor celda "+c+","+f);
//                }
//            }
//        }
        
        /*Escribimos en el libro*/
        try {
			libro.write(archivo);
        /*Cerramos el flujo de datos*/
        archivo.close();
        /*Y abrimos el archivo con la clase Desktop*/
//        Desktop.getDesktop().open(archivoXLS);
		
        } catch (IOException e1) {
        	// TODO Auto-generated catch block
        	e1.printStackTrace();
        }
		JOptionPane.showMessageDialog(null, "El documento de excel se ah generado exitosamente.");
		
		
	}

}
