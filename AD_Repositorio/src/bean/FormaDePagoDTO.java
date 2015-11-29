package bean;

import java.io.Serializable;

public class FormaDePagoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String descripcion;
	private float porcentaje;
	private int cuotas;
	private int dias;
	private boolean activa;
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public float getPorcentaje()
	{
		return porcentaje;
	}
	
	public void setPorcentaje(float porcentaje)
	{
		this.porcentaje = porcentaje;
	}
	
	public int getCuotas()
	{
		return cuotas;
	}
	
	public void setCuotas(int cuotas)
	{
		this.cuotas = cuotas;
	}
	
	public int getDias()
	{
		return dias;
	}
	
	public void setDias(int dias)
	{
		this.dias = dias;
	}
	
	public boolean isActiva()
	{
		return activa;
	}
	
	public void setActiva(boolean activa)
	{
		this.activa = activa;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
}
