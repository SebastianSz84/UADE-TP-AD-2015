package bean;

public class ItemProveedorDTO
{
	private int id;
	private String skf;
	private String codRodProv;
	private float precio;
	private boolean disponible;
	private String condiciones;
	
	public ItemProveedorDTO(int id, String skf, String codRodProv, float precio, boolean disponible, String condiciones)
	{
		this.id = id;
		this.skf = skf;
		this.codRodProv = codRodProv;
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
	
	public String getCondciones()
	{
		return condiciones;
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
	
	public String getSkf()
	{
		return skf;
	}
	
	public void setSkf(String skf)
	{
		this.skf = skf;
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
}