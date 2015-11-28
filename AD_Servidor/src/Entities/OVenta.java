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

import Dao.ClienteDAO;
import Dao.CotizacionDAO;
import Helper.CotizacionesXML;
import bean.BultoDTO;
import bean.ClienteDTO;
import bean.CotizacionDTO;
import bean.OVentaDTO;
import bean.PedVentaDTO;

@Entity
public class OVenta
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@Column(nullable = false, length = 50)
	private String direccion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Cliente> clientes;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idOVenta")
	private List<PedVenta> pedidos;
	
	public OVenta()
	{
		clientes = new ArrayList<Cliente>();
	}
	
	public void altaCliente(ClienteDTO clienteDTO)
	{
		Cliente cliente = new Cliente(this, clienteDTO);
		ClienteDAO.saveEntity(cliente);
	}
	
	public void modificacionCliente(ClienteDTO clienteDTO)
	{
		Cliente cliente = buscarCliente(clienteDTO.getId());
		cliente.modificar(this, clienteDTO);
		ClienteDAO.saveEntity(cliente);
	}
	
	public void bajaCliente(int idCliente)
	{
		Cliente cliente = buscarCliente(idCliente);
		ClienteDAO.deleteEntity(cliente);
	}
	
	public void generarCotizacion(CotizacionDTO cotDTO)
	{
		Cotizacion cot = CotizacionDAO.getCotizacion(cotDTO.getId());
		if (cot != null)
		{
			cot.setEstado("Armada");
			for (ItemCotizacion itCot : cot.getItems())
			{
				ItemProveedor itProv = ComparativaPrecios.getInstancia().getMejorPrecio(itCot.getDTO());
				if (itProv != null)
				{
					itCot.setItProveedor(itProv);
					itCot.setCotizado(true);
				}
			}
			CotizacionesXML.generarXMLArmarCotizacion(CotizacionDAO.saveCotizacion(cot));
		}
	}
	
	public Cotizacion aceptarCotizacion(Cotizacion cot)
	{
		cot.aceptar();
		return CotizacionDAO.saveCotizacion(cot);
	}
	
	public void generarXMLCotizacion()
	{
		
	}
	
	public void crearEnvio(BultoDTO bultoAEnviarDTO)
	{
		
	}
	
	public Cliente buscarCliente(int idCliente)
	{
		for (Cliente cli : clientes)
		{
			if (cli.getId() == idCliente)
			{
				return cli;
			}
		}
		return null;
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
	
	public List<Cotizacion> listCotizacionesPorCliente(int nroCliente)
	{
		return CotizacionDAO.getAll(Cotizacion.class, "Cotizacion");
	}
	
	public OVentaDTO getDTO()
	{
		OVentaDTO ovDTO = new OVentaDTO();
		ovDTO.setDireccion(this.direccion);
		ovDTO.setId(this.id);
		ovDTO.setNombre(this.nombre);
		return ovDTO;
	}
}