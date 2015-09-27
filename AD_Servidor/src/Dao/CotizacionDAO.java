package Dao;

import org.hibernate.Transaction;

import Entities.Cotizacion;

public class CotizacionDAO extends BaseDAO {
	public static Cotizacion getCotizacion(int id) {
		Transaction tx = getSession().beginTransaction();
		try {
			Cotizacion cot = getSession().get(Cotizacion.class, id);
			tx.commit();
			return cot;
		} catch (Exception ex) {
			tx.rollback();
		}
		return null;
	}
}