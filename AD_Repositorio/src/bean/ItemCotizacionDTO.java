package bean;

public class ItemCotizacionDTO {
	public int cantidad;
	public RodamientoDTO rod;
	public float precio;

	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public RodamientoDTO getRod() {
		return rod;
	}
	
	public void setRod(RodamientoDTO rod) {
		this.rod = rod;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}