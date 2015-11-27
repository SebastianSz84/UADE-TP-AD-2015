package Dao;

import java.util.List;

import Entities.ItemProveedor;
import Entities.Proveedor;

public class ProveedorDAO extends BaseDAO
{
	public static Proveedor getProveedor(int codigoProveedor)
	{
		return getEntity(Proveedor.class, codigoProveedor);
	}
	
	public static List<Proveedor> getListaProveedores()
	{
		return getAll(Proveedor.class, "Proveedor");
	}
	
	public static ItemProveedor getItProveedor(int id)
	{
		return getEntity(ItemProveedor.class, id);
	}
}