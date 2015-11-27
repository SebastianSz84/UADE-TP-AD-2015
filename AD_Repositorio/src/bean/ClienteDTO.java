package bean;

public class ClienteDTO
{
	
	private int id;
	private String nombre;
	private String direccion;
	private OVentaDTO oVenta;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public OVentaDTO getOVenta()
	{
		return oVenta;
	}
	
	public void setOVenta(OVentaDTO oVenta)
	{
		this.oVenta = oVenta;
	}
}