package Entities;

import java.util.Vector;

import Dao.CotizacionDAO;
import Dao.RodamientoDAO;
import bean.ItemCotizacionDTO;
import bean.ItemPreciosDTO;

public class Cotizacion
{
	private int id;
	private Vector<ItemCotizacion> items;
	private String estado;
	
	public void agregarItem(ItemCotizacionDTO itCotDTO, ItemPreciosDTO itPrDTO)
	{
		ItemCotizacion itCot = new ItemCotizacion();
		itCot.setCantidad(itCotDTO.getCantidad());
		itCot.setPrecio(itPrDTO.getPrecio());
		itCot.setRod(RodamientoDAO.getRodamiento(itPrDTO.getRodamientoDTO().getId()));
	}
	
	public void aceptar()
	{
		this.estado = "Aceptada";
		CotizacionDAO.saveEntity(this);
	}
	
	public float getTotal()
	{
		return 0;
	}
	
	public Vector<ItemCotizacion> getItems()
	{
		return items;
	}
	
	public void setItems(Vector<ItemCotizacion> items)
	{
		this.items = items;
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
