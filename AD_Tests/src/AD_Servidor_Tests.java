import static org.junit.Assert.*;

import org.junit.Test;

import Dao.ClienteDAO;
import Entities.Cliente;

public class AD_Servidor_Tests {
	
	@Test
	public void testGetCliente() {
        
		Cliente cliente = ClienteDAO.getCliente(1);
		
		assertNotNull(cliente);
		assertEquals(cliente.codigo, 1);

    }

	@Test
	public void testSaveCliente() {
        
		Cliente cliente = new Cliente();
		cliente.codigo = 2;
		cliente.nombre = "TestName";
		cliente.direccion = "TestAddress";
		
		ClienteDAO.saveCliente(cliente);
				
		cliente = ClienteDAO.getCliente(2);

		assertNotNull(cliente);
		assertEquals(cliente.codigo, 2);

    }
}
