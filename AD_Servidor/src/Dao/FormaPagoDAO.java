package Dao;

import Entities.FormaPago;

public class FormaPagoDAO extends BaseDAO
{
	public static FormaPago getFormaPago(int id)
	{
		return getEntity(FormaPago.class, id);
	}
}