package Server;

import Controllers.GestionRodamientos;

public class ThreadBultos extends Thread
{
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				GestionRodamientos.getInstancia().leerXMLBultos();
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