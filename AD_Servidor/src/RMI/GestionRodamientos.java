package RMI;

import interfaz.InterfazGestionRodamientos;

import java.io.File;
import java.util.Vector;

import Dao.ClienteDAO;
import Dao.CotizacionDAO;
import Dao.OVentaDAO;
import Dao.RodamientoDAO;
import Entities.CCentral;
import Entities.Cliente;
import Entities.Cotizacion;
import Entities.OVenta;
import Entities.Rodamiento;
import Helper.CotizacionesXML;
import Server.ThreadCotizaciones;
import bean.ClienteDTO;
import bean.CotizacionDTO;
import bean.ItemCotizacionDTO;
import bean.PedVentaDTO;

public class GestionRodamientos implements InterfazGestionRodamientos
{
	private static GestionRodamientos instancia;
	
	private GestionRodamientos()
	{
		ThreadCotizaciones thCot = new ThreadCotizaciones();
		thCot.start();
	}
	
	public void getListaRodamientos()
	{
		
	}
	
	public void solicitarCotizacion(Vector<ItemCotizacionDTO> items)
	{
		Vector<Rodamiento> listaItems = new Vector<>();
		for (int i = 0; i < items.size(); i++)
		{
			Rodamiento rod = buscarRodamiento(items.elementAt(i).getRod().getId());
			if (rod != null)
			{
				listaItems.add(rod);
			}
		}
		CotizacionesXML.generarXMLSolicitudCotizacion(listaItems);
	}
	
	public void grabarNuevaCotizacion()
	{
		
	}
	
	private Rodamiento buscarRodamiento(int id)
	{
		return RodamientoDAO.getRodamiento(id);
	}
	
	public void agregarItem()
	{
		
	}
	
	public void armarCotizacones()
	{
		File[] files = CotizacionesXML.obtenerXMLCotizacionParaArmar();
		for (int i = 0; i < files.length; i++)
		{
			CotizacionDTO cotDTO = CotizacionesXML.leerXMLCotizacionParaArmar(files[i]);
			OVenta ov = OVentaDAO.getOVenta(cotDTO.getIdOVenta());
			
			ov.generarCotizacion(cotDTO);
			
			files[i].delete();
		}
	}
	
	public void buscarOV()
	{
		
	}
	
	public void aceptarCotizacion(CotizacionDTO cotDTO, ClienteDTO cliDTO)
	{
		Cliente cli = ClienteDAO.getCliente(cliDTO.getId());
		
		if (cli != null)
		{
			cli.aceptarCotizacion(cotDTO);
			CotizacionesXML.generarXMLCotizacion(cotDTO);
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
			PedVentaDTO pedVta = ov.crearPedidoVenta(cot);
			CCentral.getInstancia().crearOC(pedVta);
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