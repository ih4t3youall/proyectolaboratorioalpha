package ar.com.objetos;

import java.text.DecimalFormat;

public class ResultadoCarga {
	private String nombreProducto = "";
	private double pesoMaximoEstablecido = 0;
	private double pesoMinimoEstablecido = 0;
	private double medidaMaximoEstablecido = 0;
	private double medidaMinimoEstablecido = 0;
	private double pesoMaximo = 0;
	private double pesoMinimo = 9999999;
	private double medidaMaxima = 0;
	private double medidaMinima = 9999999;
	private double diferencia = 0;
	private int errorPeso = 0;
	private int errorMedida = 0;
	private int cantidadDeMuestras = 0;
	private boolean doblePeso;

	public String getNombreProducto() {
		return nombreProducto;
	}

	public boolean isDoblePeso() {
		return doblePeso;
	}

	public void setDoblePeso(boolean doblePeso) {
		this.doblePeso = doblePeso;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPesoMaximoEstablecido() {
		return pesoMaximoEstablecido;
	}

	public void setPesoMaximoEstablecido(double pesoMaximoEstablecido) {
		this.pesoMaximoEstablecido = pesoMaximoEstablecido;
	}

	public double getPesoMinimoEstablecido() {
		return pesoMinimoEstablecido;
	}

	public void setPesoMinimoEstablecido(double pesoMinimoEstablecido) {
		this.pesoMinimoEstablecido = pesoMinimoEstablecido;
	}

	public double getMedidaMaximoEstablecido() {
		return medidaMaximoEstablecido;
	}

	public void setMedidaMaximoEstablecido(double medidaMaximoEstablecido) {
		this.medidaMaximoEstablecido = medidaMaximoEstablecido;
	}

	public double getMedidaMinimoEstablecido() {
		return medidaMinimoEstablecido;
	}

	public void setMedidaMinimoEstablecido(double medidaMinimoEstablecido) {
		this.medidaMinimoEstablecido = medidaMinimoEstablecido;
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

	public int getErrorPeso() {
		return errorPeso;
	}

	public void setErrorPeso(int errorPeso) {
		this.errorPeso = errorPeso;
	}

	public int getErrorMedida() {
		return errorMedida;
	}

	public void setErrorMedida(int errorMedida) {
		this.errorMedida = errorMedida;
	}

	public String getText() {
		String respuesta = "";
		if(!doblePeso){
		respuesta += "Nombre Producto: " + nombreProducto + "\n";

		if (pesoMaximoEstablecido != 0) {
			respuesta += "El peso maximo establecido: " + pesoMaximoEstablecido
					+ "\n";
			respuesta += "El peso Minimo establecido: " + pesoMinimoEstablecido
					+ "\n";
			respuesta += "La diferencia entre el peso maximo y el minimo es de "
					+ String.valueOf(pesoMaximo - pesoMinimo) + "\n";
		}

		if (medidaMinimoEstablecido != 0) {
			respuesta += "La medida maxima establecida: "
					+ medidaMaximoEstablecido + "\n";
			respuesta += "La medida Minima establecida: "
					+ medidaMinimoEstablecido + "\n";
			respuesta += "La diferencia entre la medida maxima y el minima es de "
					+ String.valueOf(medidaMaxima - medidaMinima) + "\n";
		}

		respuesta += "Las muestas son :" + cantidadDeMuestras + " \n";

		if (pesoMaximo > 0) {
			respuesta += "El peso maximo registrado fue de " + pesoMaximo
					+ ", y el peso minimo " + pesoMinimo + "\n";

		}

		if (medidaMaxima > 0) {
			respuesta += "La media maxima registrada fue de " + medidaMaxima
					+ ", y la medida minima fue de " + medidaMinima + "\n";

		}

		double errorAuxPeso = errorPeso * 100;
		double errorAuxMedida = errorMedida * 100;

		Double tazaErrorPeso = errorAuxPeso / cantidadDeMuestras;
		Double tazaErrorMedida = errorAuxMedida / cantidadDeMuestras;

		DecimalFormat df = new DecimalFormat("0.00");
		String formatErrorMedida = df.format(tazaErrorMedida);
		String formatErrorPeso = df.format(tazaErrorPeso);

		respuesta += "La taza de error de los pesos fue de un "
				+ formatErrorPeso + "% \n";
		respuesta += "La taza de error de las medidas fue de un "
				+ formatErrorMedida + "% \n";
		}else {
			
			respuesta += "Nombre Producto: " + nombreProducto + "\n";

			if (pesoMaximoEstablecido != 0) {
				respuesta += "El peso maximo establecido para el Producto A: " + pesoMaximoEstablecido
						+ "\n";
				respuesta += "El peso Minimo establecido para el Producto A: " + pesoMinimoEstablecido
						+ "\n";
				respuesta += "La diferencia entre el peso maximo y el minimo del producto A "
						+ String.valueOf(pesoMaximo - pesoMinimo) + "\n\n\n";
			}

			if (medidaMinimoEstablecido != 0) {
				respuesta += "El peso maximo establecido para el Producto B "
						+ medidaMaximoEstablecido + "\n";
				respuesta += "El peso minimo establecido para el Producto B: "
						+ medidaMinimoEstablecido + "\n";
				respuesta += "La diferencia entre la medida maxima y el minima del Producto B"
						+ String.valueOf(medidaMaxima - medidaMinima) + "\n\n\n";
			}

			respuesta += "Las muestas son :" + cantidadDeMuestras + " \n";

			if (pesoMaximo > 0) {
				respuesta += "El peso maximo para el producto A fue de " + pesoMaximo
						+ ", y el minimo " + pesoMinimo + "\n";

			}

			if (medidaMaxima > 0) {
				respuesta += "El peso maximo para el producto B fue de " + medidaMaxima
						+ ", y el minimo " + medidaMinima + "\n";

			}

			double errorAuxPeso = errorPeso * 100;
			double errorAuxMedida = errorMedida * 100;

			Double tazaErrorPeso = errorAuxPeso / cantidadDeMuestras;
			Double tazaErrorMedida = errorAuxMedida / cantidadDeMuestras;

			DecimalFormat df = new DecimalFormat("0.00");
			String formatErrorMedida = df.format(tazaErrorMedida);
			String formatErrorPeso = df.format(tazaErrorPeso);

			respuesta += "La taza de error del Producto A "
					+ formatErrorPeso + "% \n";
			respuesta += "La taza de error del Producto B "
					+ formatErrorMedida + "% \n";
			
			
		}
		return respuesta;

	}

}
