package Entities;

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
@Table(name = "ItemsBulto")
public class ItemBulto
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int cantidad;
	
	@OneToOne
	@JoinColumn(name = "idRodamiento")
	private Rodamiento rodamiento;
	
	@ManyToOne
	@JoinColumn(name = "idBulto")
	private Bulto bulto;
	
	public ItemBulto(Bulto bulto, int cantidad, Rodamiento rodamientoComprado)
	{
		this.bulto = bulto;
		this.cantidad = cantidad;
		this.rodamiento = rodamientoComprado;
	}
	
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
	
}
