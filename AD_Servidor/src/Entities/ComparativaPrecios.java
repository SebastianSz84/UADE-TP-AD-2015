package Entities;

import java.util.Vector;

public class ComparativaPrecios
{
	private static ComparativaPrecios instancia; // Se le pone el singleton en algun lado? singleton;
	private Vector<ItemPrecios> items;
	
	public ItemPrecios getMejorPrecio()
	{
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