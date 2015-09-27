import static org.junit.Assert.*;

import org.junit.Test;

import Dao.ClienteDAO;
import Dao.OVentaDAO;
import Entities.Cliente;
import Entities.OVenta;

public class AD_Servidor_Tests {
	
	@Test
	public void testSaveAndRetrieveCliente() {
        
		OVenta ov = new OVenta();
		ov.nombre = "TestOVName";
		ov.direccion = "TestOVAddress";
		
		ov = OVentaDAO.saveEntity(ov);
		
		Cliente cliente = new Cliente();
		cliente.nombre = "TestName";
		cliente.direccion = "TestAddress";
		cliente
		
		cliente = ClienteDAO.saveCliente(cliente);
		
		int id = cliente.codigo;
				
		cliente = ClienteDAO.getCliente(id);

		assertNotNull(cliente);
		assertEquals(cliente.nombre, "TestName");
		
		ClienteDAO.deleteCliente(cliente);
		OVentaDAO.deleteEntity(ov);
    }
}
