package RMI;

import java.io.File;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Dao.ClienteDAO;
import Dao.ComparativaPreciosDAO;
import Dao.CotizacionDAO;
import Dao.OVentaDAO;
import Dao.RodamientoDAO;
import Entities.CCentral;
import Entities.Cliente;
import Entities.Cotizacion;
import Entities.ItemCotizacion;
import Entities.OVenta;
import Entities.Rodamiento;
import Helper.CotizacionesXML;
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
	private CCentral casaCentral;
	
	private GestionRodamientos()
	{
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
	
	public boolean solicitarCotizacion(int nroCliente, List<ItemCotizacionDTO> itemsCotLista) throws RemoteException
	{
		Cliente cli = ClienteDAO.getCliente(nroCliente);
		if (cli != null)
		{
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
						itCot.setItProveedor(ComparativaPreciosDAO.getComparativa().getItemSKF(rod.getCodigoSKF()));
						itCot.setCot(cot);
						listaItems.add(itCot);
					}
				}
			}
			cot.setItems(listaItems);
			return CotizacionesXML.generarXMLSolicitudCotizacion(CotizacionDAO.saveCotizacion(cot));
		}
		return false;
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
	
	public boolean aceptarCotizacion(int nroCotizacion) throws RemoteException
	{
		Cotizacion cot = CotizacionDAO.getCotizacion(nroCotizacion);
		if (cot != null)
		{
			OVenta ov = OVentaDAO.getOVenta(cot.getCliente().getOVenta().getId());
			
			if (ov != null)
			{
				return CotizacionesXML.generarXMLAceptarCotizacion(ov.aceptarCotizacion(cot));
			}
		}
		return false;
	}
	
	public void leerXMLCotAceptadas()
	{
		File[] files = CotizacionesXML.obtenerXMLCotizacionesAceptadas();
		for (int i = 0; i < files.length; i++)
		{
			CotizacionDTO cotDTO = CotizacionesXML.leerXMLCotizacionAceptada(files[i]);
			if (cotDTO != null)
			{
				Cotizacion cot = CotizacionDAO.getCotizacion(cotDTO.getId());
				OVenta ov = OVentaDAO.getOVenta(cot.getCliente().getOVenta().getId());
				if (ov != null)
				{
					ov.crearPedidoVenta(cot);
					files[i].delete();
				}
			}
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
	
	public boolean checkearSiClienteExiste(int nroCliente) throws RemoteException
	{
		Cliente cliente = ClienteDAO.getCliente(nroCliente);
		return cliente != null;
	}
}