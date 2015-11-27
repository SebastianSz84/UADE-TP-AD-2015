package Entities;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Dao.OCProveedorDAO;
import Dao.ProveedorDAO;
import Dao.RodamientoDAO;
import Helper.OCProveedorXML;
import Helper.ProveedorListaPreciosXML;
import bean.ItemProveedorDTO;
import bean.ProveedorDTO;

public class CCentral
{
	private static CCentral instancia;
	
	/*
	 * public void altaProveedor( ProveedorDTO) { } public void bajaProveedor( ProveedorDTO) { } public void modificacionProveedor( ProveedorDTO) { } public CotizacionDTO crearCotizacion() { return null; }
	 */
	
	public void crearOC(ItemPedVenta item)
	{
		OCProveedor oc = new OCProveedor();
		oc.agregarAOC(item.getRodamiento(), item.getCantidad());
		oc.setProveedor(ProveedorDAO.getProveedor(item.getProveedor().getCodigoProveedor()));
		OCProveedorDAO.saveEntity(oc);
	}
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio)
	{
		Rodamiento rod = buscarRodamiento(codigoSKF);
		rod.ActualizarStock(cantidad, precio);
		RodamientoDAO.saveEntity(rod);
	}
	
	private Rodamiento buscarRodamiento(String codigoSKF)
	{
		return RodamientoDAO.getRodamiento(codigoSKF);
	}
	
	public void GenerarBultosDeRodamiento(Rodamiento rodamiento, int cantidad)
	{
		// for (Remito remito : remitosOV)
		// {
		// Bulto bulto = new Bulto();
		// for (Rodamiento rodamiento : rodamientosComprados)
		// {
		// if (remito.contieneRodamiento(rodamiento))
		// {
		// rodamientosComprados.remove(rodamiento);
		// bulto.agregarRodamientoComprado(rodamiento, 0);
		// }
		// }
		// BultoDAO.saveEntity(bulto);
		// }
	}
	
	public void GenerarOrdenesDeCompra(List<PedVenta> pedidos)
	{
		for (PedVenta pedido : pedidos)
		{
			for (ItemPedVenta item : pedido.getItems())
			{
				OCProveedor ocProv = buscarOC(item.getProveedor().getCodigoProveedor());
				if (ocProv != null)
				{
					ocProv.agregarAOC(item.getRodamiento(), item.getCantidad());
				}
				else
				{
					crearOC(item);
				}
			}
		}
		OCProveedorXML.GenerarXMLOrdenesDeCompra(OCProveedorDAO.getListaOCProveedores());
		
	}
	
	private OCProveedor buscarOC(int codigoProveedor)
	{
		return OCProveedorDAO.getOCProveedor(codigoProveedor);
	}
	
	public void publicarListaDePreciosFinal()
	{
		if (ComparativaPrecios.getInstancia().deleteItems())
		{
			ComparativaPrecios.getInstancia().setFecha(Calendar.getInstance().getTime());
			for (Rodamiento rod : RodamientoDAO.getListaRodamientos())
			{
				ItemProveedor mejorPrecio = null;
				Proveedor mejorProveedor = null;
				for (Proveedor prov : ProveedorDAO.getListaProveedores())
				{
					ItemProveedor itemProv = prov.getItemProveedor(rod);
					if (itemProv != null && (mejorPrecio == null || mejorPrecio.getPrecio() < itemProv.getPrecio()))
					{
						mejorPrecio = itemProv;
						mejorProveedor = prov;
					}
				}
				
				if (mejorPrecio != null && mejorProveedor != null)
				{
					ComparativaPrecios.getInstancia().ActualizarPrecio(mejorPrecio);
				}
			}
		}
	}
	
	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor)
	{
		Proveedor proveedor = buscarProveedor(codigoProveedor);
		if (proveedor != null)
		{
			ProveedorDTO dto = ProveedorListaPreciosXML.leerArchivoListaPrecios(archivoProveedor);
			Vector<ItemProveedor> items = new Vector<>();
			for (ItemProveedorDTO itemDTO : dto.getRodamientos())
			{
				Rodamiento rod = buscarRodamiento(itemDTO.getSKF());
				if (rod != null)
				{
					ItemProveedor itProv = new ItemProveedor(proveedor, itemDTO.getCodRodProv(), itemDTO.getPrecio(), itemDTO.getCondciones(), itemDTO.getDisponible(), rod);
					items.addElement(itProv);
				}
			}
			
			proveedor.setItems(items);
			ProveedorDAO.saveEntity(proveedor);
		}
	}
	
	public Proveedor buscarProveedor(int codigoProveedor)
	{
		return ProveedorDAO.getProveedor(codigoProveedor);
	}
	
	public static CCentral getInstancia()
	{
		if (instancia == null)
		{
			instancia = new CCentral();
		}
		return instancia;
	}
	
	public static void setInstancia(CCentral instancia)
	{
		CCentral.instancia = instancia;
	}
	
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF)
	{
		Proveedor proveedor = buscarProveedor(codigoProveedor);
		if (proveedor != null)
		{
			Rodamiento rod = buscarRodamiento(codigoSKF);
			if (rod != null)
			{
				ItemProveedor item = proveedor.buscarItem(codigoItem);
				if (item == null)
				{
					proveedor.agregarItem(codigoItem, precio, condiciones, disponible, rod);
				}
				else
				{
					item.actualizar(precio, condiciones, disponible, rod);
				}
			}
		}
		ProveedorDAO.saveEntity(proveedor);
		
	}
}
