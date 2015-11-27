import org.junit.Test;

import Dao.CotizacionDAO;
import Helper.CotizacionesXML;

public class AD_XML_Cotizaciones_Test
{
	
	@Test
	public void testXMLCotizaciones()
	{
		CotizacionesXML.generarXMLArmarCotizacion(CotizacionDAO.getCotizacion(1));
		
		// for (int j = 1; j < 3; j++)
		// {
		// Cotizacion cot = new Cotizacion();
		// cot.setEstado("nueva");
		//
		// OVenta ov = new OVenta();
		// ov.setDireccion("Calle falsa 123");
		// ov.setNombre("OV de Prueba");
		// ov.setId(j);
		//
		// Proveedor pr = new Proveedor();
		// pr.setCodigoProveedor(1);
		//
		// Vector<ItemCotizacion> items = new Vector<>();
		//
		// for (int i = 1; i < 4; i++)
		// {
		// ItemCotizacion itCot = new ItemCotizacion();
		//
		// itCot.setCantidad(i * 3);
		// itCot.setId(i);
		// itCot.setProveedor(pr);
		//
		// Rodamiento r = new Rodamiento();
		// r.setCodigoSKF("abc1");
		//
		// itCot.setRod(r);
		//
		// items.add(itCot);
		// }
		//
		// cot.setItems(items);
		// CotizacionesXML.generarXMLArmarCotizacion(cot);
		// }
	}
}