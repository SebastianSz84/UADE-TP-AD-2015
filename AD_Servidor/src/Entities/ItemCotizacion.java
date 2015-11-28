package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bean.ItemCotizacionDTO;

@Entity
@Table(name = "ItemCotizacion")
public class ItemCotizacion
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idCotizacion", referencedColumnName = "id")
	private Cotizacion cot;
	
	@ManyToOne
	@JoinColumn(name = "codigoSKF")
	private Rodamiento rod;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idItemProveedor")
	private ItemProveedor itProveedor;
	
	@Column
	private int cantidad;
	
	@Column(nullable = false)
	private boolean cotizado;
	
	public float getSubtotal()
	{
		return this.cantidad * this.itProveedor.getPrecio();
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Rodamiento getRod()
	{
		return rod;
	}
	
	public void setRod(Rodamiento rod)
	{
		this.rod = rod;
	}
	
	public ItemProveedor getItProveedor()
	{
		return itProveedor;
	}
	
	public void setItProveedor(ItemProveedor itProveedor)
	{
		this.itProveedor = itProveedor;
	}
	
	public Cotizacion getCot()
	{
		return cot;
	}
	
	public void setCot(Cotizacion cot)
	{
		this.cot = cot;
	}
	
	public ItemCotizacionDTO getDTO()
	{
		ItemCotizacionDTO itCotDTO = new ItemCotizacionDTO();
		itCotDTO.setCantidad(cantidad);
		if (itProveedor != null)
		{
			itCotDTO.setItProveedor(itProveedor.getDTO());
		}
		itCotDTO.setRod(rod.getDTO());
		itCotDTO.setCotizado(cotizado);
		return itCotDTO;
	}
	
	public boolean isCotizado()
	{
		return cotizado;
	}
	
	public void setCotizado(boolean cotizado)
	{
		this.cotizado = cotizado;
	}
}