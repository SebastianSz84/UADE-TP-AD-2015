package Dao;

import org.hibernate.Transaction;
import Entities.*;

public class ClienteDAO extends BaseDAO {

	public static Cliente getCliente(int codigo) {
		Transaction tx = getSession().beginTransaction();
		try {
			Cliente cliente = getSession().get(Cliente.class, codigo);
			tx.commit();
			return cliente;
		}
		catch (Exception ex) {
			tx.rollback();
		}
		return null;
	}
	
	public static void saveCliente(Cliente cliente) {
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().save(cliente);
			tx.commit();
		}
		catch (Exception ex) {
			tx.rollback();
		}
	}
	
}
