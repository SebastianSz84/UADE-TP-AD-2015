package Entities;

import java.util.Vector;

public class OCProveedor
{
	private Proveedor proveedor;
	private String codigo;
	private Vector<ItemOCProveedor> items;
	
	public void agregarAOC(Rodamiento rodamiento, int cantidad)
	{
		ItemOCProveedor item = new ItemOCProveedor();
		item.setCantidad(cantidad);
		item.setRodamiento(rodamiento);
		items.add(item);
	}
	
	public Rodamiento buscarRodamientoEnOC(String SKF)
	{
		
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