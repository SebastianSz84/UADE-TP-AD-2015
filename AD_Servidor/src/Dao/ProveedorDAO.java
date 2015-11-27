package Dao;

import java.util.List;

import org.hibernate.Transaction;

import Entities.Proveedor;

public class ProveedorDAO extends BaseDAO
{
	public static Proveedor getProveedor(int codigoProveedor)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			Proveedor prov = getSession().get(Proveedor.class, codigoProveedor);
			tx.commit();
			return prov;
		}
		catch (Exception ex)
		{
			tx.rollback();
		}
		return null;
	}
	
	public static List<Proveedor> getListaProveedores()
	{
		return getAll(Proveedor.class, "Proveedor");
	}
}