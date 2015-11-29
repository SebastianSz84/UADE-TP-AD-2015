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
	
	@SuppressWarnings("unchecked")
	public static List<ItemPedVenta> listItemPedVentaByRodamiento(int idPedVenta, String codigoSKF)
	{
		return getSession().createQuery("FROM ItemPedVenta I WHERE I.pedVenta.id = :idPedVenta and I.itCotizacion.rod.codigoSKF = :codigoSKF").setParameter("idPedVenta", idPedVenta).setParameter("codigoSKF", codigoSKF).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<PedVenta> getListaPedVentaPendientes()
	{
		return getSession().createQuery("from PedVenta where estado = :est").setParameter("est", "Pendiente").list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<PedVenta> getListaPedVentaPendientesPorOVenta(int idOVenta)
	{
		return getSession().createQuery("from PedVenta pv where pv.estado = :est and pv.oVenta.id = :idOVenta").setParameter("est", "Pendiente").setParameter("idOVenta", idOVenta).list();
	}
	
	public static PedVenta savePedVenta(PedVenta pedVta)
	{
		return saveEntity(pedVta);
	}
}