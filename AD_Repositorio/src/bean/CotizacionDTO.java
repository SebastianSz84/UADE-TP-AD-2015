package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CotizacionDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String estado;
	private ClienteDTO cliente;
	private Date fecha;
	private List<ItemCotizacionDTO> items;
	
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
	
	public boolean tenesItems()
	{
		return !this.items.isEmpty();
	}
	
	public ItemCotizacionDTO dameItem()
	{
		return this.items.remove(0);
	}
	
	public void agregarItem(int cantidad, RodamientoDTO rodDTO)
	{
		ItemCotizacionDTO itCotDTO = new ItemCotizacionDTO();
		itCotDTO.setCantidad(cantidad);
		itCotDTO.setRod(rodDTO);
		items.add(itCotDTO);
	}
	
	public CotizacionDTO()
	{
		this.items = new ArrayList<ItemCotizacionDTO>();
	}
	
	public ClienteDTO getCliente()
	{
		return cliente;
	}
	
	public void setCliente(ClienteDTO cliente)
	{
		this.cliente = cliente;
	}
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
}