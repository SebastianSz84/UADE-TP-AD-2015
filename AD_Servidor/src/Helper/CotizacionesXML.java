package Helper;

import java.io.File;
import java.util.Calendar;
import java.util.List;

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

import Dao.ClienteDAO;
import Dao.RodamientoDAO;
import Entities.Cotizacion;
import Entities.ItemCotizacion;
import Entities.OVenta;
import bean.CotizacionDTO;
import bean.ItemCotizacionDTO;
import bean.RodamientoDTO;

public class CotizacionesXML
{
	private static String root = "src\\xmls\\OV\\";
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
			attribute.setValue(Integer.toString(cot.getCliente().getOventa().getId()));
			raiz.setAttributeNode(attribute);
			
			for (ItemCotizacion itCot : cot.getItems())
			{
				Element item = xmlDoc.createElement("item");
				
				attribute = xmlDoc.createAttribute("cantidad");
				attribute.setValue(Integer.toString(itCot.getCantidad()));
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("idRod");
				attribute.setValue(itCot.getRod().getCodigoSKF());
				item.setAttributeNode(attribute);
				
				raiz.appendChild(item);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			long timestamp = Calendar.getInstance().getTimeInMillis();
			StreamResult result = new StreamResult(new File(root + Integer.toString(cot.getCliente().getOventa().getId()) + armadas, Long.toString(timestamp) + ".xml"));
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
				attribute = attrs.getNamedItem("idCliente");
				int idCliente = Integer.valueOf(attribute.getNodeValue());
				
				CotizacionDTO cotDTO = new CotizacionDTO();
				cotDTO.setEstado(estado);
				cotDTO.setCliente(ClienteDAO.getCliente(idCliente).getDTO());
				for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
				{
					if ("item".equalsIgnoreCase(d.getNodeName()))
					{
						attrs = d.getAttributes();
						int cantidad = Integer.valueOf(attrs.getNamedItem("cantidad").getNodeValue());
						RodamientoDTO rodDTO = RodamientoDAO.getRodamiento(attrs.getNamedItem("idRod").getNodeValue()).getDTO();
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
	
	public static File[] obtenerXMLCotizacionParaArmar(OVenta ov)
	{
		try
		{
			File dir = new File(root + Integer.toString(ov.getId()), paraArmar);
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
	
	public static void generarXMLSolicitudCotizacion(List<ItemCotizacion> listaItems, OVenta ov)
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
			
			for (ItemCotizacion itCot : listaItems)
			{
				Element item = xmlDoc.createElement("item");
				
				attribute = xmlDoc.createAttribute("cantidad");
				attribute.setValue(Integer.toString(itCot.getCantidad()));
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("idRod");
				attribute.setValue(itCot.getRod().getCodigoSKF());
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("precio");
				attribute.setValue("0");
				item.setAttributeNode(attribute);
				
				raiz.appendChild(item);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			long timestamp = Calendar.getInstance().getTimeInMillis();
			StreamResult result = new StreamResult(new File(root + Integer.toString(ov.getId()) + paraArmar, Float.toString(timestamp) + ".xml"));
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
				attribute = attrs.getNamedItem("idCliente");
				int idCliente = Integer.valueOf(attribute.getNodeValue());
				
				CotizacionDTO cotDTO = new CotizacionDTO();
				cotDTO.setEstado(estado);
				cotDTO.setCliente(ClienteDAO.getCliente(idCliente).getDTO());
				for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
				{
					if ("item".equalsIgnoreCase(d.getNodeName()))
					{
						attrs = d.getAttributes();
						int cantidad = Integer.valueOf(attrs.getNamedItem("cantidad").getNodeValue());
						RodamientoDTO rodDTO = RodamientoDAO.getRodamiento(attrs.getNamedItem("idRod").getNodeValue()).getDTO();
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
			attribute.setValue(cotDTO.getEstado());
			raiz.setAttributeNode(attribute);
			
			attribute = xmlDoc.createAttribute("idOVenta");
			attribute.setValue(Integer.toString(cotDTO.getCliente().getOVenta().getId()));
			raiz.setAttributeNode(attribute);
			
			for (ItemCotizacionDTO itCot : cotDTO.getItems())
			{
				Element item = xmlDoc.createElement("item");
				
				attribute = xmlDoc.createAttribute("cantidad");
				attribute.setValue(Integer.toString(itCot.getCantidad()));
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("idRod");
				attribute.setValue(itCot.getRod().getCodigoSKF());
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("precio");
				attribute.setValue(Float.toString(itCot.getPrecio()));
				item.setAttributeNode(attribute);
				
				raiz.appendChild(item);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			long timestamp = Calendar.getInstance().getTimeInMillis();
			StreamResult result = new StreamResult(new File(root + Integer.toString(cotDTO.getCliente().getOVenta().getId()) + aceptadas, Long.toString(timestamp) + ".xml"));
			transformer.transform(source, result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}