package Dao;

import org.hibernate.Transaction;

import Entities.Rodamiento;

public class RodamientoDAO extends BaseDAO
{
	public static Rodamiento getRodamiento(String codigoSKF)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			Rodamiento rod = getSession().get(Rodamiento.class, codigoSKF);
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