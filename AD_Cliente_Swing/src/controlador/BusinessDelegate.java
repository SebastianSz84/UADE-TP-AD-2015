package controlador;

import interfaz.InterfazGestionRodamientos;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bean.ProveedorDTO;
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

	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor)
	{
		try
		{
			objetoRemoto.generarListaDePrecioProveedorAutomatica(archivoProveedor, codigoProveedor);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agregarItemAListaProveedor(int codigoProveedor, String codigoItem, float precio, String condiciones, boolean disponible, String codigoSKF)
	{
		try
		{
			objetoRemoto.agregarItemAListaProveedor(codigoProveedor, codigoItem, precio, condiciones, disponible, codigoSKF);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad)
	{
		try
		{
			return objetoRemoto.GenerarBultosDeRodamiento(codigoSKF, cantidad);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
	public void altaProveedor(ProveedorDTO proveedorDTO)
	{
		objetoRemoto.altaProveedor(proveedorDTO);
	}
	
	public void bajaProveedor(ProveedorDTO proveedorDTO)
	{
		objetoRemoto.modificacionProveedor(proveedorDTO);
	}
	
	public void modificacionProveedor(int codigoProveedor)
	{
		objetoRemoto.bajaProveedor(codigoProveedor);
	}
	
}