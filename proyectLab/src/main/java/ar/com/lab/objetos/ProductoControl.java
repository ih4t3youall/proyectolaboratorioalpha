package ar.com.lab.objetos;

import java.sql.Timestamp;

public class ProductoControl {

	private int idProductoControl;
	private Producto producto;
	private double medMedia;
	private double medPeso;
	private boolean error;
	private Timestamp fecha;

	public ProductoControl() {

	}

	public ProductoControl(Producto producto, double medMedia, double medPeso,
			boolean error) {
		super();
		this.producto = producto;
		this.medMedia = medMedia;
		this.medPeso = medPeso;
		this.error = error;
	}

	public int getIdProductoControl() {
		return idProductoControl;
	}

	public void setIdProductoControl(int idProductoControl) {
		this.idProductoControl = idProductoControl;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getMedMedia() {
		return medMedia;
	}

	public void setMedMedia(double medMedia) {
		this.medMedia = medMedia;
	}

	public double getMedPeso() {
		return medPeso;
	}

	public void setMedPeso(double medPeso) {
		this.medPeso = medPeso;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp date) {
		this.fecha = date;
	}

}
