package Entities;

import java.util.Vector;

public class OCProveedor
{
	private Proveedor proveedor;
	private String codigo;
	private Vector<ItemOCProveedor> items;
	
	public void agregarAOC(Rodamiento rodamiento, int cantidad)
	{
		ItemOCProveedor item = buscarRodamientoEnOC(rodamiento.getCodigoSKF());
		if (item == null)
		{
			item = new ItemOCProveedor();
			item.setCantidad(cantidad);
			item.setRodamiento(rodamiento);
			items.add(item);
		}
		else
		{
			item.actualizarCantidad(cantidad);
		}
	}
	
	public ItemOCProveedor buscarRodamientoEnOC(String SKF)
	{
		for (ItemOCProveedor item : items)
		{
			if (item.getRodamiento().getCodigoSKF().equals(SKF))
			{
				return item;
			}
		}
		return null;
	}
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
	
	public String getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
}