import org.junit.Test;

import Entities.ComparativaPrecios;
import Entities.ItemProveedor;

public class AD_Comparativa
{
	@Test
	public void testComparativaPrecios()
	{
		for (ItemProveedor itPro : ComparativaPrecios.getInstancia().getItems())
		{
			System.out.println(itPro.getCodigo() + "\t" + itPro.getCondiciones() + "\t" + Float.toString(itPro.getPrecio()));
		}
	}
}