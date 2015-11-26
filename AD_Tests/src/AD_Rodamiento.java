import org.junit.Test;

import Dao.RodamientoDAO;
import Entities.Rodamiento;

public class AD_Rodamiento
{
	@Test
	public void testRodamientos()
	{
		for (Rodamiento rod : RodamientoDAO.getListaRodamientos())
		{
			System.out.println(rod.getCodigoSKF() + "\t" + rod.getTipo() + "\t" + rod.getStock().getCantidad() + "\t" + rod.getStock().getPrecio());
		}
	}
}