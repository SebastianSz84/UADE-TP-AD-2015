package bean;

import java.io.Serializable;

public class RodamientoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoSKF;
	private String tipo;
	
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
}