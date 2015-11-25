package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CotizacionDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String estado;
	private List<ItemCotizacionDTO> items;
	private int idOVenta;
	
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
	
	public List<ItemCotizacionDTO> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemCotizacionDTO> items)
	{
		this.items = items;
	}
	
	public int getIdOVenta()
	{
		return idOVenta;
	}
	
	public void setIdOVenta(int idOVenta)
	{
		this.idOVenta = idOVenta;
	}
	
	public boolean tenesItems()
	{
		return !this.items.isEmpty();
	}
	
	public ItemCotizacionDTO dameItem()
	{
		return this.items.remove(0);
	}
	
	public void agregarItem(int cantidad, RodamientoDTO rodDTO, float precio)
	{
		ItemCotizacionDTO itCotDTO = new ItemCotizacionDTO();
		itCotDTO.setCantidad(cantidad);
		itCotDTO.setPrecio(precio);
		itCotDTO.setRod(rodDTO);
		items.add(itCotDTO);
	}
	
	public CotizacionDTO()
	{
		this.items = new ArrayList<ItemCotizacionDTO>();
	}
}