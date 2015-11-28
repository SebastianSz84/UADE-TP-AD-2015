package Dao;

import Entities.ComparativaPrecios;

public class ComparativaPreciosDAO extends BaseDAO
{
	public static ComparativaPrecios getComparativa()
	{
		return getEntity(ComparativaPrecios.class, 1);
	}
	
	public static ComparativaPrecios saveComparativa(ComparativaPrecios comPr)
	{
		return saveEntity(comPr);
	}
	
	public static boolean deleteItems()
	{
		return deleteAll("ItemsComparativa");
	}
}