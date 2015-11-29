package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import bean.ClienteDTO;
import bean.FormaDePagoDTO;
import bean.ItemCotizacionDTO;
import bean.ItemProveedorDTO;
import bean.OVentaDTO;
import bean.ProveedorDTO;
import bean.RodamientoDTO;

public interface InterfazGestionRodamientos extends Remote
{
	public static final String url = "localhost/RecursosRMI";
	
	public List<RodamientoDTO> getListaRodamientos() throws RemoteException;
	
	public boolean solicitarCotizacion(int nroCliente, List<ItemCotizacionDTO> itemsCotLista, boolean aceptada) throws RemoteException;
	
	public void armarCotizacones() throws RemoteException;
	
	public String aceptarCotizacion(int idCotizacion) throws RemoteException;
	
	public boolean checkearSiClienteExiste(int nroCliente) throws RemoteException;
	
	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor) throws RemoteException;
	
	public void agregarItemAListaProveedor(ItemProveedorDTO itemProveedorDTO) throws RemoteException;
	
	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad) throws RemoteException;
	
	public void CerrarBultosDeRodamiento() throws RemoteException;
	
	public void altaProveedor(ProveedorDTO proveedorDTO) throws RemoteException;
	
	public void bajaProveedor(int codigoProveedor) throws RemoteException;
	
	public void modificacionProveedor(ProveedorDTO proveedorDTO) throws RemoteException;
	
	public void altaCliente(ClienteDTO clienteDTO) throws RemoteException;
	
	public void bajaCliente(int oVenta) throws RemoteException;
	
	public void modificacionCliente(ClienteDTO clienteDTO) throws RemoteException;
	
	public OVentaDTO getOV(int id) throws RemoteException;
	
	public FormaDePagoDTO getForma(int id) throws RemoteException;
	
	public RodamientoDTO getRodamiento(String codigoSKF) throws RemoteException;
	
	public boolean altaRodamiento(RodamientoDTO rodDTO) throws RemoteException;
	
	public ClienteDTO getClienteDTO(int id) throws RemoteException;
	
	public boolean modificarRodamiento(RodamientoDTO rodDTO) throws RemoteException;
	
	public boolean bajaRodamiento(String codigoSKF) throws RemoteException;
	
	public boolean existenCotAbiertasXRod(String codigoSKF) throws RemoteException;
	
	public ProveedorDTO getProveedorDTO(int id) throws RemoteException;
}
