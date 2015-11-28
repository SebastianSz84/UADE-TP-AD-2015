import java.util.List;

import org.junit.Test;

import Entities.ComparativaPrecios;
import Entities.ItemProveedor;

public class AD_Comparativa
{
	@Test
	public void testComparativaPrecios()
	{
		List<ItemProveedor> listaItems = ComparativaPrecios.getInstancia().getItems();
		for (ItemProveedor itPro : listaItems)
		{
			System.out.println(itPro.getCodigo() + "\t" + itPro.getCondiciones() + "\t" + Float.toString(itPro.getPrecio()));
		}
	}
}