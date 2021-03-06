package Dao;

import java.util.List;

import org.hibernate.Transaction;

import Entities.Bulto;

public class BultoDAO extends BaseDAO
{
	public static Bulto getBulto(int id)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			Bulto bulto = getSession().get(Bulto.class, id);
			tx.commit();
			return bulto;
		}
		catch (Exception ex)
		{
			tx.rollback();
		}
		return null;
	}
	
	public static List<Bulto> getListaBultos()
	{
		return getAll(Bulto.class, "Bultos");
	}
	
	public static Bulto getBultoAbiertoByOV(int OVid)
	{
		return (Bulto) getSession().createQuery("FROM Bulto B WHERE B.estado = :estado and B.OficinaDeVenta.id = :OVid").setParameter("estado", "Abierto").setParameter("OVid", OVid).uniqueResult();
	}
}