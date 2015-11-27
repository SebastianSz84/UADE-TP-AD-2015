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

@Entity
@Table(name = "ItemCotizacion")
public class ItemCotizacion
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "codigoSKF")
	private Rodamiento rod;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProveedor")
	private Proveedor proveedor;
	
	@Column
	private int cantidad;
	
	public float getSubtotal()
	{
		return this.cantidad * this.proveedor.getItemProveedor(rod).getPrecio();
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
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
	
}