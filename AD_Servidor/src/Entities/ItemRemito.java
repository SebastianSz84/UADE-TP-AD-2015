package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemRemito
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int cantidad;
	
	@OneToOne
	@JoinColumns(@JoinColumn(name = "codigoSKF"))
	private Rodamiento rodamiento;
	
	@ManyToOne
	@JoinColumn(name = "idRemito")
	private Remito remito;
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
	}
	
	public Remito getRemito()
	{
		return remito;
	}
	
	public void setRemito(Remito remito)
	{
		this.remito = remito;
	}
}
