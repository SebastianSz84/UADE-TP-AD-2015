package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entities.Cliente;

import org.hibernate.cfg.Configuration;

public class BaseDAO {
	
	private static Session _session;
	
	public static Session getSession()
	{
		if (_session == null) {
			// Create session 
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Cliente.class);

			cfg.configure("hibernate.cfg.xml");  
			SessionFactory factory = cfg.buildSessionFactory();  
			_session = factory.openSession();  
		}
		return _session;
	}
	
	public static <T> T getEntity(Class<T> cls, int id) {
		Transaction tx = getSession().beginTransaction();
		try {
			T entity = getSession().get(cls, id);
			tx.commit();
			return entity;
		}
		catch (Exception ex) {
			tx.rollback();
		}
		return null;
	}

	public static <T> T saveEntity(T entity) {
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().save(entity);
			tx.commit();
		}
		catch (Exception ex) {
			tx.rollback();
		}
		return entity;
	}
	
	public static <T> void deleteEntity(T entity) {
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().delete(entity);
			tx.commit();
		}
		catch (Exception ex) {
			tx.rollback();
		}
	}
	

}
