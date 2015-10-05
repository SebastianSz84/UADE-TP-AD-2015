package bean;

public class ItemBultoDTO
{
	public int id;
	public int cantidad;
	public RodamientoDTO rodamiento;
	
	public RodamientoDTO getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(RodamientoDTO rodamiento)
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
	
}
