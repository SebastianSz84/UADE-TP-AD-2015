package Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FormaPago
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String descripcion;
	@Column
	private float porcentaje;
	@Column
	private int cuotas;
	@Column
	private int dias;
	@Column
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
