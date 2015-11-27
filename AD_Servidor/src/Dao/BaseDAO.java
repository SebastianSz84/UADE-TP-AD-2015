package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entities.Bulto;
import Entities.Cliente;
import Entities.ComparativaPrecios;
import Entities.CondCompra;
import Entities.Cotizacion;
import Entities.Envio;
import Entities.FormaPago;
import Entities.ItemBulto;
import Entities.ItemCotizacion;
import Entities.ItemEnvio;
import Entities.ItemOCProveedor;
import Entities.ItemPedVenta;
import Entities.ItemProveedor;
import Entities.ItemRemito;
import Entities.ListaPrecios;
import Entities.OCProveedor;
import Entities.OVenta;
import Entities.PedVenta;
import Entities.Proveedor;
import Entities.Remito;
import Entities.Rodamiento;

public class BaseDAO
{
	
	private static Session _session;
	
	public static Session getSession()
	{
		if (_session == null)
		{
			// Create session
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Bulto.class);
			cfg.addAnnotatedClass(Cliente.class);
			cfg.addAnnotatedClass(CondCompra.class);
			cfg.addAnnotatedClass(Cotizacion.class);
			cfg.addAnnotatedClass(Envio.class);
			cfg.addAnnotatedClass(FormaPago.class);
			cfg.addAnnotatedClass(ItemBulto.class);
			cfg.addAnnotatedClass(ItemCotizacion.class);
			cfg.addAnnotatedClass(ItemEnvio.class);
			cfg.addAnnotatedClass(ItemOCProveedor.class);
			cfg.addAnnotatedClass(ItemPedVenta.class);
			cfg.addAnnotatedClass(ItemProveedor.class);
			cfg.addAnnotatedClass(ItemRemito.class);
			cfg.addAnnotatedClass(ListaPrecios.class);
			cfg.addAnnotatedClass(OCProveedor.class);
			cfg.addAnnotatedClass(OVenta.class);
			cfg.addAnnotatedClass(PedVenta.class);
			cfg.addAnnotatedClass(Proveedor.class);
			cfg.addAnnotatedClass(Remito.class);
			cfg.addAnnotatedClass(Rodamiento.class);
			cfg.addAnnotatedClass(ComparativaPrecios.class);
			
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			_session = factory.openSession();
		}
		return _session;
	}
	
	public static <T> T getEntity(Class<T> cls, int id)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			T entity = getSession().get(cls, id);
			tx.commit();
			return entity;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	
	public static <T> T getEntity(Class<T> cls, String id)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			T entity = getSession().get(cls, id);
			tx.commit();
			return entity;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	
	public static <T> T saveEntity(T entity)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			getSession().saveOrUpdate(entity);
			tx.commit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		return entity;
	}
	
	public static <T> void deleteEntity(T entity)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			getSession().delete(entity);
			tx.commit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getAll(Class<T> cls, String tabla)
	{
		try
		{
			List<T> list = getSession().createQuery("from " + tabla).list();
			return list;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean deleteAll(String tabla)
	{
		Transaction tx = getSession().beginTransaction();
		String hql = String.format("delete from %s", tabla);
		try
		{
			getSession().createQuery(hql);
			tx.commit();
			return true;
		}
		catch (Exception ex)
		{
			tx.rollback();
		}
		return false;
	}
}