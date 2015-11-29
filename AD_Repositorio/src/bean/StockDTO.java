package bean;

import java.io.Serializable;

public class StockDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidad;
	private float precio;
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
}