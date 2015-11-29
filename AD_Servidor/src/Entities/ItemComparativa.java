package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemsComparativa")
public class ItemComparativa
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idComparativa")
	private ComparativaPrecios comparativa;
	
	@OneToOne
	@JoinColumn(name = "codigoSKF")
	private Rodamiento rodamiento;
	
	@OneToOne
	@JoinColumn(name = "idItemProveedor")
	private ItemProveedor itemProveedor;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public ComparativaPrecios getComparativa()
	{
		return comparativa;
	}
	
	public void setComparativa(ComparativaPrecios comparativa)
	{
		this.comparativa = comparativa;
	}
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento)
	{
		this.rodamiento = rodamiento;
	}
	
	public ItemProveedor getItemProveedor()
	{
		return itemProveedor;
	}
	
	public void setItemProveedor(ItemProveedor itemProveedor)
	{
		this.itemProveedor = itemProveedor;
	}
	
}