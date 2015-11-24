package bean;

public class ItemCotizacionDTO {
	private int cantidad;
	private RodamientoDTO rod;
	private float precio;
	private ProveedorDTO proveedor;

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

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

}