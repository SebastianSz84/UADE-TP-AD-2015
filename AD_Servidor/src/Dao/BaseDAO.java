package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
