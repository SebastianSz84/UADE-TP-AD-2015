package bean;

import java.util.ArrayList;

public class ProveedorDTO {
	private int codigoProveedor;
	private ArrayList<ItemProveedorDTO> rodamientos = new ArrayList<ItemProveedorDTO>();

	public int getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public void agregarItem(String skf, String codRodProv, float precio) {
		rodamientos.add(new ItemProveedorDTO(skf, codRodProv, precio));
	}
}