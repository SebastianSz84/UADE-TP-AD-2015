package bean;

import java.util.List;

public class PedVentaDTO
{
	private int id;
	private String estado;
	private CotizacionDTO cotizacion;
	private List<ItemPedVentaDTO> items;
	
	public CotizacionDTO getCotizacion()
	{
		return cotizacion;
	}
	
	public void setCotizacion(CotizacionDTO cotizacion)
	{
		this.cotizacion = cotizacion;
	}
	
	public List<ItemPedVentaDTO> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemPedVentaDTO> itemsDTO)
	{
		this.items = itemsDTO;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
}