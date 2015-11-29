package bean;

import java.io.Serializable;

public class ItemProveedorDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String skf;
	private String codRodProv;
	private int idProveedor;
	private float precio;
	private boolean disponible;
	private String condiciones;
	
	public ItemProveedorDTO(int id, String skf, String codRodProv, int idProveedor, float precio, boolean disponible, String condiciones)
	{
		this.id = id;
		this.skf = skf;
		this.codRodProv = codRodProv;
		this.idProveedor = idProveedor;
		this.precio = precio;
		this.disponible = disponible;
		this.condiciones = condiciones;
	}
	
	public ItemProveedorDTO(String skf, String codRodProv, int idProveedor, float precio, boolean disponible, String condiciones)
	{
		this.skf = skf;
		this.codRodProv = codRodProv;
		this.idProveedor = idProveedor;
		this.precio = precio;
		this.disponible = disponible;
		this.condiciones = condiciones;
	}
	
	public String getSKF()
	{
		return skf;
	}
	
	public String getCodRodProv()
	{
		return codRodProv;
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public boolean getDisponible()
	{
		return disponible;
	}
	
	public boolean sosElRodamiento(String codigoSKF)
	{
		return this.skf.equals(codigoSKF);
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getCondiciones()
	{
		return condiciones;
	}
	
	public void setCondiciones(String condiciones)
	{
		this.condiciones = condiciones;
	}
	
	public void setCodRodProv(String codRodProv)
	{
		this.codRodProv = codRodProv;
	}
	
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	
	public int getIdProveedor()
	{
		return idProveedor;
	}
	
	public void setIdProveedor(int idProveedor)
	{
		this.idProveedor = idProveedor;
	}
}