package Entities;

import java.util.ArrayList;
import java.util.List;

import bean.ProveedorDTO;

public class Proveedor
{
	private int codigoProveedor;
	private List<ItemProveedor> items;
	
	public Proveedor()
	{
		items = new ArrayList<ItemProveedor>();
	}
	
	public int getCodigoProveedor()
	{
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(int codigoProveedor)
	{
		this.codigoProveedor = codigoProveedor;
	}
	
	public List<ItemProveedor> getItems()
	{
		return this.items;
	}
	
	public void setItems(List<ItemProveedor> items)
	{
		this.items = items;
	}
	
	public ItemProveedor getItemProveedor(Rodamiento rodamiento)
	{
		for (ItemProveedor itemProveedor : items)
		{
			if (itemProveedor.sosElRodamiento(rodamiento.getCodigoSKF()))
			{
				return itemProveedor;
			}
		}
		return null;
	}
	
	public Rodamiento find(String codigoSKF)
	{
		for (ItemProveedor itemProveedor : items)
		{
			if (itemProveedor.sosElRodamiento(codigoSKF))
			{
				return itemProveedor.getRodamiento();
			}
		}
		return null;
	}
	
	public void agregarItem(String codigoItem, float precio, String condiciones, boolean disponible, Rodamiento rodamiento)
	{
		ItemProveedor item = buscarItem(codigoItem);
		if (item != null)
		{
			item.actualizar(precio, condiciones, disponible, rodamiento);
		}
		else
		{
			items.add(new ItemProveedor(codigoItem, precio, condiciones, disponible, rodamiento));
		}
		
	}
	
	public ItemProveedor buscarItem(String codigoItem)
	{
		for (ItemProveedor item : items)
		{
			if (item.getCodigo().equals(codigoItem))
			{
				return item;
			}
		}
		return null;
	}
	
	public ProveedorDTO getDTO()
	{
		ProveedorDTO provDTO = new ProveedorDTO();
		provDTO.setCodigoProveedor(this.codigoProveedor);
		return provDTO;
	}
	
	/*
	 * public void XMLToList( XML archivoProveedor, Vector<Rodamiento> rodamientos) { } public DataSet convertToDataSet( XML archivoProveedor) { }
	 */
}