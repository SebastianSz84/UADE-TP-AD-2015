package Entities;
import java.util.*;
import javax.persistence.*;

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




public class Bulto {

	public int id;
	

	public OVenta OficinaDeVenta;
	

	public List<ItemBulto> items;
	
	public Bulto(){
		this.items = new ArrayList<ItemBulto>();
	}
	

	
	public void agregarRodamientoComprado(Rodamiento rodamientoComprado) {
		
	}

	public List<ItemBulto> getItems() {
		return items;
	}

	public void setItems(List<ItemBulto> items) {
		this.items = items;
	}
}
