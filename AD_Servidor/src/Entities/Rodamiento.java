package Entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import bean.RodamientoDTO;
import bean.StockDTO;

@Entity
@Table(name = "Rodamiento")
public class Rodamiento
{
	@Id
	@Column(nullable = false, length = 50)
	private String codigoSKF;
	
	@Column(nullable = false, length = 50)
	private String tipo;
	
	@Column
	private boolean inactivo;
	
	@Embedded
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
		StockDTO stkDTO = new StockDTO();
		stkDTO.setCantidad(this.getStock().getCantidad());
		stkDTO.setPrecio(this.getStock().getPrecio());
		rodDTO.setStock(stkDTO);
		return rodDTO;
	}
	
	public Stock getStock()
	{
		return stock;
	}
	
	public void setStock(Stock stock)
	{
		this.stock = stock;
	}
	
	public boolean isInactivo()
	{
		return inactivo;
	}
	
	public void setInactivo(boolean inactivo)
	{
		this.inactivo = inactivo;
	}
}