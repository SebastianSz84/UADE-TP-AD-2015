package Dao;

import Entities.Cliente;

public class ClienteDAO extends BaseDAO
{
	
	public static Cliente getCliente(int codigo)
	{
		return getEntity(Cliente.class, codigo);
	}
	
}
