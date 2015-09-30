package Entities;

import bean.ItemPreciosDTO;

public class ItemPrecios
{
	private Rodamiento rodamiento;
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
