package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import bean.RodamientoDTO;

@Entity
public class Rodamiento
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)
	private String codigoSKF;
	
	@Column(nullable = false, length = 50)
	private String tipo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idRodamiento")
	private Stock stock;
	
	public boolean sosRodamiento(String codigoSKF)
	{
		return (codigoSKF == this.codigoSKF);
	}
	
	public boolean sosRodamiento(String codigo, String tipo)
	{
		return ((codigo == this.codigoSKF) && (tipo == this.tipo));
	}
	
	public void ActualizarStock(int cantidad, float precio)
	{
		stock.setCantidad(cantidad);
		stock.setPrecio(precio);
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getCodigoSKF()
	{
		return codigoSKF;
	}
	
	public void setCodigoSKF(String codigoSKF)
	{
		this.codigoSKF = codigoSKF;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
	public RodamientoDTO getDTO()
	{
		RodamientoDTO rodDTO = new RodamientoDTO();
		rodDTO.setCodigoSKF(this.codigoSKF);
		rodDTO.setId(this.id);
		rodDTO.setTipo(this.tipo);
		return rodDTO;
	}
}