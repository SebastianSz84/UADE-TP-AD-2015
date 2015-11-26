package Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Stock
{
	@Column
	private int cantidad;
	
	@Column
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
}