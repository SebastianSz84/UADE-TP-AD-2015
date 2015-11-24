package RMI;

import interfaz.InterfazGestionRodamientos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bean.ItemCotizacionWeb;
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
	
	@Override
	public List<RodamientoDTO> getListaRodamientos() throws RemoteException
	{
		GestionRodamientos.getInstancia().getListaRodamientos();
		return null;
	}
	
	@Override
	public void solicitarCotizacion(int nroCliente, List<ItemCotizacionWeb> itemsCotLista) throws RemoteException
	{
		GestionRodamientos.getInstancia().solicitarCotizacion(nroCliente, itemsCotLista);
	}
	
	@Override
	public void grabarNuevaCotizacion() throws RemoteException
	{
		GestionRodamientos.getInstancia().grabarNuevaCotizacion();
	}
	
	@Override
	public void agregarItem() throws RemoteException
	{
		GestionRodamientos.getInstancia().agregarItem();
	}
	
	@Override
	public void leerXMLCotizacion() throws RemoteException
	{
		GestionRodamientos.getInstancia().leerXMLCotizacion();
	}
	
	@Override
	public void armarCotizacones() throws RemoteException
	{
		GestionRodamientos.getInstancia().armarCotizacones();
	}
	
	@Override
	public void aceptarCotizacion() throws RemoteException
	{
		GestionRodamientos.getInstancia().aceptarCotizacion();
	}
	
	@Override
	public void ActualizarStock(String codigoSKF, int cantidad, float precio) throws RemoteException
	{
		GestionRodamientos.getInstancia().ActualizarStock(codigoSKF, cantidad, precio);
	}
	
	@Override
	public void PublicarListaDePreciosFinal() throws RemoteException
	{
		
	}
	
	@Override
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String Tipo) throws RemoteException
	{
		GestionRodamientos.getInstancia().agregarItemAListaProveedor(codigoProveedor, codigoItem, precio, condiciones, disponible, codigoSKF, Tipo);
	}
}