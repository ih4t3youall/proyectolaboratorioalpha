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
		DecimalFormat df = new DecimalFormat("0.00");
		if (!doblePeso) {
			respuesta += "Nombre Producto: " + nombreProducto + "\n\n";

			if (pesoMaximoEstablecido != 0) {
				respuesta += "El peso maximo establecido: "
						+ pesoMaximoEstablecido + "\n\n";
				respuesta += "Peso minimo establecido: "
						+ pesoMinimoEstablecido + "\n\n";

				respuesta += "Diferencia peso: "
						+ df.format(pesoMaximo - pesoMinimo) + "\n\n";
			}

			if (medidaMinimoEstablecido != 0) {
				respuesta += "Medida minima establecida: "
						+ medidaMinimoEstablecido + "\n\n";
				respuesta += "La medida maxima establecida: "
						+ medidaMaximoEstablecido + "\n\n";
				respuesta += "Diferencia entre la medida maxima y el minima es de "
						+ df.format(medidaMaxima - medidaMinima) + "\n\n";
			}

			respuesta += "Muestras registradas:" + cantidadDeMuestras + " \n\n";

			if (pesoMaximo > 0) {

				respuesta += "Peso minimo registrado:" + pesoMinimo + "\n\n";
				respuesta += "Peso maximo registrado:" + pesoMaximo + "\n\n";

			}

			if (medidaMaxima > 0) {
				respuesta += "Medida minima registrada:" + medidaMinima + "\n\n";
				respuesta += "Medida maxima registrada:" + medidaMaxima + "\n\n";

			}

			double errorAuxPeso = errorPeso * 100;
			double errorAuxMedida = errorMedida * 100;

			Double TasaErrorPeso = errorAuxPeso / cantidadDeMuestras;
			Double TasaErrorMedida = errorAuxMedida / cantidadDeMuestras;

			String formatErrorMedida = df.format(TasaErrorMedida);
			String formatErrorPeso = df.format(TasaErrorPeso);

			
			if(pesoMaximo > 0){
			respuesta += "Tasa de error de los pesos fue de un "
					+ formatErrorPeso + "% \n\n";
			}
			
			if (medidaMaxima > 0){
			respuesta += "Tasa de error de las medidas fue de un "
					+ formatErrorMedida + "% \n\n";
			}
		} else {

			respuesta += "Nombre Producto: " + nombreProducto + "\n\n";

			if (pesoMaximoEstablecido != 0) {
				respuesta += "Peso maximo establecido Producto A: "
						+ pesoMaximoEstablecido + "\n\n";
				respuesta += "Peso mínimo establecido Producto A: "
						+ pesoMinimoEstablecido + "\n\n";
				respuesta += "La diferencia entre el peso maximo y el minimo del producto A "
						+ df.format(pesoMaximo - pesoMinimo) + "\n\n";
			}

			if (medidaMinimoEstablecido != 0) {
				respuesta += "Peso maximo establecido Producto B "
						+ medidaMaximoEstablecido + "\n\n";
				respuesta += "Peso mínimo establecido Producto B: "
						+ medidaMinimoEstablecido + "\n\n";
				respuesta += "La diferencia entre la medida maxima y el minima del Producto B"
						+ df.format(medidaMaxima - medidaMinima) + "\n\n";
			}

			respuesta += "Muestras Registradas:" + cantidadDeMuestras + " \n\n";

			if (pesoMaximo > 0) {
				respuesta += "Peso mínimo Producto A " + df.format(pesoMinimo) + "\n\n";
				respuesta += "Peso maximo Producto A " + df.format(pesoMaximo) + "\n\n";

			}

			if (medidaMaxima > 0) {

				respuesta += "Peso mínimo Producto B " + df.format(medidaMinima) + "\n\n";
				respuesta += "Peso maximo Producto B " + df.format(medidaMaxima) + "\n\n";
			}

			respuesta += "Diferencia producto A: "
					+ df.format(pesoMaximo - pesoMinimo)+"\n\n";
			respuesta += "Diferencia producto B: " + df.format(medidaMaxima - medidaMinima)+"\n\n";

			double errorAuxPeso = errorPeso * 100;
			double errorAuxMedida = errorMedida * 100;

			Double TasaErrorPeso = errorAuxPeso / cantidadDeMuestras;
			Double TasaErrorMedida = errorAuxMedida / cantidadDeMuestras;

			
			String formatErrorMedida = df.format(TasaErrorMedida);
			String formatErrorPeso = df.format(TasaErrorPeso);

			respuesta += "Tasa de error del Producto A " + formatErrorPeso
					+ "% \n\n";
			respuesta += "Tasa de error del Producto B " + formatErrorMedida
					+ "% \n\n";

		}
		return respuesta;

	}
}
