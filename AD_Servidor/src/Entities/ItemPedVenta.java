package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bean.ItemPedVentaDTO;

@Entity
@Table(name = "ItemsPedidoVenta")
public class ItemPedVenta
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "ItemPedVenta", joinColumns = @JoinColumn(name = "idPedidoVenta"), inverseJoinColumns = @JoinColumn(name = "idItemCotizacion"))
	private ItemCotizacion itCotizacion;
	
	@Column
	private int cantRecibida;
	
	public int getId()
	{
		return id;
	}
	
	public ItemPedVentaDTO getDTO()
	{
		ItemPedVentaDTO itemDTO = new ItemPedVentaDTO();
		itemDTO.setCantRecibida(cantRecibida);
		itemDTO.setId(id);
		itemDTO.setItCotizacion(itCotizacion.getDTO());
		return itemDTO;
	}
	
	public ItemCotizacion getItCotizacion()
	{
		return itCotizacion;
	}
	
	public void setItCotizacion(ItemCotizacion itCotizacion)
	{
		this.itCotizacion = itCotizacion;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getCantRecibida()
	{
		return cantRecibida;
	}
	
	public void setCantRecibida(int cantRecibida)
	{
		this.cantRecibida = cantRecibida;
	}
}