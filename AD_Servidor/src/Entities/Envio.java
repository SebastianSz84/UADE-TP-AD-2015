package Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Envio
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idCliente")
	public Cliente cli;
	
	@Column
	public Date fecha;
	
	@OneToOne
	@JoinColumn(name = "idOVenta")
	private OVenta oventa;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Cliente getCli()
	{
		return cli;
	}
	
	public void setCli(Cliente cli)
	{
		this.cli = cli;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
	
	public OVenta getOventa()
	{
		return oventa;
	}
	
	public void setOventa(OVenta oventa)
	{
		this.oventa = oventa;
	}
	
	public void agregarItem(Rodamiento rod, int cant)
	{
	
	}
}
