package Dao;

import java.util.List;

import Entities.OCProveedor;

public class OCProveedorDAO extends BaseDAO
{
	
	public static OCProveedor getOCProveedor(int codigo)
	{
		return getEntity(OCProveedor.class, codigo);
	}
	
	public static OCProveedor saveOCProveedor(OCProveedor oc)
	{
		return saveEntity(oc);
	}
	
	public static void deleteOCProveedor(OCProveedor oc)
	{
		deleteEntity(oc);
	}
	
	public static List<OCProveedor> getListaOCProveedores()
	{
		return getAll(OCProveedor.class, "OCProveedor");
	}
}
