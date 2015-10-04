package Dao;

import Entities.Cotizacion;

public class CotizacionDAO extends BaseDAO
{
	public static Cotizacion getCotizacion(int id)
	{
		return getEntity(Cotizacion.class, id);
	}
	
	public static Cotizacion saveCotizacion(Cotizacion cot)
	{
		return saveEntity(cot);
	}
}