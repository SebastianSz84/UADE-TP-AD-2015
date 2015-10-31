package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemBultoId implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumns(@JoinColumn(name = "idBulto"))
	private Bulto bulto;
	
	@ManyToOne
	@JoinColumns(@JoinColumn(name = "idRodamiento"))
	private Rodamiento rodamiento;
	
	public Bulto getBulto()
	{
		return bulto;
	}
	
	public void setBulto(Bulto bulto)
	{
		this.bulto = bulto;
	}
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
	}
	
}
