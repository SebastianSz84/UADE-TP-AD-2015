package bean;

import java.io.Serializable;

public class ItemCotizacionWeb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidad;
	private String codigoSKF;
	private float precio;
	private int idProveedor;

	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCodigoSKF() {
		return codigoSKF;
	}

	public void setCodigoSKF(String codigoSKF) {
		this.codigoSKF = codigoSKF;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}