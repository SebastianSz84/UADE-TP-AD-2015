package bean;

import java.util.Vector;

public class PedVentaDTO {
	private CotizacionDTO cotizacion;
	private Vector<ItemPedVentaDTO> items;

	public CotizacionDTO getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(CotizacionDTO cotizacion) {
		this.cotizacion = cotizacion;
	}
	public Vector<ItemPedVentaDTO> getItems() {
		return items;
	}
	public void setItems(Vector<ItemPedVentaDTO> items) {
		this.items = items;
	}
}
