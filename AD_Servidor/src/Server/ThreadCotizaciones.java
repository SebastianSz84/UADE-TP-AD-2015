package Server;

import Controllers.GestionRodamientos;

public class ThreadCotizaciones extends Thread
{
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				GestionRodamientos.getInstancia().armarCotizacones();
				Thread.sleep(1000 * 30); // Esperar 30 segundos
				
				GestionRodamientos.getInstancia().procesarCotAceptadas();
				Thread.sleep(1000 * 30); // Esperar 30 segundos
			}
		}
		catch (InterruptedException e)
		{
			String threadName = Thread.currentThread().getName();
			System.out.format("%s: %s%n", threadName, "Thread interrumpido");
		}
	}
}