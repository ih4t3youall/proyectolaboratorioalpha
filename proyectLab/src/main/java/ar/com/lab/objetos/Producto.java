package ar.com.lab.objetos;

import java.sql.Date;

public class Producto {
	private int idProducto;
	private String nombre;
	private double pesoMax;
	private double pesoMin;
	private double medMax;
	private double medMin;
	private Date fechaIngreso;
	private boolean doblePeso;


	
	public Producto(){
		
	}
	
	public boolean isDoblePeso() {
		return doblePeso;
	}

	public void setDoblePeso(boolean doblePeso) {
		this.doblePeso = doblePeso;
	}

	public Producto(int idProducto) {

		this.idProducto = idProducto;

	}

	public Producto(String nombre) {

		this.nombre = nombre;
		pesoMax = 0;
		pesoMin = 0;
		medMax = 0;
		medMin = 0;
	}

	public Producto(String nombre, double pesoMax, double pesoMin,
			double medMax, double medMin,boolean doblePeso) {
		super();
		this.nombre = nombre;
		this.pesoMax = pesoMax;
		this.pesoMin = pesoMin;
		this.medMax = medMax;
		this.medMin = medMin;
		this.doblePeso = doblePeso;
	}

	@Override
	public String toString() {

		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public double getPesoMin() {
		return pesoMin;
	}

	public void setPesoMin(double pesoMin) {
		this.pesoMin = pesoMin;
	}

	public double getMedMax() {
		return medMax;
	}

	public void setMedMax(double medMax) {
		this.medMax = medMax;
	}

	public double getMedMin() {
		return medMin;
	}

	public void setMedMin(double medMin) {
		this.medMin = medMin;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

}
