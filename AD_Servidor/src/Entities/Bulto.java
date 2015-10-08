package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Bulto
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@ManyToOne
	@JoinColumn(name = "idOVenta")
	public OVenta OficinaDeVenta;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idBulto")
	public List<ItemBulto> items;
	
	public Bulto()
	{
		this.items = new ArrayList<ItemBulto>();
	}
	
	public void agregarRodamientoComprado(Rodamiento rodamientoComprado)
	{
		
	}
	
	public List<ItemBulto> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemBulto> items)
	{
		this.items = items;
	}
}
