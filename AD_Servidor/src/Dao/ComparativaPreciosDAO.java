package Dao;

import Entities.ComparativaPrecios;

public class ComparativaPreciosDAO extends BaseDAO
{
	public static ComparativaPrecios getComparativa(int id)
	{
		return getEntity(ComparativaPrecios.class, id);
	}
	
	public static ComparativaPrecios saveComparativa(ComparativaPrecios comPr)
	{
		return saveEntity(comPr);
	}
}