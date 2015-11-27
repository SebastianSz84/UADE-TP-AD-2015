package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemCotizacion")
public class ItemCotizacion
{
	@EmbeddedId
	private ItemCotizacionId id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProveedor")
	private Proveedor proveedor;
	
	@Column
	private int cantidad;
	
	@Column
	private float precio;
	
	public float getSubtotal()
	{
		return this.cantidad * this.precio;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
	
	public ItemCotizacionId getId()
	{
		return id;
	}
	
	public void setId(ItemCotizacionId id)
	{
		this.id = id;
	}
}