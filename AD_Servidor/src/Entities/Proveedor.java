package Entities;

import java.util.Vector;

import bean.ProveedorDTO;

public class Proveedor
{
	private int codigoProveedor;
	
	public int getCodigoProveedor()
	{
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(int codigoProveedor)
	{
		this.codigoProveedor = codigoProveedor;
	}
	
	public Vector<ItemProveedor> getItems()
	{
		return items;
	}
	
	public void setItems(Vector<ItemProveedor> items)
	{
		this.items = items;
	}
	
	private Vector<ItemProveedor> items = new Vector<ItemProveedor>();
	
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
	
	}
	
	public ItemProveedor buscarItem(String codigoItem)
	{
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