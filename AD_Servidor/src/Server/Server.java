package Server;

import interfaz.InterfazGestionRodamientos;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import RMI.RecursosRMI;

public class Server extends Thread
{
	InterfazGestionRodamientos objetoRemoto;
	
	public static void main(String[] args)
	{
		new Server();
	}
	
	public Server()
	{
		iniciar();
	}
	
	private void iniciar()
	{
		try
		{
			ThreadCotizaciones thCot = new ThreadCotizaciones();
			thCot.start();
			
			ThreadBultos thBultos = new ThreadBultos();
			thBultos.start();
			
			LocateRegistry.createRegistry(1099);
			objetoRemoto = new RecursosRMI();
			// Vincula el objeto con un nombre en el registry
			Naming.rebind(InterfazGestionRodamientos.url, objetoRemoto);
			System.out.println("Servidor inicializado correctamente...");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}