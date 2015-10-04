package RMI;

import java.util.ArrayList;
import java.util.List;

import Entities.CCentral;
import Entities.OVenta;
import Entities.PedVenta;
import Entities.Rodamiento;
import bean.RodamientoDTO;

//

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Sistema.java
//  @ Date : 9/16/2015
//  @ Author : 
//
//

public class Sistema
{
	private CCentral cc; // VA ESTO NO ?
	private List<RodamientoDTO> rodamientosDTO;
	private List<Rodamiento> rodamientos;
	private List<PedVenta> pedidos;
	private List<OVenta> oventas; // VA ESTO NO ?
	
	public Sistema()
	{
		rodamientosDTO = new ArrayList<RodamientoDTO>();
		rodamientos = new ArrayList<Rodamiento>();
		pedidos = new ArrayList<PedVenta>();
		oventas = new ArrayList<OVenta>();
	}
	
	public List<RodamientoDTO> getListaRodamientos()
	{
		for (Rodamiento rodamiento : rodamientos)
		{
			rodamientosDTO.add(rodamiento.getDTO());
		}
		return rodamientosDTO;
	}
	
	public void solicitarCotizacion()
	{
		
	}
	
	public void grabarNuevaCotizacion()
	{
		
	}
	
	public void buscarRodamento()
	{
		
	}
	
	public void agregarItem()
	{
		
	}
	
	public void leerXMLCotizacion()
	{
		
	}
	
	public void armarCotizacones()
	{
		
	}
	
	public void buscarOV()
	{
		
	}
	
	public void aceptarCotizacion()
	{
		
	}
	
	/*
	 * public XML leerXMLCotAceptadas() { } public XML leerXMLBultosAEnviar() { } public void borrarXMLPedidoCotizacion(XML xml) { } public void borrarXMLDeBultoAEnviar( XML xml) { }
	 */
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio)
	{
		CCentral.getInstancia().ActualizarStock(codigoSKF, cantidad, precio);
	}
	
	public void GenerarOrdenesDeCompra()// ACA VA listaXMLs
	{
		for (OVenta oventa : oventas)
		{
			pedidos.add(oventa.getPedidosVenta());
		}
		CCentral.getInstancia().GenerarOrdenesDeCompra(pedidos); // ESTO VA ASI????
	}
	
	public void PublicarListaDePreciosFinal()
	{
		
	}
	
	/*
	 * public void generarListaDePrecioProveedorAutomatica( XML archivoProveedor, int codigoProveedor) { }
	 */
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String Tipo)
	{
		
	}
}
