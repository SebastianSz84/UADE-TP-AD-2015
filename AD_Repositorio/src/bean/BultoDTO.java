package bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Bulto.java
//  @ Date : 9/16/2015
//  @ Author : 
//
//

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
}