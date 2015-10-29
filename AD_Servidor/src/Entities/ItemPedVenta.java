package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import bean.ItemPedVentaDTO;

@Entity
@Table(name = "ItemsPedidoVenta")
public class ItemPedVenta
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Rodamiento rodamiento;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "idPedidoVenta")
	private PedVenta PedidoVenta;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
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