package Entities;

import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import bean.ItemPedVentaDTO;
import bean.PedVentaDTO;

@Entity
@Table(name = "PedidosVentas")
public class PedVenta
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public OVenta getOficinaDeVenta()
	{
		return OficinaDeVenta;
	}
	
	public void setOficinaDeVenta(OVenta oficinaDeVenta)
	{
		OficinaDeVenta = oficinaDeVenta;
	}
	
	@ManyToOne
	@JoinColumn(name = "idOVenta")
	private OVenta OficinaDeVenta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Cotizacion cotizacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPedidoVenta")
	private List<ItemPedVenta> items;
	
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
	
	public List<ItemPedVenta> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemPedVenta> items)
	{
		this.items = items;
	}
	
	public void generarItemsDesdeCotizacion()
	{
		for (int i = 0; i < cotizacion.getItems().size(); i++)
		{
			ItemPedVenta itPedVta = new ItemPedVenta();
			itPedVta.setCantidad(cotizacion.getItems().get(i).getCantidad());
			itPedVta.setRodamiento(cotizacion.getItems().get(i).getRod());
			itPedVta.setProveedor(cotizacion.getItems().get(i).getProveedor());
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
			itemsDTO.add(items.get(i).getDTO());
		}
		pedVtaDTO.setItems(itemsDTO);
		return pedVtaDTO;
	}
	
}