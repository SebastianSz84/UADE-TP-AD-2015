package Entities;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Dao.CotizacionDAO;
import Dao.ProveedorDAO;
import Dao.RodamientoDAO;
import bean.CotizacionDTO;
import bean.ItemCotizacionDTO;
import bean.ItemProveedorDTO;

@Entity
@Table(name = "Cotizacion")
public class Cotizacion
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String estado;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCotizacion")
	private List<ItemCotizacion> items;
	
	@Column
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", referencedColumnName = "id")
	private Cliente cliente;
	
	public void agregarItem(ItemCotizacionDTO itCotDTO, ItemProveedorDTO itPrDTO)
	{
		ItemCotizacion itCot = new ItemCotizacion();
		itCot.setCantidad(itCotDTO.getCantidad());
		itCot.setRod(RodamientoDAO.getRodamiento(itPrDTO.getSKF()));
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
	
	public void setItems(List<ItemCotizacion> items)
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
	
	public CotizacionDTO getDTO()
	{
		CotizacionDTO cotDTO = new CotizacionDTO();
		cotDTO.setEstado(estado);
		cotDTO.setId(id);
		Vector<ItemCotizacionDTO> itemsDTO = new Vector<>();
		for (int i = 0; i < items.size(); i++)
		{
			ItemCotizacionDTO itemDTO = new ItemCotizacionDTO();
			itemDTO.setCantidad(items.get(i).getCantidad());
			itemDTO.setRod(items.get(i).getRod().getDTO());
			itemsDTO.add(itemDTO);
		}
		cotDTO.setItems(itemsDTO);
		return cotDTO;
	}
	
	public void actualizarDesdeDTO(CotizacionDTO cotDTO)
	{
		this.estado = cotDTO.getEstado();
		this.items.clear();
		for (ItemCotizacionDTO itCotDTO : cotDTO.getItems())
		{
			ItemCotizacion item = new ItemCotizacion();
			item.setCantidad(itCotDTO.getCantidad());
			item.setProveedor(ProveedorDAO.getProveedor(itCotDTO.getProveedor().getCodigoProveedor()));
			item.setRod(RodamientoDAO.getRodamiento(itCotDTO.getRod().getCodigoSKF()));
			items.add(item);
		}
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}