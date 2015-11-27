package bean;

import java.util.ArrayList;

public class ProveedorDTO
{
	private int codigoProveedor;
	private ArrayList<ItemProveedorDTO> rodamientos = new ArrayList<ItemProveedorDTO>();
	
	public int getCodigoProveedor()
	{
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(int codigoProveedor)
	{
		this.codigoProveedor = codigoProveedor;
	}
	
	public void agregarItem(int id, String skf, String codRodProv, float precio, boolean disponible, String condiciones)
	{
		rodamientos.add(new ItemProveedorDTO(id, skf, codRodProv, precio, disponible, condiciones));
	}
	
	public ArrayList<ItemProveedorDTO> getRodamientos()
	{
		return rodamientos;
	}
	
	public ItemProveedorDTO getItemProveedor(RodamientoDTO rodamiento)
	{
		for (ItemProveedorDTO itProvDTO : rodamientos)
		{
			if (itProvDTO.sosElRodamiento(rodamiento.getCodigoSKF()))
			{
				return itProvDTO;
			}
		}
		return null;
	}
}