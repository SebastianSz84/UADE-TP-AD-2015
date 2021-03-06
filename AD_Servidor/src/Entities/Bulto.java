package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bultos")
public class Bulto
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idOVenta")
	private OVenta OficinaDeVenta;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idBulto")
	private List<ItemBulto> items;
	
	@Column
	private String estado;
	
	public Bulto()
	{
		this.items = new ArrayList<ItemBulto>();
	}
	
	public void agregarRodamientoComprado(Rodamiento rodamientoComprado, int cantidad)
	{
		ItemBulto nuevoBulto = new ItemBulto(cantidad, rodamientoComprado);
		nuevoBulto.setBulto(this);
		items.add(nuevoBulto);
	}
	
	public List<ItemBulto> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemBulto> items)
	{
		this.items = items;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public OVenta getOficinaDeVenta()
	{
		return OficinaDeVenta;
	}
	
	public void setOficinaDeVenta(OVenta oficinaDeVenta)
	{
		OficinaDeVenta = oficinaDeVenta;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
	
	public ItemBulto buscarItemParaRodamiento(String codigoSKF)
	{
		for (ItemBulto itemBulto : items)
		{
			if (itemBulto.getRodamiento().getCodigoSKF().equals(codigoSKF))
			{
				return itemBulto;
			}
		}
		return null;
	}
}
