package Dao;

import java.util.List;

import org.hibernate.Transaction;

import Entities.ItemPedVenta;
import Entities.PedVenta;

public class PedVentaDAO extends BaseDAO
{
	public static PedVenta getPedVenta(int id)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			PedVenta pedVenta = getSession().get(PedVenta.class, id);
			tx.commit();
			return pedVenta;
		}
		catch (Exception ex)
		{
			tx.rollback();
		}
		return null;
	}
	
	public static List<PedVenta> getListaPedVenta()
	{
		return getAll(PedVenta.class, "PedidoVenta");
	}
	
	public static ItemPedVenta getItemPedVentaByRodamiento(int idPedVenta, String codigoSKF)
	{
		Transaction tx = getSession().beginTransaction();
		try
		{
			ItemPedVenta itempedVenta = (ItemPedVenta) getSession().createQuery("FROM ItemPedVenta I WHERE I.PedidoVenta.id = " + idPedVenta + " AND I.rodamiento.codigoSKF = " + codigoSKF).uniqueResult();
			tx.commit();
			return itempedVenta;
		}
		catch (Exception ex)
		{
			tx.rollback();
		}
		return null;
	}
}