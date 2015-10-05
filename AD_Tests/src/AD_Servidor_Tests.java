import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Vector;

import org.junit.Test;

import Dao.ClienteDAO;
import Dao.OVentaDAO;
import Entities.Cliente;
import Entities.ItemProveedor;
import Entities.OCProveedor;
import Entities.OVenta;
import Entities.Proveedor;
import Entities.Rodamiento;
import Helper.OCProveedorXML;

public class AD_Servidor_Tests
{
	
	@Test
	public void testSaveAndRetrieveCliente()
	{
		
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
	
	@Test
	public void testXMLGenerate()
	{
		OCProveedor oc = new OCProveedor();
		oc.setCodigo("1");
		Rodamiento r = new Rodamiento();
		r.setCodigoSKF("pepe");
		Rodamiento r2 = new Rodamiento();
		r.setCodigoSKF("pepe2");
		Proveedor pr = new Proveedor();
		pr.setCodigoProveedor(1);
		ItemProveedor item = new ItemProveedor("1", (float) 0.5, "", true, r);
		Vector<ItemProveedor> items = new Vector<ItemProveedor>();
		items.add(item);
		pr.setItems(items);
		oc.agregarAOC(r, 5);
		oc.agregarAOC(r2, 15);
		Vector<OCProveedor> prov = new Vector<OCProveedor>();
		prov.add(oc);
		OCProveedorXML.GenerarXMLOrdenesDeCompra(prov);
		
	}
}