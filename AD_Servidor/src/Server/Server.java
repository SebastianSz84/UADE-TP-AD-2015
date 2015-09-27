package Server;

import interfaz.InterfazGestionRodamientos;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import RMI.GestionRodamientos;

public class Server extends Thread {
	InterfazGestionRodamientos objetoRemoto;

	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		iniciar();
	}

	public void iniciar() {
		try {
			LocateRegistry.createRegistry(1099);
			objetoRemoto = new GestionRodamientos();
			// Vincula el objeto con un nombre en el registry
			Naming.rebind(InterfazGestionRodamientos.url, objetoRemoto);
			System.out.println("Servidor inicializado correctamente...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}