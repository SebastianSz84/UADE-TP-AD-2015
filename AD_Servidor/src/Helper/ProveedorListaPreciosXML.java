package Helper;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import bean.ProveedorDTO;

public class ProveedorListaPreciosXML
{
	private static String root = ".";
	
	public static ProveedorDTO leerArchivoListaPrecios(String path)
	{
		try
		{
			File file = new File(root, path);
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			dbf.setValidating(false);
			dbf.setIgnoringComments(true);
			final DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlDoc = db.parse(file);
			Node n = xmlDoc.getFirstChild();
			if ("proveedor".equalsIgnoreCase(n.getNodeName()))
			{
				NamedNodeMap attrs = n.getAttributes();
				Node attribute = attrs.getNamedItem("codigo");
				int codigo = Integer.valueOf(attribute.getNodeValue());
				
				ProveedorDTO proveedorDTO = new ProveedorDTO();
				proveedorDTO.setCodigoProveedor(codigo);
				for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
				{
					if ("item".equalsIgnoreCase(d.getNodeName()))
					{
						attrs = d.getAttributes();
						String skf = attrs.getNamedItem("skf").getNodeValue();
						String codRodProv = attrs.getNamedItem("cod").getNodeValue();
						boolean disponible = Boolean.parseBoolean(attrs.getNamedItem("disp").getNodeValue());
						float precio = Float.valueOf(attrs.getNamedItem("precio").getNodeValue());
						String condiciones = attrs.getNamedItem("cond").getNodeValue();
						proveedorDTO.agregarItem(skf, codRodProv, precio, disponible, condiciones);
					}
				}
				return proveedorDTO;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}