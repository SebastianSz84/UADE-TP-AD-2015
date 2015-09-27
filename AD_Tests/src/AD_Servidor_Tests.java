import static org.junit.Assert.*;

import org.junit.Test;

import Dao.ClienteDAO;
import Dao.OVentaDAO;
import Entities.Cliente;
import Entities.OVenta;

public class AD_Servidor_Tests {
	
	@Test
	public void testSaveAndRetrieveCliente() {
        
		OVenta ov = null;
		Cliente cliente = null;
		try
		{
			ov = new OVenta();
			ov.nombre = "TestOVName";
			ov.direccion = "TestOVAddress";
			
			cliente = new Cliente();
			cliente.nombre = "TestName";
			cliente.direccion = "TestAddress";
			cliente.OficinaDeVenta = ov;
			
			ov.clientes.add(cliente);
		
			ov = OVentaDAO.saveEntity(ov);
			
			int id = cliente.id;
			
			cliente = ClienteDAO.getCliente(id);
	
			assertNotNull(cliente);
			assertEquals(cliente.nombre, "TestName");
		}
		finally
		{
			ov.clientes.remove(cliente);
			ClienteDAO.deleteCliente(cliente);
			OVentaDAO.deleteEntity(ov);
		}
    }
}
