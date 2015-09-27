package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class OVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(nullable = false, length = 50)
	public String nombre;

	@Column(nullable = false, length = 50)
	public String direccion;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idOVenta")
	public List<Cliente> clientes;

	public OVenta() {
		clientes = new ArrayList<Cliente>();
	}

	public void generarCotizacion() {

	}

	public void generarXMLCotizacion() {

	}

	public PedVenta getPedidosVenta() {
		return null;
	}

	public void crearEnvio() {

	}

	public void buscarCliente() {

	}

	public void buscarRodamiento(String codSKF) {

	}

	public void addRodamiento(Rodamiento rod) {

	}

	public void generarFactura(Cliente cli, PedVenta ped) {

	}
}
