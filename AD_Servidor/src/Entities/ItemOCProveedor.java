package Entities;

public class ItemOCProveedor
{
	private Rodamiento rodamiento;
	private int cantidad;
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public void actualizarCantidad(int cantidad)
	{
		this.cantidad += cantidad;
	}
}