package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import bean.ItemPedVentaDTO;

@Entity
@Table(name = "ItemPedVenta")
public class ItemPedVenta
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Rodamiento rodamiento;
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
	private int cantidad;
	public float precio;
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public float getSubTotal()
	{
		return cantidad * precio;
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
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
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
	
	public ItemPedVentaDTO getDTO()
	{
		ItemPedVentaDTO itemDTO = new ItemPedVentaDTO();
		itemDTO.setCantidad(cantidad);
		itemDTO.setPrecio(precio);
		itemDTO.setRodamiento(rodamiento.getDTO());
		itemDTO.setProveedor(proveedor.getDTO());
		return itemDTO;
	}
}