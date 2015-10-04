package Helper;

import java.io.File;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import Dao.RodamientoDAO;
import Entities.Cotizacion;
import Entities.ItemCotizacion;
import Entities.OVenta;
import Entities.Rodamiento;
import bean.CotizacionDTO;
import bean.RodamientoDTO;

public class CotizacionesXML
{
	private static String root = "C:\\gestionRodamientos\\cotizaciones";
	private static String paraArmar = "\\paraArmar";
	private static String armadas = "\\armadas";
	private static String aceptadas = "\\aceptadas";
	
	public static void generarXMLArmarCotizacion(Cotizacion cot)
	{
		try
		{
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			dbf.setValidating(false);
			dbf.setIgnoringComments(true);
			final DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlDoc = db.newDocument();
			
			Element raiz = xmlDoc.createElement("Cotizacion");
			xmlDoc.appendChild(raiz);
			
			Attr attribute = xmlDoc.createAttribute("estado");
			attribute.setValue(cot.getEstado());
			raiz.setAttributeNode(attribute);
			
			attribute = xmlDoc.createAttribute("idOVenta");
			attribute.setValue(Integer.toString(cot.getOventa().getId()));
			raiz.setAttributeNode(attribute);
			
			for (ItemCotizacion itCot : cot.getItems())
			{
				Element item = xmlDoc.createElement("item");
				
				attribute = xmlDoc.createAttribute("cantidad");
				attribute.setValue(Integer.toString(itCot.getCantidad()));
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("idRod");
				attribute.setValue(Integer.toString(itCot.getRod().getId()));
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("precio");
				attribute.setValue(Float.toString(itCot.getPrecio()));
				item.setAttributeNode(attribute);
				
				raiz.appendChild(item);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			File[] files = obtenerXMLCotizacionArmadas();
			int cantArmadas = 0;
			if (files != null)
			{
				cantArmadas = obtenerXMLCotizacionArmadas().length;
			}
			StreamResult result = new StreamResult(new File(root + armadas, Integer.toString(cantArmadas) + ".xml"));
			transformer.transform(source, result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
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
						RodamientoDTO rodDTO = RodamientoDAO.getRodamiento(Integer.valueOf(attrs.getNamedItem("idRod").getNodeValue())).getDTO();
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
	
	public static File[] obtenerXMLCotizacionArmadas()
	{
		try
		{
			File dir = new File(root, armadas);
			return dir.listFiles(new XMLFilter());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void generarXMLSolicitudCotizacion(Vector<Rodamiento> listaItems, OVenta ov)
	{
		try
		{
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			dbf.setValidating(false);
			dbf.setIgnoringComments(true);
			final DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlDoc = db.newDocument();
			
			Element raiz = xmlDoc.createElement("Cotizacion");
			xmlDoc.appendChild(raiz);
			
			Attr attribute = xmlDoc.createAttribute("estado");
			attribute.setValue("nueva");
			raiz.setAttributeNode(attribute);
			
			attribute = xmlDoc.createAttribute("idOVenta");
			attribute.setValue(Integer.toString(ov.getId()));
			raiz.setAttributeNode(attribute);
			
			for (Rodamiento rod : listaItems)
			{
				Element item = xmlDoc.createElement("item");
				
				attribute = xmlDoc.createAttribute("cantidad");
				attribute.setValue("0");
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("idRod");
				attribute.setValue(Integer.toString(rod.getId()));
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("precio");
				attribute.setValue("0");
				item.setAttributeNode(attribute);
				
				raiz.appendChild(item);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			
			File[] files = obtenerXMLCotizacionArmadas();
			int cantParaArmar = 0;
			if (files != null)
			{
				cantParaArmar = obtenerXMLCotizacionArmadas().length;
			}
			
			StreamResult result = new StreamResult(new File(root + paraArmar, Integer.toString(cantParaArmar) + ".xml"));
			transformer.transform(source, result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
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
						RodamientoDTO rodDTO = RodamientoDAO.getRodamiento(Integer.valueOf(attrs.getNamedItem("idRod").getNodeValue())).getDTO();
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
	
	public static void generarXMLAceptarCotizacion(CotizacionDTO cotDTO)
	{
		
	}
}