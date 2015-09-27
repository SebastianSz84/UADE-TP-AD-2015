package RMI;

import interfaz.InterfazGestionRodamientos;
import Dao.ClienteDAO;
import Entities.Cliente;
import Server.HelperXML;
import bean.ClienteDTO;
import bean.CotizacionDTO;

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

public class GestionRodamientos implements InterfazGestionRodamientos {

	public void getListaRodamientos() {

	}

	public void solicitarCotizacion() {

	}

	public void grabarNuevaCotizacion() {

	}

	public void buscarRodamento() {

	}

	public void agregarItem() {

	}

	public void leerXMLCotizacion() {

	}

	public void armarCotizacones() {

	}

	public void buscarOV() {

	}

	public void aceptarCotizacion(CotizacionDTO cotDTO, ClienteDTO cliDTO) {
		Cliente cli = ClienteDAO.getCliente(cliDTO.getId());

		if (cli != null) {
			cli.aceptarCotizacion(cotDTO);
			HelperXML.generarXMLCotizacion(cotDTO);
		}
	}

	/*
	 * public XML leerXMLCotAceptadas() {
	 * 
	 * }
	 * 
	 * public XML leerXMLBultosAEnviar() {
	 * 
	 * }
	 * 
	 * public void borrarXMLPedidoCotizacion(XML xml) {
	 * 
	 * }
	 * 
	 * public void borrarXMLDeBultoAEnviar( XML xml) {
	 * 
	 * }
	 */

	public void ActualizarStock(String codigoSKF, int cantidad, float precio) {

	}

	/*
	 * public listasXML generarOrdenesDeCompra() {
	 * 
	 * }
	 */

	public void PublicarListaDePreciosFinal() {

	}

	/*
	 * public void generarListaDePrecioProveedorAutomatica( XML
	 * archivoProveedor, int codigoProveedor) {
	 * 
	 * }
	 */
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF, String Tipo) {

	}
}
