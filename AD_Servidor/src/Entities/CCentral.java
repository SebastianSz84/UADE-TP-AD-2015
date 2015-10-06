package Entities;

import java.io.File;
import java.util.List;
import java.util.Vector;

import Dao.OCProveedorDAO;
import Dao.ProveedorDAO;
import Dao.RodamientoDAO;
import Helper.OCProveedorXML;
import Helper.ProveedorListaPreciosXML;
import bean.ItemProveedorDTO;
import bean.PedVentaDTO;
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
	
	public void crearOC(PedVentaDTO pedVta)
	{
		for (int i = 0; i < pedVta.getItems().size(); i++)
		{
			OCProveedor oc = new OCProveedor();
			oc.setProveedor(ProveedorDAO.getProveedor(pedVta.getItems().elementAt(i).getProveedor().getCodigoProveedor()));
			oc.agregarAOC(RodamientoDAO.getRodamiento(pedVta.getItems().elementAt(i).getRodamiento().getId()), pedVta.getItems().elementAt(i).getCantidad());
			ordenesCompra.add(oc);
			OCProveedorDAO.saveEntity(oc);
		}
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
					rodamientosComprados.remove(rodamiento);
					bulto.agregarRodamientoComprado(rodamiento);
				}
			}
			bultos.add(bulto);
		}
	}
	
	public void GenerarOrdenesDeCompra(List<PedVenta> pedidos) // ACA TMB VA listasXML
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
					crearOC(pedido.getDTO());
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
	
	public void PublicarListaDePreciosFinal()
	{
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
				ComparativaPrecios.getInstancia().ActualizarPrecio(mejorProveedor, mejorPrecio);
			}
		}
	}
	
	public void generarListaDePrecioProveedorAutomatica(File archivoProveedor, int codigoProveedor)
	{
		Proveedor proveedor = buscarProveedor(codigoProveedor);
		if (proveedor != null)
		{
			ProveedorDTO dto = ProveedorListaPreciosXML.leerArchivoListaPrecios("");
			Vector<ItemProveedor> items = new Vector<>();
			for (ItemProveedorDTO itemDTO : dto.getRodamientos())
			{
				Rodamiento rod = buscarRodamiento(itemDTO.getSKF());
				if (rod != null)
				{
					items.addElement(new ItemProveedor(itemDTO.getCodRodProv(), itemDTO.getPrecion(), itemDTO.getCondciones(), itemDTO.getDisponible(), rod));
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
	
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String tipo)
	{
		Proveedor proveedor = buscarProveedor(codigoProveedor);
		if (proveedor != null)
		{
			Rodamiento rod = buscarRodamiento(codigoSKF);
			if (rod != null)
			{
				proveedor.agregarItem(codigoItem, precio, condiciones, disponible, rod);
			}
		}
		
	}
}
