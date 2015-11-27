package controlador;

import interfaz.InterfazGestionRodamientos;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import Entities.CCentral;
import bean.ItemCotizacionDTO;

public class BusinessDelegate
{
	InterfazGestionRodamientos objetoRemoto;
	private static BusinessDelegate instancia;

	private BusinessDelegate()
	{
		getStub();
	}

	public static BusinessDelegate getInstancia()
	{
		if (instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}

	public boolean getStub()
	{
		try
		{
			objetoRemoto = (InterfazGestionRodamientos) Naming.lookup(InterfazGestionRodamientos.url);

			System.out.println("Servicio Obtenido de la interfaz remota: " + InterfazGestionRodamientos.url);

			return true;

		} catch (MalformedURLException e)
		{

			e.printStackTrace();
		} catch (RemoteException e)
		{

			e.printStackTrace();
		} catch (NotBoundException e)
		{

			e.printStackTrace();
		}

		return false;
	}

	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor) {
		
	}
	
	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF) 	{
		CCentral.getInstancia().agregarItemAListaProveedor(codigoProveedor, codigoItem, precio, condiciones, disponible, codigoSKF);
	}
	
	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad) {
		return CCentral.getInstancia().GenerarBultosDeRodamiento(codigoSKF, cantidad);
	}
}