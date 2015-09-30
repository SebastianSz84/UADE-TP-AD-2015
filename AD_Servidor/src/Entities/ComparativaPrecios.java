package Entities;

import java.util.Vector;

import bean.ItemCotizacionDTO;

public class ComparativaPrecios
{
	private static ComparativaPrecios instancia;
	private Vector<ItemPrecios> items;
	
	public ItemPrecios getMejorPrecio(ItemCotizacionDTO itCotDTO)
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
	
	public ItemPrecios buscarRodamiento(String codigoSKF)
	{
		return null;
	}
	
	public void ActualizarPrecio(Proveedor proveedor, ItemProveedor itemProveedorFinal)
	{
		
	}
	
	public static ComparativaPrecios getInstancia()
	{
		if (instancia == null)
		{
			instancia = new ComparativaPrecios();
		}
		return instancia;
	}
	
	public static void setInstancia(ComparativaPrecios instancia)
	{
		ComparativaPrecios.instancia = instancia;
	}
	
	public Vector<ItemPrecios> getItems()
	{
		return items;
	}
	
	public void setItems(Vector<ItemPrecios> items)
	{
		this.items = items;
	}
}