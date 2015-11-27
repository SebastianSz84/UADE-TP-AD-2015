package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemBultos")
public class ItemBulto
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int cantidad;
	
	@OneToOne
	@JoinColumns(@JoinColumn(name = "codigoSKF"))
	private Rodamiento rodamiento;
	
	public ItemBulto()
	{
		
	}
	
	public ItemBulto(int cantidad, Rodamiento rodamientoComprado)
	{
		this.cantidad = cantidad;
		this.setRodamiento(rodamientoComprado);
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
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
	}
	
}
