package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String codigo;
	
	@Column (nullable=false, length=50)
	public String nombre;

	@Column (nullable=false, length=50)
	public String direccion;
	
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
