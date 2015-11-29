package Dao;

import java.util.List;

import Entities.Rodamiento;

public class RodamientoDAO extends BaseDAO
{
	public static Rodamiento getRodamiento(String codigoSKF)
	{
		return getEntity(Rodamiento.class, codigoSKF);
	}
	
	public static Rodamiento saveRodamiento(Rodamiento rod)
	{
		return saveEntity(rod);
	}
	
	public static List<Rodamiento> getListaRodamientos()
	{
		return getAll(Rodamiento.class, "Rodamiento");
	}
}