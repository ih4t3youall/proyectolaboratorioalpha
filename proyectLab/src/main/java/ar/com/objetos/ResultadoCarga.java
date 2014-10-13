package ar.com.objetos;

import java.text.DecimalFormat;

public class ResultadoCarga {
	String nombreProducto = "";
	double maximoEstablecido = 0;
	double minimoEstablecido = 0;
	double pesoMaximo = 0;
	double pesoMinimo = 9999999;
	double medidaMaxima = 0;
	double medidaMinima = 9999999;
	double diferencia = 0;
	double error = 0;
	int cantidadDeMuestras = 0;

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getMaximoEstablecido() {
		return maximoEstablecido;
	}

	public void setMaximoEstablecido(double maximoEstablecido) {
		this.maximoEstablecido = maximoEstablecido;
	}

	public double getMinimoEstablecido() {
		return minimoEstablecido;
	}

	public void setMinimoEstablecido(double minimoEstablecido) {
		this.minimoEstablecido = minimoEstablecido;
	}

	public int getCantidadDeMuestras() {
		return cantidadDeMuestras;
	}

	public void setCantidadDeMuestras(int cantidadDeMuestras) {
		this.cantidadDeMuestras = cantidadDeMuestras;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public double getPesoMinimo() {
		return pesoMinimo;
	}

	public void setPesoMinimo(double pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}

	public double getMedidaMaxima() {
		return medidaMaxima;
	}

	public void setMedidaMaxima(double medidaMaxima) {
		this.medidaMaxima = medidaMaxima;
	}

	public double getMedidaMinima() {
		return medidaMinima;
	}

	public void setMedidaMinima(double medidaMinima) {
		this.medidaMinima = medidaMinima;
	}

	public double getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(double diferencia) {
		this.diferencia = diferencia;
	}

	public double getError() {
		return error;
	}

	public void setError(double error) {
		this.error = error;
	}

	public String getText() {

		String respuesta = "";
		respuesta +="Nombre Producto: "+nombreProducto+"\n";
		respuesta +="Maximo establecido: "+maximoEstablecido+"\n";
		respuesta +="Minimo establecido: "+minimoEstablecido+"\n";
		
		 respuesta += "Las muestas son :" + cantidadDeMuestras
				+ " \n";

		if (pesoMaximo > 0) {
			respuesta += "El peso maximo registrado fue de " + pesoMaximo
					+ ", y el peso minimo " + pesoMinimo + "\n";

		}

		if (medidaMaxima > 0) {
			respuesta += "La media maxima registrada fue de " + medidaMaxima
					+ ", y la medida minima fue de " + medidaMinima + "\n";

		}
		Double tazaError =(error * 100) / cantidadDeMuestras;
		

		DecimalFormat df = new DecimalFormat("0.00"); 
		String format = df.format(tazaError);
		

		
		
		respuesta += "La taza de error fue de un " + format + "%";

		return respuesta;

	}

}
