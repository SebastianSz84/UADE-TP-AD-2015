package Entities;

import bean.ProveedorDTO;

public class Proveedor
{
	private int codigoProveedor;
	
	public ItemProveedor getItemProveedor(Rodamiento rodamiento)
	{
		return null;
	}
	
	/*
	 * public void XMLToList( XML archivoProveedor, Vector<Rodamiento> rodamientos) { } public DataSet convertToDataSet( XML archivoProveedor) { }
	 */
	public Rodamiento find(String codigoSKF)
	{
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
}