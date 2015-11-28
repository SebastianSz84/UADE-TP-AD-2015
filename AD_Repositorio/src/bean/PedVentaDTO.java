package bean;

import java.util.List;

public class PedVentaDTO
{
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
}
