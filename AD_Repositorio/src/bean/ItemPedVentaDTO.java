package bean;

public class ItemPedVentaDTO
{
	private int id;
	private ItemCotizacionDTO itCotizacion;
	private int cantRecibida;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public ItemCotizacionDTO getItCotizacion()
	{
		return itCotizacion;
	}
	
	public void setItCotizacion(ItemCotizacionDTO itCotizacion)
	{
		this.itCotizacion = itCotizacion;
	}
	
	public int getCantRecibida()
	{
		return cantRecibida;
	}
	
	public void setCantRecibida(int cantRecibida)
	{
		this.cantRecibida = cantRecibida;
	}
}