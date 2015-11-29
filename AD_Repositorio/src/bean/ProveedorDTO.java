package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ProveedorDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigoProveedor;
	private String direccion;
	private String nombre;
	private ArrayList<ItemProveedorDTO> rodamientos = new ArrayList<ItemProveedorDTO>();
	
	public int getCodigoProveedor()
	{
		return codigoProveedor;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setCodigoProveedor(int codigoProveedor)
	{
		this.codigoProveedor = codigoProveedor;
	}
	
	public void agregarItem(int id, String skf, String codRodProv, float precio, boolean disponible, String condiciones)
	{
		rodamientos.add(new ItemProveedorDTO(id, skf, codRodProv, this.codigoProveedor, precio, disponible, condiciones));
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