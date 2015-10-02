package Entities;

import java.util.Vector;

import bean.ItemPedVentaDTO;
import bean.PedVentaDTO;

public class PedVenta
{
	private Cotizacion cotizacion;
	private Vector<ItemPedVenta> items;
	
	public float getTotal()
	{
		return 0;
	}
	
	public Cotizacion getCotizacion()
	{
		return cotizacion;
	}
	
	public void setCotizacion(Cotizacion cotizacion)
	{
		this.cotizacion = cotizacion;
	}
	
	public Vector<ItemPedVenta> getItems()
	{
		return items;
	}
	
	public void setItems(Vector<ItemPedVenta> items)
	{
		this.items = items;
	}
	
	public void generarItemsDesdeCotizacion()
	{
		for (int i = 0; i < cotizacion.getItems().size(); i++)
		{
			ItemPedVenta itPedVta = new ItemPedVenta();
			itPedVta.setCantidad(cotizacion.getItems().elementAt(i).getCantidad());
			itPedVta.setPrecio(cotizacion.getItems().elementAt(i).getPrecio());
			itPedVta.setRodamiento(cotizacion.getItems().elementAt(i).getRod());
			itPedVta.setProveedor(cotizacion.getItems().elementAt(i).getProveedor());
			items.add(itPedVta);
		}
	}
	
	public PedVentaDTO getDTO()
	{
		PedVentaDTO pedVtaDTO = new PedVentaDTO();
		pedVtaDTO.setCotizacion(cotizacion.getDTO());
		Vector<ItemPedVentaDTO> itemsDTO = new Vector<>();
		for (int i = 0; i < items.size(); i++)
		{
			itemsDTO.add(items.elementAt(i).getDTO());
		}
		pedVtaDTO.setItems(itemsDTO);
		return pedVtaDTO;
	}
	
}