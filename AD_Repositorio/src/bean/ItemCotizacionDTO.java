package bean;

import java.io.Serializable;

public class ItemCotizacionDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidad;
	private RodamientoDTO rod;
	private ItemProveedorDTO itProveedor;
	private boolean cotizado;
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public RodamientoDTO getRod()
	{
		return rod;
	}
	
	public void setRod(RodamientoDTO rod)
	{
		this.rod = rod;
	}
	
	public boolean isCotizado()
	{
		return cotizado;
	}
	
	public void setCotizado(boolean cotizado)
	{
		this.cotizado = cotizado;
	}
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	public ItemProveedorDTO getItProveedor()
	{
		return itProveedor;
	}
	
	public void setItProveedor(ItemProveedorDTO itProveedor)
	{
		this.itProveedor = itProveedor;
	}
}