package Entities;

import org.hibernate.annotations.Entity;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Rodamiento.java
//  @ Date : 9/16/2015
//  @ Author : 
//
//

@Entity
public class Rodamiento {
	private String codigoSKF;
	private String tipo;
	public boolean sosRodamiento( String codigoSKF) {
		return true;
	
	}
	
	public boolean sosRodamiento( String codigo,  String tipo) {
		return true;
	}
	
	public void ActualizarStock( int cantidad,  float precio) {
	
	}
}
