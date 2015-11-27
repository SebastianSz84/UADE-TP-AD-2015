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
	private ProveedorDTO proveedor;
	
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
	
	public ProveedorDTO getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(ProveedorDTO proveedor)
	{
		this.proveedor = proveedor;
	}
	
}