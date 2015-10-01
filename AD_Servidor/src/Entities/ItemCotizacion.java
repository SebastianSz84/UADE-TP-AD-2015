package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ItemCotizacion")
public class ItemCotizacion
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int cantidad;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Rodamiento rod;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
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
	
	public Rodamiento getRod()
	{
		return rod;
	}
	
	public void setRod(Rodamiento rod)
	{
		this.rod = rod;
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
}