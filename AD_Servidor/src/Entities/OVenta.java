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

import Helper.HelperXML;
import bean.CotizacionDTO;
import bean.ItemCotizacionDTO;
import bean.PedVentaDTO;

@Entity
public class OVenta
{
	
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idOVenta")
	public List<PedVenta> pedidos;
	
	public OVenta()
	{
		clientes = new ArrayList<Cliente>();
	}
	
	public void generarCotizacion(CotizacionDTO cotDTO)
	{
		Cotizacion cot = new Cotizacion();
		cot.setEstado(cotDTO.getEstado());
		while (cotDTO.tenesItems())
		{
			ItemCotizacionDTO itCotDTO = cotDTO.dameItem();
			cot.agregarItem(itCotDTO, ComparativaPrecios.getInstancia().getMejorPrecio(itCotDTO).getDTO());
		}
		HelperXML.generarXMLCotizacion(cot);
	}
	
	public void generarXMLCotizacion()
	{
		
	}
	
	public PedVenta getPedidosVenta()
	{
		return null;
	}
	
	public void crearEnvio()
	{
		
	}
	
	public void buscarCliente()
	{
		
	}
	
	public void buscarRodamiento(String codSKF)
	{
		
	}
	
	public void addRodamiento(Rodamiento rod)
	{
		
	}
	
	public void generarFactura(Cliente cli, PedVenta ped)
	{
		
	}
	
	public PedVentaDTO crearPedidoVenta(Cotizacion cot)
	{
		PedVenta pedVta = new PedVenta();
		pedVta.setCotizacion(cot);
		pedVta.generarItemsDesdeCotizacion();
		pedidos.add(pedVta);
		return pedVta.getDTO();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public List<Cliente> getClientes()
	{
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes)
	{
		this.clientes = clientes;
	}
	
	public List<PedVenta> getPedidos()
	{
		return pedidos;
	}
	
	public void setPedidos(List<PedVenta> pedidos)
	{
		this.pedidos = pedidos;
	}
}