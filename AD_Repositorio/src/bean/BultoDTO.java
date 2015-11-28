package bean;

import java.util.ArrayList;
import java.util.List;

public class BultoDTO
{
	public int id;
	public OVentaDTO OficinaDeVenta;
	public List<ItemBultoDTO> items;
	
	public BultoDTO()
	{
		this.items = new ArrayList<ItemBultoDTO>();
	}
	
	public List<ItemBultoDTO> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemBultoDTO> items)
	{
		this.items = items;
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
