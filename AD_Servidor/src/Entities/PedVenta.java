package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Dao.PedVentaDAO;
import bean.ItemPedVentaDTO;
import bean.PedVentaDTO;

@Entity
@Table(name = "PedidoVenta")
public class PedVenta
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idOVenta", referencedColumnName = "id")
	private OVenta oVenta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCotizacion")
	private Cotizacion cotizacion;
	
	private String estado;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPedidoVenta")
	private List<ItemPedVenta> items;
	
	public float getTotal()
	{
		return 0;
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
		if (cotizacion != null)
		{
			for (ItemCotizacion itCot : this.cotizacion.getItems())
			{
				ItemPedVenta itPedVta = new ItemPedVenta();
				itPedVta.setItCotizacion(itCot);
				itPedVta.setPedVenta(this);
				if (itCot.getRod().getStock().getCantidad() != 0)
				{
					if (itCot.getRod().getStock().getCantidad() >= itCot.getCantidad())
					{
						itCot.getRod().getStock().setCantidad(itCot.getRod().getStock().getCantidad() - itCot.getCantidad());
						itPedVta.setCantRecibida(itCot.getCantidad());
					}
					else
					{
						itPedVta.setCantRecibida(itCot.getRod().getStock().getCantidad());
						itCot.getRod().getStock().setCantidad(0);
					}
				}
				items.add(itPedVta);
			}
		}
	}
	
	public PedVentaDTO getDTO()
	{
		PedVentaDTO pedVtaDTO = new PedVentaDTO();
		pedVtaDTO.setCotizacion(cotizacion.getDTO());
		List<ItemPedVentaDTO> itemsDTO = new ArrayList<>();
		for (int i = 0; i < items.size(); i++)
		{
			itemsDTO.add(items.get(i).getDTO());
		}
		pedVtaDTO.setItems(itemsDTO);
		return pedVtaDTO;
	}
	
	public Cotizacion getCotizacion()
	{
		return cotizacion;
	}
	
	public void setCotizacion(Cotizacion cotizacion)
	{
		this.cotizacion = cotizacion;
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
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public boolean estaCompleto()
	{
		for (ItemPedVenta item : items)
		{
			if (!item.estaCompleto())
				return false;
		}
		
		if (estado.equals("Pendiente"))
		{
			setEstado("Cerrado");
			PedVentaDAO.savePedVenta(this);
		}
		
		return true;
	}
	
	public PedVenta()
	{
		this.items = new ArrayList<>();
	}
	
	public OVenta getoVenta()
	{
		return oVenta;
	}
	
	public void setoVenta(OVenta oVenta)
	{
		this.oVenta = oVenta;
	}
}