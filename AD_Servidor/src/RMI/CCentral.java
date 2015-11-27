package RMI;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Dao.OCProveedorDAO;
import Dao.ProveedorDAO;
import Entities.Bulto;
import Entities.ComparativaPrecios;
import Entities.ItemPedVenta;
import Entities.ItemProveedor;
import Entities.OCProveedor;
import Entities.PedVenta;
import Entities.Proveedor;
import Entities.Remito;
import Entities.Rodamiento;
import Helper.OCProveedorXML;
import Helper.ProveedorListaPreciosXML;
import bean.ItemProveedorDTO;
import bean.ProveedorDTO;

public class CCentral
{
	private static CCentral instancia;
	private ComparativaPrecios comparativa;
	private List<Proveedor> proveedores;
	private List<Bulto> bultos;
	private List<OCProveedor> ordenesCompra;
	private List<Rodamiento> rodamientos;
	
	/*
	 * public void altaProveedor( ProveedorDTO) { } public void bajaProveedor( ProveedorDTO) { } public void modificacionProveedor( ProveedorDTO) { } public CotizacionDTO crearCotizacion() { return null; }
	 */
	
	public void crearOC(ItemPedVenta item)
	{
		OCProveedor oc = new OCProveedor();
		oc.agregarAOC(item.getRodamiento(), item.getCantidad());
		oc.setProveedor(ProveedorDAO.getProveedor(item.getProveedor().getCodigoProveedor()));
		ordenesCompra.add(oc);
		OCProveedorDAO.saveEntity(oc);
	}
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio)
	{
		buscarRodamiento(codigoSKF).ActualizarStock(cantidad, precio);
	}
	
	private Rodamiento buscarRodamiento(String codigoSKF)
	{
		for (Rodamiento rod : rodamientos)
		{
			if (rod.sosRodamiento(codigoSKF))
				return rod;
		}
		
		return null;
	}
	
	public void GenerarBultosDeRodamiento(List<Remito> remitosOV, List<Rodamiento> rodamientosComprados)
	{
		for (Remito remito : remitosOV)
		{
			Bulto bulto = new Bulto();
			for (Rodamiento rodamiento : rodamientosComprados)
			{
				if (remito.contieneRodamiento(rodamiento))
				{
					/* agregar cantidad aca */
					rodamientosComprados.remove(rodamiento);
					bulto.agregarRodamientoComprado(rodamiento, 0);
				}
			}
			bultos.add(bulto);
		}
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
		OCProveedorXML.GenerarXMLOrdenesDeCompra(ordenesCompra);
		
	}
	
	private OCProveedor buscarOC(int codigoProveedor)
	{
		for (OCProveedor ocprov : ordenesCompra)
		{
			if (ocprov.getProveedor().getCodigoProveedor() == codigoProveedor)
			{
				return ocprov;
			}
		}
		return null;
	}
	
	public void publicarListaDePreciosFinal()
	{
		if (ComparativaPrecios.getInstancia().deleteItems())
		{
			ComparativaPrecios.getInstancia().setFecha(Calendar.getInstance().getTime());
			for (Rodamiento rod : rodamientos)
			{
				ItemProveedor mejorPrecio = null;
				Proveedor mejorProveedor = null;
				for (Proveedor prov : proveedores)
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
		}
	}
	
	public Proveedor buscarProveedor(int codigoProveedor)
	{
		for (Proveedor prov : proveedores)
		{
			if (prov.getCodigoProveedor() == codigoProveedor)
			{
				return prov;
			}
		}
		return null;
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
	
	public List<Proveedor> getProveedores()
	{
		return proveedores;
	}
	
	public void setProveedores(Vector<Proveedor> proveedores)
	{
		this.proveedores = proveedores;
	}
	
	public List<Bulto> getBultos()
	{
		return bultos;
	}
	
	public void setBultos(Vector<Bulto> bultos)
	{
		this.bultos = bultos;
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
		
	}
}
