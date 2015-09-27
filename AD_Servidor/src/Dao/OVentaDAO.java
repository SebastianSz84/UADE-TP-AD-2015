package Dao;

import Entities.*;

public class OVentaDAO extends BaseDAO {

	public static OVenta getOVenta(int codigo) {
		return getEntity(OVenta.class, codigo); 
	}
	
	public static OVenta saveOVenta(OVenta ov) {
		return saveEntity(ov); 
	}
	
	public static void deleteOVenta(OVenta ov) {
		deleteEntity(ov);
	}
}
