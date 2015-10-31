package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bean.RodamientoDTO;

@Entity
@Table(name = "Rodamientos")
public class Rodamiento
{
	@Id
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
		rodDTO.setTipo(this.tipo);
		return rodDTO;
	}
}