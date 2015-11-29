package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemOCProveedor")
public class ItemOCProveedor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idOCProveedor", referencedColumnName = "id")
	private OCProveedor ocProveedor;
	
	@ManyToOne
	@JoinColumn(name = "codigoSKF")
	private Rodamiento rodamiento;
	
	private int cantidad;
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public void actualizarCantidad(int cantidad)
	{
		this.cantidad += cantidad;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public OCProveedor getOcProveedor()
	{
		return ocProveedor;
	}
	
	public void setOcProveedor(OCProveedor ocProveedor)
	{
		this.ocProveedor = ocProveedor;
	}
	
	public ItemOCProveedor()
	{
	}
}