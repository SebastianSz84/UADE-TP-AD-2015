package Entities;

import java.util.Vector;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Cotizacion.java
//  @ Date : 9/16/2015
//  @ Author : 
//
//

public class Cotizacion {
	private Vector<ItemCotizacion> items;
	private String estado;

	public void agregarItem(Rodamiento rod, int cant) {

	}

	public void aceptar() {
		this.estado = "Aceptada";
	}

	public float getTotal() {
		return 0;
	}
}
