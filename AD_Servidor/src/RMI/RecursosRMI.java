package RMI;

import interfaz.InterfazGestionRodamientos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Controllers.CCentral;
import Controllers.GestionRodamientos;
import bean.ClienteDTO;
import bean.FormaDePagoDTO;
import bean.ItemCotizacionDTO;
import bean.ItemProveedorDTO;
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
	
	public boolean solicitarCotizacion(int nroCliente, List<ItemCotizacionDTO> itemsCotLista, boolean aceptada) throws RemoteException
	{
		return GestionRodamientos.getInstancia().solicitarCotizacion(nroCliente, itemsCotLista, aceptada);
	}
	
	public void armarCotizacones() throws RemoteException
	{
		GestionRodamientos.getInstancia().armarCotizacones();
	}
	
	public String aceptarCotizacion(int idCotizacion) throws RemoteException
	{
		return GestionRodamientos.getInstancia().aceptarCotizacion(idCotizacion);
	}
	
	public boolean checkearSiClienteExiste(int nroCliente) throws RemoteException
	{
		return GestionRodamientos.getInstancia().checkearSiClienteExiste(nroCliente);
	}
	
	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor) throws RemoteException
	{
		CCentral.getInstancia().generarListaDePrecioProveedorAutomatica(archivoProveedor, codigoProveedor);
	}
	
	public void agregarItemAListaProveedor(ItemProveedorDTO itemProveedorDTO) throws RemoteException
	{
		CCentral.getInstancia().agregarItemAListaProveedor(itemProveedorDTO);
	}
	
	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad) throws RemoteException
	{
		return CCentral.getInstancia().GenerarBultosDeRodamiento(codigoSKF, cantidad);
	}
	
	public void CerrarBultosDeRodamiento() throws RemoteException
	{
		CCentral.getInstancia().CerrarBultosDeRodamiento();
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
	
	public RodamientoDTO getRodamiento(String codigoSKF) throws RemoteException
	{
		return GestionRodamientos.getInstancia().getRodamiento(codigoSKF);
	}
	
	public boolean altaRodamiento(RodamientoDTO rodDTO) throws RemoteException
	{
		return GestionRodamientos.getInstancia().altaRodamiento(rodDTO);
	}
	
	public boolean modificarRodamiento(RodamientoDTO rodDTO) throws RemoteException
	{
		return GestionRodamientos.getInstancia().modificarRodamiento(rodDTO);
	}
	
	public boolean bajaRodamiento(String codigoSKF) throws RemoteException
	{
		return GestionRodamientos.getInstancia().bajaRodamiento(codigoSKF);
	}
	
	public boolean existenCotAbiertasXRod(String codigoSKF) throws RemoteException
	{
		return GestionRodamientos.getInstancia().existenCotAbiertasXRod(codigoSKF);
	}
	
	public ProveedorDTO getProveedorDTO(int id) throws RemoteException
	{
		return CCentral.getInstancia().getProveedorDTO(id);
	}
}