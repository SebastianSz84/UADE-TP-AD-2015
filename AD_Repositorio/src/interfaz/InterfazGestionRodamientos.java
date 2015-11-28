package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import bean.ItemCotizacionDTO;
import bean.ProveedorDTO;
import bean.RodamientoDTO;

public interface InterfazGestionRodamientos extends Remote
{
	
	public static final String url = "localhost/RecursosRMI";
	
	public List<RodamientoDTO> getListaRodamientos() throws RemoteException;
	
	public boolean solicitarCotizacion(int nroCliente, List<ItemCotizacionDTO> itemsCotLista) throws RemoteException;
	
	public void grabarNuevaCotizacion() throws RemoteException;
	
	public void agregarItem() throws RemoteException;
	
	public void leerXMLCotizacion() throws RemoteException;
	
	public void armarCotizacones() throws RemoteException;
	
	public boolean aceptarCotizacion(int idCotizacion) throws RemoteException;
	
	// public XML leerXMLCotAceptadas();
	
	// public XML leerXMLBultosAEnviar();
	
	// public void borrarXMLPedidoCotizacion(XML xml);
	
	// public void borrarXMLDeBultoAEnviar(XML xml);
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio) throws RemoteException;
	
	// public listasXML generarOrdenesDeCompra();
	
	public void PublicarListaDePreciosFinal() throws RemoteException;
	
	// public void generarListaDePrecioProveedorAutomatica(XML archivoProveedor, int codigoProveedor);
	
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String Tipo) throws RemoteException;
	
	public boolean checkearSiClienteExiste(int nroCliente) throws RemoteException;
	
	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor) throws RemoteException;
	
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF) throws RemoteException;
	
	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad) throws RemoteException;
	
	public void altaProveedor(ProveedorDTO proveedorDTO);
	
	public void bajaProveedor(int codigoProveedor);
	
	public void modificacionProveedor(ProveedorDTO proveedorDTO);
}
