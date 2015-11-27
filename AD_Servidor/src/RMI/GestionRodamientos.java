package RMI;

import java.io.File;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Dao.ClienteDAO;
import Dao.CotizacionDAO;
import Dao.OVentaDAO;
import Dao.RodamientoDAO;
import Entities.Cliente;
import Entities.Cotizacion;
import Entities.ItemCotizacion;
import Entities.OVenta;
import Entities.Rodamiento;
import Helper.CotizacionesXML;
import Server.ThreadCotizaciones;
import bean.CotizacionDTO;
import bean.ItemCotizacionDTO;
import bean.RodamientoDTO;

public class GestionRodamientos implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GestionRodamientos instancia;
	private List<OVenta> oventas = new Vector<OVenta>();
	
	private GestionRodamientos()
	{
		ThreadCotizaciones thCot = new ThreadCotizaciones();
		thCot.start();
	}
	
	public List<RodamientoDTO> getListaRodamientos() throws RemoteException
	{
		List<RodamientoDTO> listaRodDTO = new ArrayList<>();
		for (Rodamiento rodamiento : RodamientoDAO.getListaRodamientos())
		{
			listaRodDTO.add(rodamiento.getDTO());
		}
		return listaRodDTO;
	}
	
	public void solicitarCotizacion(int nroCliente, List<ItemCotizacionDTO> itemsCotLista) throws RemoteException
	{
		Cliente cli = ClienteDAO.getCliente(nroCliente);
		if (cli != null)
		{
			OVenta ov = buscarOV(cli.getOventa().getId());
			Cotizacion cot = new Cotizacion();
			cot.setFecha(Calendar.getInstance().getTime());
			cot.setEstado("Pendiente");
			cot.setCliente(cli);
			List<ItemCotizacion> listaItems = new ArrayList<>();
			for (ItemCotizacionDTO itCotDTO : itemsCotLista)
			{
				{
					Rodamiento rod = RodamientoDAO.getRodamiento(itCotDTO.getRod().getCodigoSKF());
					if (rod != null)
					{
						ItemCotizacion itCot = new ItemCotizacion();
						itCot.setCantidad(itCotDTO.getCantidad());
						itCot.setRod(rod);
						listaItems.add(itCot);
					}
				}
			}
			cot.setItems(listaItems);
			CotizacionDAO.saveCotizacion(cot);
			CotizacionesXML.generarXMLSolicitudCotizacion(listaItems, ov);
		}
	}
	
	public void grabarNuevaCotizacion() throws RemoteException
	{
		
	}
	
	public void agregarItem() throws RemoteException
	{
		
	}
	
	public void armarCotizacones()
	{
		oventas = OVentaDAO.getAll();
		for (OVenta ov : oventas)
		{
			File[] files = CotizacionesXML.obtenerXMLCotizacionParaArmar(ov);
			if (files != null)
			{
				for (int i = 0; i < files.length; i++)
				{
					CotizacionDTO cotDTO = CotizacionesXML.leerXMLCotizacionParaArmar(files[i]);
					ov.generarCotizacion(cotDTO);
					
					files[i].delete();
				}
			}
		}
	}
	
	private OVenta buscarOV(int idOVenta)
	{
		return OVentaDAO.getOVenta(idOVenta);
	}
	
	public void aceptarCotizacion(int nroCotizacion) throws RemoteException
	{
		Cotizacion cot = CotizacionDAO.getCotizacion(nroCotizacion);
		if (cot != null)
		{
			CotizacionDTO cotDTO = cot.getDTO();
			OVenta ov = OVentaDAO.getOVenta(cotDTO.getCliente().getOVenta().getId());
			
			if (ov != null)
			{
				CotizacionesXML.generarXMLAceptarCotizacion(ov.aceptarCotizacion(cotDTO));
			}
		}
	}
	
	public void leerXMLCotAceptadas()
	{
		File[] files = CotizacionesXML.obtenerXMLCotizacionesAceptadas();
		for (int i = 0; i < files.length; i++)
		{
			CotizacionDTO cotDTO = CotizacionesXML.leerXMLCotizacionAceptada(files[i]);
			Cotizacion cot = CotizacionDAO.getCotizacion(cotDTO.getId());
			cot.actualizarDesdeDTO(cotDTO);
			OVenta ov = OVentaDAO.getOVenta(cotDTO.getCliente().getOVenta().getId());
			ov.crearPedidoVenta(cot);
			files[i].delete();
		}
	}
	
	/*
	 * public XML leerXMLBultosAEnviar() { } public void borrarXMLPedidoCotizacion(XML xml) { } public void borrarXMLDeBultoAEnviar( XML xml) { }
	 */
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio) throws RemoteException
	{
		
	}
	
	/*
	 * public listasXML generarOrdenesDeCompra() { }
	 */
	
	public void PublicarListaDePreciosFinal() throws RemoteException
	{
		
	}
	
	/*
	 * public void generarListaDePrecioProveedorAutomatica( XML archivoProveedor, int codigoProveedor) { }
	 */
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String Tipo) throws RemoteException
	{
		
	}
	
	public static GestionRodamientos getInstancia()
	{
		if (instancia == null)
		{
			instancia = new GestionRodamientos();
		}
		return instancia;
	}
	
	public static void setInstancia(GestionRodamientos instancia)
	{
		GestionRodamientos.instancia = instancia;
	}
	
	public List<CotizacionDTO> getSolicitudesConformadasPorCliente(int nroCliente) throws RemoteException
	{
		List<CotizacionDTO> cotizacionesDTO = new Vector<CotizacionDTO>();
		oventas = OVentaDAO.getAll();
		for (OVenta o : oventas)
		{
			List<Cotizacion> cotizaciones = o.listCotizacionesPorCliente(nroCliente);
			
			for (Cotizacion c : cotizaciones)
			{
				cotizacionesDTO.add(c.getDTO());
			}
		}
		
		return cotizacionesDTO;
		
	}
	
	public void leerXMLCotizacion() throws RemoteException
	{
		// TODO Auto-generated method stub
		
	}
	
	public void aceptarCotizacion() throws RemoteException
	{
		// TODO Auto-generated method stub
		
	}
	
	public boolean checkearSiClienteExiste(int nroCliente) throws RemoteException
	{
		oventas = OVentaDAO.getAll();
		boolean clienteExiste = false;
		for (OVenta ov : oventas)
		{
			Cliente cliente = ov.buscarCliente(nroCliente);
			if (cliente != null)
			{
				clienteExiste = true;
				break;
			}
		}
		return clienteExiste;
	}
}