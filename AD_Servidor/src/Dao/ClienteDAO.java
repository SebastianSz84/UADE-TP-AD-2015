package Dao;

import Entities.*;

public class ClienteDAO extends BaseDAO {

	public static Cliente getCliente(int codigo) {
		return getEntity(Cliente.class, codigo); 
	}
	
	public static Cliente saveCliente(Cliente cliente) {
		return saveEntity(cliente); 
	}
	
	public static void deleteCliente(Cliente cliente) {
		deleteEntity(cliente);
	}
	
}
