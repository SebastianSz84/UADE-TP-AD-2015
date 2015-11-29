package Entities;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Dao.BultoDAO;
import Dao.OCProveedorDAO;
import Dao.PedVentaDAO;
import Dao.ProveedorDAO;
import Dao.RodamientoDAO;
import Helper.BultosXML;
import Helper.ProveedorListaPreciosXML;
import bean.ItemProveedorDTO;
import bean.PedVentaDTO;
import bean.ProveedorDTO;

public class CCentral
{
	private static CCentral instancia;
	
	public void altaProveedor(ProveedorDTO proveedorDTO)
	{
		Proveedor proveedor = new Proveedor(proveedorDTO);
		ProveedorDAO.saveEntity(proveedor);
	}
	
	public void bajaProveedor(int codigoProveedor)
	{
		Proveedor proveedor = buscarProveedor(codigoProveedor);
		ProveedorDAO.deleteEntity(proveedor);
	}
	
	public void modificacionProveedor(ProveedorDTO proveedorDTO)
	{
		Proveedor proveedor = buscarProveedor(proveedorDTO.getCodigoProveedor());
		proveedor.modificar(proveedorDTO);
		ProveedorDAO.saveEntity(proveedor);
	}
	
	public void crearOC(ItemPedVenta item)
	{
		OCProveedor oc = new OCProveedor();
		oc.agregarAOC(item.getItCotizacion().getRod(), item.getItCotizacion().getCantidad());
		oc.setProveedor(ProveedorDAO.getProveedor(item.getItCotizacion().getItProveedor().getProveedor().getCodigoProveedor()));
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
	
	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad)
	{
		Rodamiento rodamiento = RodamientoDAO.getRodamiento(codigoSKF);
		if (rodamiento == null)
			return -1;
		// float precio = 0;
		for (PedVenta pedVenta : PedVentaDAO.getListaPedVentaPendientes())
		{
			ItemPedVenta itemPedVenta = PedVentaDAO.getItemPedVentaByRodamiento(pedVenta.getId(), rodamiento.getCodigoSKF());
			if ((cantidad > 0 || rodamiento.getStock().getCantidad() > 0) && itemPedVenta != null)
			{
				Bulto bulto = BultoDAO.getBultoByOV(pedVenta.getCotizacion().getCliente().getOVenta().getId());
				if (bulto == null)
				{
					bulto = new Bulto();
					bulto.setOficinaDeVenta(pedVenta.getCotizacion().getCliente().getOVenta());
				}
				int cantidadUsada = 0;
				if (cantidad >= itemPedVenta.getItCotizacion().getCantidad())
				{
					cantidadUsada = itemPedVenta.getItCotizacion().getCantidad();
					cantidad -= cantidadUsada;
				}
				else
				{
					cantidadUsada = cantidad;
					cantidad = 0;
					if (rodamiento.getStock().getCantidad() > 0)
					{
						int cantidadRestante = itemPedVenta.getItCotizacion().getCantidad() - cantidadUsada;
						if (rodamiento.getStock().getCantidad() >= cantidadRestante)
						{
							cantidadUsada = itemPedVenta.getItCotizacion().getCantidad();
							rodamiento.getStock().setCantidad(rodamiento.getStock().getCantidad() - cantidadRestante);
						}
						else
						{
							cantidadUsada += rodamiento.getStock().getCantidad();
							rodamiento.getStock().setCantidad(0);
						}
					}
				}
				bulto.agregarRodamientoComprado(rodamiento, cantidadUsada);
				BultoDAO.saveEntity(bulto);
				BultosXML.GenerarXMLBulto(bulto);
				// precio = itemPedVenta.getPrecio();
			}
		}
		
		if (cantidad > 0)
		{
			rodamiento.getStock().setCantidad(rodamiento.getStock().getCantidad() + cantidad);
			// rodamiento.getStock().setPrecio(precio);
			RodamientoDAO.saveEntity(rodamiento);
		}
		return 0;
	}
	
	public void generarOrdenesDeCompra(List<PedVentaDTO> pedidos)
	{
		// List<OCProveedor> listaOCs = new ArrayList<OCProveedor>();
		// for (PedVentaDTO pedido : pedidos)
		// {
		// for (ItemPedVentaDTO item : pedido.getItems())
		// {
		// OCProveedor ocProv = buscarOC(listaOCs);
		// if (ocProv != null) // && oc.status es "abierta"
		// {
		// ocProv.agregarAOC(item.getItCotizacion().getRod(), item.getItCotizacion().getCantidad());
		// }
		// else
		// {
		// crearOC(item);
		// }
		// }
		// }
		// OCProveedorXML.GenerarXMLOrdenesDeCompra(OCProveedorDAO.getListaOCProveedores());
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
