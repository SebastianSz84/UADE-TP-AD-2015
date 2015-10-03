package Helper;

import java.io.File;
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

import Entities.OCProveedor;

public class OCProveedorXML
{
	
	public static void GenerarXMLOrdenesDeCompra(List<OCProveedor> ordenesCompra)
	{
		
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("OCProveedor");
			doc.appendChild(rootElement);
			Element orden = doc.createElement("orden");
			rootElement.appendChild(orden);
			Attr attr = doc.createAttribute("codigo");
			attr.setValue("Test");
			orden.setAttributeNode(attr);
			Element item = doc.createElement("item");
			Attr attrCant = doc.createAttribute("cantidad");
			attrCant.setValue("55");
			item.setAttributeNode(attrCant);
			Attr attrSKFRod = doc.createAttribute("skf");
			attrSKFRod.setValue("skf");
			item.setAttributeNode(attrSKFRod);
			orden.appendChild(item);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\OCProveedor.xml"));
			transformer.transform(source, result);
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
