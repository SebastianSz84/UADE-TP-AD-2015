package Dao;

import org.hibernate.Transaction;

import Entities.Rodamiento;

public class RodamientoDAO extends BaseDAO
{
	public static Rodamiento getRodamiento(int id)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			Rodamiento rod = getSession().get(Rodamiento.class, id);
			tx.commit();
			return rod;
		}
		catch (Exception ex)
		{
			tx.rollback();
		}
		return null;
	}
}