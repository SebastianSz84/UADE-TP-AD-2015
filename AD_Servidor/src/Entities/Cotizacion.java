package Entities;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Dao.CotizacionDAO;
import Dao.OVentaDAO;
import Dao.ProveedorDAO;
import Dao.RodamientoDAO;
import bean.CotizacionDTO;
import bean.ItemCotizacionDTO;
import bean.ItemPreciosDTO;

@Entity
@Table(name = "Cotizaciones")
public class Cotizacion
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String estado;
	
	@OneToOne
	@JoinColumn(name = "idOVenta")
	private OVenta oventa;
	
	@OneToMany
	@JoinColumn(name = "idCotizacion")
	private List<ItemCotizacion> items;
	
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
	
	public List<ItemCotizacion> getItems()
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
	
	public int getId()
	{
		return id;
	}
	
	public OVenta getOventa()
	{
		return oventa;
	}
	
	public void setOventa(OVenta oventa)
	{
		this.oventa = oventa;
	}
	
	public CotizacionDTO getDTO()
	{
		CotizacionDTO cotDTO = new CotizacionDTO();
		cotDTO.setEstado(estado);
		cotDTO.setId(id);
		cotDTO.setIdOVenta(oventa.getId());
		Vector<ItemCotizacionDTO> itemsDTO = new Vector<>();
		for (int i = 0; i < items.size(); i++)
		{
			ItemCotizacionDTO itemDTO = new ItemCotizacionDTO();
			itemDTO.setCantidad(items.get(i).getCantidad());
			itemDTO.setPrecio(items.get(i).getPrecio());
			itemDTO.setRod(items.get(i).getRod().getDTO());
			itemsDTO.add(itemDTO);
		}
		cotDTO.setItems(itemsDTO);
		return cotDTO;
	}
	
	public void actualizarDesdeDTO(CotizacionDTO cotDTO)
	{
		this.estado = cotDTO.getEstado();
		this.oventa = OVentaDAO.getOVenta(cotDTO.getIdOVenta());
		this.items.clear();
		for (int i = 0; i < cotDTO.getItems().size(); i++)
		{
			ItemCotizacion item = new ItemCotizacion();
			item.setCantidad(cotDTO.getItems().elementAt(i).getCantidad());
			item.setPrecio(cotDTO.getItems().elementAt(i).getPrecio());
			item.setProveedor(ProveedorDAO.getProveedor(cotDTO.getItems().elementAt(i).getProveedor().getCodigoProveedor()));
			item.setRod(RodamientoDAO.getRodamiento(cotDTO.getItems().elementAt(i).getRod().getId()));
			items.add(item);
		}
	}
}