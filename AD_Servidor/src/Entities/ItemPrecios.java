package Entities;

import bean.ItemPreciosDTO;

public class ItemPrecios
{
	private Rodamiento rodamiento;
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
	}
	
	public String getCodRodProv()
	{
		return codRodProv;
	}
	
	public void setCodRodProv(String codRodProv)
	{
		this.codRodProv = codRodProv;
	}
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	private String codRodProv;
	private Proveedor proveedor;
	private float precio;
	
	ItemPrecios(Proveedor proveedor, ItemProveedor itemProveedor)
	{
		this.proveedor = proveedor;
	}
	
	public void actualizar(Proveedor proveedor, ItemProveedor itemProveedor)
	{
	
	}
	
	public ItemPreciosDTO getDTO()
	{
		ItemPreciosDTO itPrDTO = new ItemPreciosDTO();
		itPrDTO.setCodRodProv(this.codRodProv);
		itPrDTO.setPrecio(this.precio);
		itPrDTO.setProveedorDTO(this.proveedor.getDTO());
		itPrDTO.setRodamientoDTO(this.rodamiento.getDTO());
		return itPrDTO;
	}
}
