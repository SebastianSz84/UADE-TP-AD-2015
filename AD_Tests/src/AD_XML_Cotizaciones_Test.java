import java.util.Vector;

import org.junit.Test;

import Entities.Cotizacion;
import Entities.ItemCotizacion;
import Entities.OVenta;
import Entities.Proveedor;
import Entities.Rodamiento;
import Helper.CotizacionesXML;

public class AD_XML_Cotizaciones_Test
{
	
	@Test
	public void testXMLCotizaciones()
	{
		Cotizacion cot = new Cotizacion();
		cot.setEstado("nueva");
		
		OVenta ov = new OVenta();
		ov.setDireccion("Calle falsa 123");
		ov.setNombre("OV de Prueba");
		ov.setId(69);
		
		Proveedor pr = new Proveedor();
		pr.setCodigoProveedor(1);
		
		Vector<ItemCotizacion> items = new Vector<>();
		
		for (int i = 1; i < 4; i++)
		{
			ItemCotizacion itCot = new ItemCotizacion();
			
			itCot.setCantidad(i * 3);
			itCot.setId(i);
			itCot.setPrecio(i * 15);
			itCot.setProveedor(pr);
			
			Rodamiento r = new Rodamiento();
			r.setId(i);
			
			itCot.setRod(r);
			
			items.add(itCot);
		}
		
		cot.setOventa(ov);
		cot.setItems(items);
		
		CotizacionesXML.generarXMLArmarCotizacion(cot);
	}
}