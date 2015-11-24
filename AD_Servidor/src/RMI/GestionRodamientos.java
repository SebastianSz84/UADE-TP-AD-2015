package RMI;

import interfaz.InterfazGestionRodamientos;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import Dao.ClienteDAO;
import Dao.CotizacionDAO;
import Dao.OVentaDAO;
import Dao.RodamientoDAO;
import Entities.Cliente;
import Entities.Cotizacion;
import Entities.OVenta;
import Entities.Rodamiento;
import Helper.CotizacionesXML;
import Server.ThreadCotizaciones;
import bean.CotizacionDTO;
import bean.ItemCotizacionWeb;
import bean.RodamientoDTO;

public class GestionRodamientos implements InterfazGestionRodamientos, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GestionRodamientos instancia;
	private List<OVenta> oventas = new Vector<OVenta>();
	private List<Rodamiento> rodamientos = new Vector<Rodamiento>();
	private List<RodamientoDTO> rodamientosDTO = new Vector<RodamientoDTO>();
	
	private GestionRodamientos()
	{
		ThreadCotizaciones thCot = new ThreadCotizaciones();
		thCot.start();
		
	}
	
	public List<RodamientoDTO> getListaRodamientos()
	{
		for (Rodamiento rodamiento : rodamientos)
		{
			rodamientosDTO.add(rodamiento.getDTO());
		}
		return rodamientosDTO;
	}
	
	public void solicitarCotizacion(int nroCliente, List<ItemCotizacionWeb> itemsCotLista)
	{
		Cliente cli = ClienteDAO.getCliente(nroCliente);
		if (cli != null)
		{
			Vector<Rodamiento> listaItems = new Vector<>();
			for (ItemCotizacionWeb itCotWeb : itemsCotLista)
			{
				Rodamiento rod = RodamientoDAO.getRodamiento(itCotWeb.getCodigoSKF());
				if (rod != null)
				{
					listaItems.add(rod);
				}
			}
			OVenta ov = buscarOV(cli.getOventa().getId());
			CotizacionesXML.generarXMLSolicitudCotizacion(listaItems, ov);
		}
	}
	
	public void grabarNuevaCotizacion()
	{
		
	}
	
	public void agregarItem()
	{
		
	}
	
	public void armarCotizacones()
	{
		oventas = OVentaDAO.getAll();
		for (OVenta ov : oventas)
		{
			File[] files = CotizacionesXML.obtenerXMLCotizacionParaArmar(ov);
			for (int i = 0; i < files.length; i++)
			{
				CotizacionDTO cotDTO = CotizacionesXML.leerXMLCotizacionParaArmar(files[i]);
				ov.generarCotizacion(cotDTO);
				
				files[i].delete();
			}
		}
	}
	
	private OVenta buscarOV(int idOVenta)
	{
		return OVentaDAO.getOVenta(idOVenta);
	}
	
	public void aceptarCotizacion(int nroCotizacion)
	{
		Cotizacion cot = CotizacionDAO.getCotizacion(nroCotizacion);
		if (cot != null)
		{
			CotizacionDTO cotDTO = cot.getDTO();
			OVenta ov = OVentaDAO.getOVenta(cotDTO.getIdOVenta());
			
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
			OVenta ov = OVentaDAO.getOVenta(cotDTO.getIdOVenta());
			ov.crearPedidoVenta(cot);
			files[i].delete();
		}
	}
	
	/*
	 * public XML leerXMLBultosAEnviar() { } public void borrarXMLPedidoCotizacion(XML xml) { } public void borrarXMLDeBultoAEnviar( XML xml) { }
	 */
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio)
	{
		
	}
	
	/*
	 * public listasXML generarOrdenesDeCompra() { }
	 */
	
	public void PublicarListaDePreciosFinal()
	{
		
	}
	
	/*
	 * public void generarListaDePrecioProveedorAutomatica( XML archivoProveedor, int codigoProveedor) { }
	 */
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String Tipo)
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
	
	public List<CotizacionDTO> getSolicitudesConformadasPorCliente(int nroCliente)
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
}