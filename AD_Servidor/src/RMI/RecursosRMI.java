package RMI;

import interfaz.InterfazGestionRodamientos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Entities.CCentral;
import bean.ClienteDTO;
import bean.FormaDePagoDTO;
import bean.ItemCotizacionDTO;
import bean.OVentaDTO;
import bean.ProveedorDTO;
import bean.RodamientoDTO;

public class RecursosRMI extends UnicastRemoteObject implements InterfazGestionRodamientos
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RecursosRMI() throws RemoteException
	{
		super();
	}
	
	public List<RodamientoDTO> getListaRodamientos() throws RemoteException
	{
		return GestionRodamientos.getInstancia().getListaRodamientos();
	}
	
	public boolean solicitarCotizacion(int nroCliente, List<ItemCotizacionDTO> itemsCotLista) throws RemoteException
	{
		return GestionRodamientos.getInstancia().solicitarCotizacion(nroCliente, itemsCotLista);
	}
	
	public void agregarItem() throws RemoteException
	{
		GestionRodamientos.getInstancia().agregarItem();
	}
	
	public void leerXMLCotizacion() throws RemoteException
	{
		GestionRodamientos.getInstancia().leerXMLCotizacion();
	}
	
	public void armarCotizacones() throws RemoteException
	{
		GestionRodamientos.getInstancia().armarCotizacones();
	}
	
	public boolean aceptarCotizacion(int idCotizacion) throws RemoteException
	{
		return GestionRodamientos.getInstancia().aceptarCotizacion(idCotizacion);
	}
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio) throws RemoteException
	{
		GestionRodamientos.getInstancia().ActualizarStock(codigoSKF, cantidad, precio);
	}
	
	public void PublicarListaDePreciosFinal() throws RemoteException
	{
		
	}
	
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String Tipo) throws RemoteException
	{
		GestionRodamientos.getInstancia().agregarItemAListaProveedor(codigoProveedor, codigoItem, precio, condiciones, disponible, codigoSKF, Tipo);
	}
	
	public boolean checkearSiClienteExiste(int nroCliente) throws RemoteException
	{
		return GestionRodamientos.getInstancia().checkearSiClienteExiste(nroCliente);
	}
	
	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor) throws RemoteException
	{
		CCentral.getInstancia().generarListaDePrecioProveedorAutomatica(archivoProveedor, codigoProveedor);
	}
	
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF) throws RemoteException
	{
		CCentral.getInstancia().agregarItemAListaProveedor(codigoProveedor, codigoItem, precio, condiciones, disponible, codigoSKF);
	}
	
	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad) throws RemoteException
	{
		return CCentral.getInstancia().GenerarBultosDeRodamiento(codigoSKF, cantidad);
	}
	
	public void altaProveedor(ProveedorDTO proveedorDTO) throws RemoteException
	{
		CCentral.getInstancia().altaProveedor(proveedorDTO);
	}
	
	public void bajaProveedor(int codigoProveedor) throws RemoteException
	{
		CCentral.getInstancia().bajaProveedor(codigoProveedor);
	}
	
	public void modificacionProveedor(ProveedorDTO proveedorDTO) throws RemoteException
	{
		CCentral.getInstancia().modificacionProveedor(proveedorDTO);
	}
	
	public void altaCliente(ClienteDTO clienteDTO) throws RemoteException
	{
		GestionRodamientos.getInstancia().altaCliente(clienteDTO);
	}
	
	public void bajaCliente(int codigoCliente) throws RemoteException
	{
		GestionRodamientos.getInstancia().bajaCliente(codigoCliente);
	}
	
	public void modificacionCliente(ClienteDTO clienteDTO) throws RemoteException
	{
		GestionRodamientos.getInstancia().modificacionCliente(clienteDTO);
	}
	
	public OVentaDTO getOV(int id)
	{
		return GestionRodamientos.getInstancia().getOVentaDTO(id);
	}
	
	public ClienteDTO getClienteDTO(int id)
	{
		return GestionRodamientos.getInstancia().getClienteDTO(id);
	}
	
	public FormaDePagoDTO getForma(int id) throws RemoteException
	{
		return GestionRodamientos.getInstancia().getForma(id);
	}
	
}