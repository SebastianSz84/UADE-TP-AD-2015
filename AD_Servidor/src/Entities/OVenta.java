package Entities;

import java.util.*;
import javax.persistence.*;

@Entity
public class OVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column (nullable=false, length=50)
	public String nombre;

	@Column (nullable=false, length=50)
	public String direccion;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idOVenta")
	public List<Cliente> clientes;
	
	public OVenta() {
		clientes = new ArrayList<Cliente>();
	}
	
	public void generarCotizacion() {
	
	}
	
	public void generarXMLCotizacion() {
	
	}
	
	public void aceptarCotizacion() {
	
	}
	
	public PedVenta getPedidosVenta() {
		
		return null;
	}
	
	public void crearEnvio() {
	
	}
	
	public void buscarCliente() {
	
	}
	
	public void buscarRodamiento( String codSKF) {
	
	}
	
	public void addRodamiento( Rodamiento rod) {
	
	}
	
	public void generarFactura(Cliente cli, PedVenta ped) {
	
	}
}
