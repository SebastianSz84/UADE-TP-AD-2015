package Entities;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import Dao.ComparativaPreciosDAO;
import bean.ItemCotizacionDTO;

@Entity
public class ComparativaPrecios
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	@JoinColumn(name = "idComparativa")
	private Vector<ItemProveedor> items;
	
	private static ComparativaPrecios instancia;
	
	public ItemProveedor getMejorPrecio(ItemCotizacionDTO itCotDTO)
	{
		for (int i = 0; i < this.items.size(); i++)
		{
			if (this.items.elementAt(i).equals(itCotDTO))
			{
				return this.items.elementAt(i);
			}
		}
		return null;
	}
	
	public ItemProveedor buscarRodamiento(String codigoSKF)
	{
		for (ItemProveedor item : items)
		{
			if (item.getRodamiento().getCodigoSKF().equals(codigoSKF))
			{
				return item;
			}
		}
		return null;
	}
	
	public void ActualizarPrecio(ItemProveedor itemProveedorFinal)
	{
		ItemProveedor item = buscarRodamiento(itemProveedorFinal.getRodamiento().getCodigoSKF());
		if (item != null)
		{
			items.remove(item);
			items.add(itemProveedorFinal);
		}
		else
		{
			items.addElement(itemProveedorFinal);
		}
	}
	
	public static ComparativaPrecios getInstancia()
	{
		if (instancia == null)
		{
			instancia = ComparativaPreciosDAO.getComparativa(1);
		}
		return instancia;
	}
	
	public static void setInstancia(ComparativaPrecios instancia)
	{
		ComparativaPrecios.instancia = instancia;
	}
	
	public Vector<ItemProveedor> getItems()
	{
		return items;
	}
	
	public void setItems(Vector<ItemProveedor> items)
	{
		this.items = items;
	}
	
	public ItemProveedor getItemSKF(String codigoSKF)
	{
		for (ItemProveedor itPr : items)
		{
			if (itPr.getRodamiento().getCodigoSKF().equals(codigoSKF))
			{
				return itPr;
			}
		}
		return null;
	}
	
	private ComparativaPrecios()
	{
	}
}