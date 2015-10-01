package Server;

import RMI.GestionRodamientos;

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
				Thread.sleep(1000 * 60 * 5); // Esperar 5 minutos
			}
		}
		catch (InterruptedException e)
		{
			String threadName = Thread.currentThread().getName();
			System.out.format("%s: %s%n", threadName, "Thread interrumpido");
		}
	}
}