package Dao;

import org.hibernate.Transaction;
import Entities.*;

public class OVentaDAO extends BaseDAO {

	public static OVenta getOVenta(int id) {
		Transaction tx = getSession().beginTransaction();
		try {
			OVenta ov = getSession().get(OVenta.class, id);
			tx.commit();
			return ov;
		}
		catch (Exception ex) {
			tx.rollback();
		}
		return null;
	}
}
