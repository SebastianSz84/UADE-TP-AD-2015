package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemCotizacionId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "idCotizacion")
	private Cotizacion cot;
	
	@ManyToOne
	@JoinColumn(name = "codigoSKF")
	private Rodamiento rod;
	
	public Cotizacion getCot()
	{
		return cot;
	}
	
	public void setCot(Cotizacion cot)
	{
		this.cot = cot;
	}
	
	public Rodamiento getRod()
	{
		return rod;
	}
	
	public void setRod(Rodamiento rod)
	{
		this.rod = rod;
	}
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}