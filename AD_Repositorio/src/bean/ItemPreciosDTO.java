package bean;

public class ItemPreciosDTO {
	private RodamientoDTO rodamientoDTO;
	private String codRodProv;
	private ProveedorDTO proveedorDTO;
	private float precio;

	public RodamientoDTO getRodamientoDTO() {
		return rodamientoDTO;
	}
	public void setRodamientoDTO(RodamientoDTO rodamientoDTO) {
		this.rodamientoDTO = rodamientoDTO;
	}
	public String getCodRodProv() {
		return codRodProv;
	}
	public void setCodRodProv(String codRodProv) {
		this.codRodProv = codRodProv;
	}
	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}
	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}