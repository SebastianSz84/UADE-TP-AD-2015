package Helper;

import java.io.File;
import java.util.Calendar;
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
import Entities.Bulto;
import Entities.ItemBulto;
import Entities.OVenta;
import bean.BultoDTO;
import bean.ItemBultoDTO;

public class BultosXML
{
	private static String root = "src\\xmls\\OV\\";
	private static String bultos = "\\bultos";
	
	public static void GenerarXMLBulto(Bulto bulto)
	{
		try
		{
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			dbf.setValidating(false);
			dbf.setIgnoringComments(true);
			final DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlDoc = db.newDocument();
			
			Element raiz = xmlDoc.createElement("Bulto");
			xmlDoc.appendChild(raiz);
			
			Attr attribute = xmlDoc.createAttribute("Id");
			attribute.setValue(Integer.toString(bulto.getId()));
			raiz.setAttributeNode(attribute);
			
			for (ItemBulto itemBul : bulto.getItems())
			{
				Element item = xmlDoc.createElement("item");
				
				attribute = xmlDoc.createAttribute("cantidad");
				attribute.setValue(Integer.toString(itemBul.getCantidad()));
				item.setAttributeNode(attribute);
				
				attribute = xmlDoc.createAttribute("CodigoSKF");
				attribute.setValue(itemBul.getRodamiento().getCodigoSKF());
				item.setAttributeNode(attribute);
				
				raiz.appendChild(item);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			long timestamp = Calendar.getInstance().getTimeInMillis();
			StreamResult result = new StreamResult(new File(root + Integer.toString(bulto.getOficinaDeVenta().getId()) + bultos, Long.toString(timestamp) + ".xml"));
			transformer.transform(source, result);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static BultoDTO leerXMLBulto(File file)
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
			if ("bulto".equalsIgnoreCase(n.getNodeName()))
			{
				NamedNodeMap attrs = n.getAttributes();
				Node attribute = attrs.getNamedItem("Id");
				int idBulto = Integer.parseInt(attribute.getNodeValue());
				
				BultoDTO bultoDTO = new BultoDTO();
				bultoDTO.setId(idBulto);
				
				Vector<ItemBultoDTO> itemsDTO = new Vector<ItemBultoDTO>();
				
				for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
				{
					if ("item".equalsIgnoreCase(d.getNodeName()))
					{
						attrs = d.getAttributes();
						int cantidad = Integer.valueOf(attrs.getNamedItem("cantidad").getNodeValue());
						String codigoSKF = String.valueOf(attrs.getNamedItem("CodigoSKF").getNodeValue());
						
						ItemBultoDTO itemDTO = new ItemBultoDTO();
						itemDTO.setCantidad(cantidad);
						itemDTO.setRodamiento(RodamientoDAO.getRodamiento(codigoSKF).getDTO());
						
						itemsDTO.add(itemDTO);
						
					}
				}
				bultoDTO.setItems(itemsDTO);
				
				return bultoDTO;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static File[] obtenerXMLBultos(OVenta ov)
	{
		try
		{
			File dir = new File(root + Integer.toString(ov.getId()), bultos);
			return dir.listFiles(new XMLFilter());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
