import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dao.ComparativaPreciosDAO;
import Entities.Bulto;
import Entities.ItemProveedor;
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
			bu.agregarRodamientoComprado(itProv.getRodamiento(), 10);
			bults.add(bu);
		}
		BultosXML.GenerarXMLBultos(bults);
	}
}
