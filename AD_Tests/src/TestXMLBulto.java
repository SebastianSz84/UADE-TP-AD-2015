import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dao.ComparativaPreciosDAO;
import Entities.Bulto;
import Entities.ItemProveedor;
import Entities.OVenta;
import Helper.BultosXML;

public class TestXMLBulto
{
	@Test
	public void testxml()
	{
		List<Bulto> bults = new ArrayList<>();
		Bulto bu = new Bulto();
		for (ItemProveedor itProv : ComparativaPreciosDAO.getComparativa().getItems())
		{
			OVenta ov = new OVenta();
			ov.setId(1);
			bu.agregarRodamientoComprado(itProv.getRodamiento(), 10);
			bu.setOficinaDeVenta(ov);
			bults.add(bu);
		}
		BultosXML.GenerarXMLBultos(bults);
	}
}
