package Server;

import java.util.Vector;

import Entities.Cotizacion;
import Entities.Rodamiento;
import bean.CotizacionDTO;

public class HelperXML
{
	
	public static void generarXMLCotizacion(Object cot)
	{
		// TODO Agregar c�digo para generar XML desde DTO de Cotizacion
	}
	
	public static CotizacionDTO leerXMLCotizacion()
	{
		// TODO Levantar XML de Cotizacion para armar
		return null;
	}
	
	public static boolean hayXMLCotizacionParaArmar()
	{
		// TODO Codificar validaci�n de existencia de archivos XML en la carpeta de Cotizaciones para Armar
		return false;
	}
	
	public static void generarXMLSolicitudCotizacion(Vector<Rodamiento> listaItems)
	{
		// TODO Agregar c�digo para generar XML lista de Rodamientos
	}
	
	public static boolean hayXMLCotizacionesAceptadas()
	{
		// TODO Codificar validaci�n de existencia de archivos XML en la carpeta de Cotizaciones Aceptadas
		return false;
	}
	
	public static Cotizacion leerXMLCotizacionAceptada()
	{
		// TODO Codificar lectura
		return null;
	}
}