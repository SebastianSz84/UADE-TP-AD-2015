import org.junit.Test;

import Dao.ClienteDAO;
import bean.ClienteDTO;
import bean.FormaDePagoDTO;

public class PruebaCliente
{
	@Test
	public void leerCliente()
	{
		ClienteDTO cliDTO = ClienteDAO.getCliente(1).getDTO();
		
		for (FormaDePagoDTO fp : cliDTO.getFormasDepago())
		{
			System.out.println(fp.getDescripcion());
		}
	}
}