package bean;

public class ItemProveedorDTO {
	private String skf;
	private String codRodProv;
	private float precio;
	private boolean disponible;
	private String condiciones;

	public ItemProveedorDTO(String skf, String codRodProv, float precio, boolean disponible, String condiciones) {
		this.skf = skf;
		this.codRodProv = codRodProv;
		this.precio = precio;
		this.disponible = disponible;
		this.condiciones = condiciones;
	}

	public String getSKF() {
		return skf;
	}

	public String getCodRodProv() {
		return codRodProv;
	}

	public float getPrecio() {
		return precio;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public String getCondciones() {
		return condiciones;
	}
}
