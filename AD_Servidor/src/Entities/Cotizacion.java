package Entities;

import java.util.ArrayList;
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

import Dao.ClienteDAO;
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
		itCot.setItProveedor(ProveedorDAO.getItProveedor(itPrDTO.getId()));
		itCot.setCot(this);
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
		cotDTO.setCliente(ClienteDAO.getCliente(this.cliente.getId()).getDTO());
		cotDTO.setFecha(this.fecha);
		Vector<ItemCotizacionDTO> itemsDTO = new Vector<>();
		for (int i = 0; i < items.size(); i++)
		{
			itemsDTO.add(items.get(i).getDTO());
		}
		cotDTO.setItems(itemsDTO);
		return cotDTO;
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
	
	public Cotizacion()
	{
		this.items = new ArrayList<ItemCotizacion>();
	}
}