package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
	
	@SuppressWarnings("unchecked")
	public static List<Cotizacion> getCotizacionesDeCliente(int nroCliente)
	{
		try
		{
			// Session session = getSession();
			// Query query = session.createQuery("FROM Cotizacion cot WHERE cot.cliente.id = " + nroCliente);
			Session newSession = getNewSession();
			Query query = newSession.createQuery("FROM Cotizacion cot WHERE cot.cliente.id = " + nroCliente);
			List<Cotizacion> list = query.list();
			return list;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public static long getCantCotAbiertasXRod(String codigoSKF)
	{
		try
		{
			return (long) getSession().createQuery("select count(c.id) from Cotizacion c join c.items it join it.rod r where r.codigoSKF = '" + codigoSKF + "' and ( c.estado = 'Pendiente' or c.estado = 'Armada' or c.estado = 'Aceptada' )").uniqueResult();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;
	}
}