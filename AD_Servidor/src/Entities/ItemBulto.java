package Entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ItemsBulto")
public class ItemBulto
{
	
	@Column
	private int cantidad;
	
	@EmbeddedId
	private ItemBultoId itemBultoId;
	
	public ItemBulto(Bulto bulto, int cantidad, Rodamiento rodamientoComprado)
	{
		this.itemBultoId = new ItemBultoId();
		this.cantidad = cantidad;
		this.itemBultoId.setBulto(bulto);
		this.itemBultoId.setRodamiento(rodamientoComprado);
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
}
