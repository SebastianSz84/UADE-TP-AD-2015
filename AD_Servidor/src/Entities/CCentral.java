package Entities;

import java.io.File;
import java.util.Vector;

import Dao.OCProveedorDAO;
import Dao.ProveedorDAO;
import Dao.RodamientoDAO;
import bean.PedVentaDTO;

public class CCentral
{
	private static CCentral instancia;
	
	private Vector<Proveedor> proveedores;
	private Vector<Bulto> bultos;
	private Vector<OCProveedor> ordenesCompra;
	private Vector<Rodamiento> rodamientos;
	
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
	}
	
	private Rodamiento buscarRodamiento(String codigoSKF)
	{
		return null;
	}
	
	/*
	 * public void GenerarBultosDeRodamiento( ListasRemitos remitosOV, ListaRodamientos rodamientosComprados) { } public listasXML generarOrdenesDeCompra( PedVenta pedidos) { }
	 */
	
	public void PublicarListaDePreciosFinal()
	{
		for (Rodamiento rod : rodamientos)
		{
			ItemProveedor menorPrecio = null;
			for (Proveedor prov : proveedores)
			{
				ItemProveedor itemProv = prov.getItemProveedor(rod);
				if (itemProv != null && (menorPrecio == null || menorPrecio.getPrecio() < itemProv.getPrecio()))
				{
					menorPrecio = itemProv;
				}
			}
			
			if (menorPrecio != null)
			{
				ComparativaPrecios.getInstancia().ActualizarPrecio(proveedor, menorPrecio);
			}
		}
	}
	
	public void generarListaDePrecioProveedorAutomatica(File archivoProveedor, int codigoProveedor)
	{
	
	}
	
	public Proveedor buscarProveedor(int codigoProveedor)
	{
		
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
	
	public Vector<Proveedor> getProveedores()
	{
		return proveedores;
	}
	
	public void setProveedores(Vector<Proveedor> proveedores)
	{
		this.proveedores = proveedores;
	}
	
	public Vector<Bulto> getBultos()
	{
		return bultos;
	}
	
	public void setBultos(Vector<Bulto> bultos)
	{
		this.bultos = bultos;
	}
}