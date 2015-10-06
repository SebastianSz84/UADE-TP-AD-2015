package Dao;

import java.util.List;

import Entities.OVenta;

public class OVentaDAO extends BaseDAO
{
	
	public static OVenta getOVenta(int codigo)
	{
		return getEntity(OVenta.class, codigo);
	}
	
	public static OVenta saveOVenta(OVenta ov)
	{
		return saveEntity(ov);
	}
	
	public static void deleteOVenta(OVenta ov)
	{
		deleteEntity(ov);
	}
	
	public static List<OVenta> getAll()
	{
		return getAll(OVenta.class, "OVentas");
	}
}
