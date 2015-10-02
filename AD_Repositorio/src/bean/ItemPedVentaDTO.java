package bean;

public class ItemPedVentaDTO {
	private RodamientoDTO rodamiento;
	private ProveedorDTO proveedor;
	private int cantidad;
	public float precio;

	public RodamientoDTO getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(RodamientoDTO rodamiento) {
		this.rodamiento = rodamiento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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