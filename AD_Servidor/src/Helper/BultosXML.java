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

import Entities.Bulto;
import Entities.ItemBulto;

public class BultosXML
{
	private static String root = "src\\xmls\\OV\\";
	private static String bultos = "\\bultos";
	
	public static void GenerarXMLBultos(List<Bulto> bults)
	{
		try
		{
			for (Bulto bul : bults)
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
				attribute.setValue(Integer.toString(bul.getId()));
				raiz.setAttributeNode(attribute);
				
				for (ItemBulto itemBul : bul.getItems())
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
				StreamResult result = new StreamResult(new File(root + Integer.toString(bul.getOficinaDeVenta().getId()) + bultos, Long.toString(timestamp) + ".xml"));
				transformer.transform(source, result);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
