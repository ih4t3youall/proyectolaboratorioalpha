package ar.com.objetos;

public class ResultadoCarga {

	double pesoMaximo = 0;
	double pesoMinimo = 9999999;
	double medidaMaxima = 0;
	double medidaMinima = 9999999;
	double diferencia = 0;
	double error = 0;
	int cantidadDeMuestras = 0;

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
		
		respuesta += "Las muestas son :"+cantidadDeMuestras +" \n";
		
		if (pesoMaximo > 0) {
			respuesta += "El peso maximo registrado fue de " + pesoMaximo
					+ ", y el peso minimo " + pesoMinimo+"\n";

		}

		if (medidaMaxima > 0) {
			respuesta += "La media maxima registrada fue de " + medidaMaxima
					+ ", y la medida minima fue de " + medidaMinima +"\n";

		}
		
		double tazaError =(error*100)/cantidadDeMuestras;
		
		respuesta +="La taza de error fue de un "+tazaError+"%";
		
		
		return respuesta;

	}

}
