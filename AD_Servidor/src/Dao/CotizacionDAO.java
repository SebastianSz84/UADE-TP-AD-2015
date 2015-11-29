package Dao;

import java.util.List;

import org.hibernate.Query;

import Entities.Cotizacion;

public class CotizacionDAO extends BaseDAO
{
	public static Cotizacion getCotizacion(int id)
	{
		return getEntity(Cotizacion.class, id);
	}
	
	public static Cotizacion saveCotizacion(Cotizacion cot)
	{
		return saveEntity(cot);
	}
	
	public static List<Cotizacion> getCotizacionesDeCliente(int nroCliente)
	{
		try
		{
			Query query = getSession().createQuery("FROM Cotizacion cot WHERE cot.cliente.id = " + nroCliente);
			query.setCacheable(false);
			List<Cotizacion> list = query.list();
			return list;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}