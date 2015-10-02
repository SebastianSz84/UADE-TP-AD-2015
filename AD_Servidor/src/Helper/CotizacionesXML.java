package Helper;

import java.io.File;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import Dao.RodamientoDAO;
import Entities.Rodamiento;
import bean.CotizacionDTO;
import bean.RodamientoDTO;

public class CotizacionesXML
{
	private static String root = "C:\\cotizaciones";
	private static String paraArmar = "\\paraArmar";
	private static String aceptadas = "\\aceptadas";
	
	public static void generarXMLCotizacion(Object cot)
	{
		// TODO Agregar código para generar XML desde DTO de Cotizacion
	}
	
	public static CotizacionDTO leerXMLCotizacionParaArmar(File file)
	{
		try
		{
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			dbf.setValidating(false);
			dbf.setIgnoringComments(true);
			final DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlDoc = db.parse(file);
			Node n = xmlDoc.getFirstChild();
			if ("cotizacion".equalsIgnoreCase(n.getNodeName()))
			{
				NamedNodeMap attrs = n.getAttributes();
				Node attribute = attrs.getNamedItem("estado");
				String estado = attribute.getNodeValue();
				attribute = attrs.getNamedItem("idOVenta");
				int idOVenta = Integer.valueOf(attribute.getNodeValue());
				
				CotizacionDTO cotDTO = new CotizacionDTO();
				cotDTO.setEstado(estado);
				cotDTO.setIdOVenta(idOVenta);
				for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
				{
					if ("item".equalsIgnoreCase(d.getNodeName()))
					{
						attrs = d.getAttributes();
						int cantidad = Integer.valueOf(attrs.getNamedItem("cantidad").getNodeValue());
						RodamientoDTO rodDTO = RodamientoDAO.getRodamiento(Integer.valueOf(attrs.getNamedItem("cod").getNodeValue())).getDTO();
						float precio = Float.valueOf(attrs.getNamedItem("precio").getNodeValue());
						cotDTO.agregarItem(cantidad, rodDTO, precio);
					}
				}
				return cotDTO;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static File[] obtenerXMLCotizacionParaArmar()
	{
		try
		{
			File dir = new File(root, paraArmar);
			return dir.listFiles(new XMLFilter());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void generarXMLSolicitudCotizacion(Vector<Rodamiento> listaItems)
	{
		// TODO Agregar código para generar XML lista de Rodamientos
	}
	
	public static File[] obtenerXMLCotizacionesAceptadas()
	{
		try
		{
			File dir = new File(root, aceptadas);
			return dir.listFiles(new XMLFilter());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static CotizacionDTO leerXMLCotizacionAceptada(File file)
	{
		try
		{
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			dbf.setValidating(false);
			dbf.setIgnoringComments(true);
			final DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlDoc = db.parse(file);
			Node n = xmlDoc.getFirstChild();
			if ("cotizacion".equalsIgnoreCase(n.getNodeName()))
			{
				NamedNodeMap attrs = n.getAttributes();
				Node attribute = attrs.getNamedItem("estado");
				String estado = attribute.getNodeValue();
				attribute = attrs.getNamedItem("idOVenta");
				int idOVenta = Integer.valueOf(attribute.getNodeValue());
				
				CotizacionDTO cotDTO = new CotizacionDTO();
				cotDTO.setEstado(estado);
				cotDTO.setIdOVenta(idOVenta);
				for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
				{
					if ("item".equalsIgnoreCase(d.getNodeName()))
					{
						attrs = d.getAttributes();
						int cantidad = Integer.valueOf(attrs.getNamedItem("cantidad").getNodeValue());
						RodamientoDTO rodDTO = RodamientoDAO.getRodamiento(Integer.valueOf(attrs.getNamedItem("cod").getNodeValue())).getDTO();
						float precio = Float.valueOf(attrs.getNamedItem("precio").getNodeValue());
						cotDTO.agregarItem(cantidad, rodDTO, precio);
					}
				}
				return cotDTO;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}