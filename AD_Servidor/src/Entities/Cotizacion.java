package Entities;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Dao.CotizacionDAO;
import Dao.RodamientoDAO;
import bean.ItemCotizacionDTO;
import bean.ItemPreciosDTO;

@Entity
@Table(name = "Cotizaciones")
public class Cotizacion
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String estado;
	@OneToMany(mappedBy = "id")
	private Vector<ItemCotizacion> items;
	
	public void agregarItem(ItemCotizacionDTO itCotDTO, ItemPreciosDTO itPrDTO)
	{
		ItemCotizacion itCot = new ItemCotizacion();
		itCot.setCantidad(itCotDTO.getCantidad());
		itCot.setPrecio(itPrDTO.getPrecio());
		itCot.setRod(RodamientoDAO.getRodamiento(itPrDTO.getRodamientoDTO().getId()));
		this.items.add(itCot);
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
