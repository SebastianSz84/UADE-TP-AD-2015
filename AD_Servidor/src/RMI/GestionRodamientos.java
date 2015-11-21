package RMI;

import interfaz.InterfazGestionRodamientos;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Dao.CotizacionDAO;
import Dao.OVentaDAO;
import Dao.RodamientoDAO;
import Entities.Cotizacion;
import Entities.OVenta;
import Entities.Rodamiento;
import Helper.CotizacionesXML;
import Server.ThreadCotizaciones;
import bean.CotizacionDTO;
import bean.ItemCotizacionDTO;
import bean.OVentaDTO;
import bean.RodamientoDTO;

public class GestionRodamientos implements InterfazGestionRodamientos, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GestionRodamientos instancia;
	private List<OVenta> oventas;
	
	private GestionRodamientos()
	{
		ThreadCotizaciones thCot = new ThreadCotizaciones();
		thCot.start();
	}
	
	public List<RodamientoDTO> getListaRodamientos()
	{
		List<RodamientoDTO> listaRods = new ArrayList<>();
		RodamientoDTO rodDTO = new RodamientoDTO();
		rodDTO.setTipo("tipo1");
		rodDTO.setCodigoSKF("codigoSKF");
		listaRods.add(rodDTO);
		return listaRods;
	}
	
	public void solicitarCotizacion(Vector<ItemCotizacionDTO> items, OVentaDTO ovDTO)
	{
		Vector<Rodamiento> listaItems = new Vector<>();
		for (ItemCotizacionDTO itCotDTO : items)
		{
			Rodamiento rod = RodamientoDAO.getRodamiento(itCotDTO.getRod().getCodigoSKF());
			if (rod != null)
			{
				listaItems.add(rod);
			}
		}
		OVenta ov = buscarOV(ovDTO.getId());
		CotizacionesXML.generarXMLSolicitudCotizacion(listaItems, ov);
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
	
	public void aceptarCotizacion(CotizacionDTO cotDTO)
	{
		OVenta ov = OVentaDAO.getOVenta(cotDTO.getIdOVenta());
		
		if (ov != null)
		{
			CotizacionesXML.generarXMLAceptarCotizacion(ov.aceptarCotizacion(cotDTO));
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
}