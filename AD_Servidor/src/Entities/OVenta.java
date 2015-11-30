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
import javax.persistence.Table;

import Dao.ClienteDAO;
import Dao.CotizacionDAO;
import Dao.MensajesDAO;
import Dao.PedVentaDAO;
import Helper.CotizacionesXML;
import bean.BultoDTO;
import bean.ClienteDTO;
import bean.CotizacionDTO;
import bean.ItemBultoDTO;
import bean.OVentaDTO;
import bean.PedVentaDTO;

@Entity
@Table(name = "OVenta")
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
		Cliente cliente = ClienteDAO.getCliente(clienteDTO.getId());
		cliente.modificar(this, clienteDTO);
		ClienteDAO.saveEntity(cliente);
	}
	
	public void bajaCliente(Cliente cliente)
	{
		cliente.setInactivo(true);
		ClienteDAO.saveEntity(cliente);
	}
	
	public void generarCotizacion(CotizacionDTO cotDTO)
	{
		Cotizacion cot = CotizacionDAO.getCotizacion(cotDTO.getId());
		if (cot != null)
		{
			Mensajes men = null;
			for (ItemCotizacion itCot : cot.getItems())
			{
				ItemProveedor itProv = ComparativaPrecios.getInstancia().getMejorPrecio(itCot.getDTO());
				if (itProv != null)
				{
					itCot.setItProveedor(itProv);
					itCot.setCotizado(true);
				}
				else
				{
					if (men == null)
					{
						men = new Mensajes();
					}
					men.setCli(cot.getCliente());
					men.setTexto("Rodamiento: " + itCot.getRod().getCodigoSKF() + ". No se ha podido cotizar. Se rechaza la Cotización " + Integer.toString(cot.getId()));
				}
			}
			if (men == null)
			{
				cot.setEstado("Armada");
				CotizacionesXML.generarXMLArmarCotizacion(CotizacionDAO.saveCotizacion(cot));
			}
			else
			{
				cot.setEstado("Rechazada");
				MensajesDAO.saveEntity(men);
			}
		}
	}
	
	public Cotizacion aceptarCotizacion(Cotizacion cot)
	{
		cot.aceptar();
		return CotizacionDAO.saveCotizacion(cot);
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
	
	public PedVentaDTO crearPedidoVenta(Cotizacion cot)
	{
		PedVenta pedVta = new PedVenta();
		pedVta.setCotizacion(cot);
		pedVta.generarItemsDesdeCotizacion();
		if (!pedVta.estaCompleto())
		{
			pedVta.setEstado("Pendiente");
		}
		else
		{
			Mensajes mensaje = new Mensajes();
			mensaje.setTexto("Pedido " + pedVta.getId() + " esta completo! ");
			mensaje.setCli(pedVta.getCotizacion().getCliente());
			MensajesDAO.saveEntity(Mensajes.class);
		}
		pedVta.setoVenta(this);
		pedidos.add(pedVta);
		PedVentaDAO.savePedVenta(pedVta);
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
		return CotizacionDAO.getCotizacionesDeCliente(nroCliente);
	}
	
	public OVentaDTO getDTO()
	{
		OVentaDTO ovDTO = new OVentaDTO();
		ovDTO.setDireccion(this.direccion);
		ovDTO.setId(this.id);
		ovDTO.setNombre(this.nombre);
		return ovDTO;
	}
	
	public void completarPedidoVenta(BultoDTO bultoDTO)
	{
		
		// Por cada itembulto leer cada item de los pedidos pendientes (loopear).
		// Verificar que el pedido sea del codigoSKF del itembulto.
		// Si es, verifico si existe cantidad pendiente. Si existe, actualizo cantidad recibida.
		// Verifico si el pedido esta completo. Si lo esta, grabo nuevo mensaje de "Pedido De venta completo"
		
		List<PedVenta> pedidos = PedVentaDAO.getListaPedVentaPendientesPorOVenta(this.id);
		
		for (PedVenta pedido : pedidos)
		{
			for (ItemPedVenta item : pedido.getItems())
			{
				for (ItemBultoDTO itemBultoDTO : bultoDTO.getItems())
				{
					if (itemBultoDTO.getRodamiento().getCodigoSKF().equals(item.getItCotizacion().getRod().getCodigoSKF()))
					{
						int pendiente = item.getItCotizacion().getCantidad() - item.getCantRecibida();
						
						if (pendiente > 0)
						{
							if (itemBultoDTO.getCantidad() >= pendiente)
							{
								item.setCantRecibida(item.getItCotizacion().getCantidad());
								itemBultoDTO.setCantidad(itemBultoDTO.getCantidad() - pendiente);
							}
							else
							{
								item.setCantRecibida(item.getCantRecibida() + itemBultoDTO.getCantidad());
								itemBultoDTO.setCantidad(0);
							}
						}
					}
				}
				PedVentaDAO.saveEntity(pedido);
			}
			
			if (pedido.estaCompleto())
			{
				Mensajes mensaje = new Mensajes();
				mensaje.setTexto("Pedido " + pedido.getId() + " esta completo! ");
				mensaje.setCli(pedido.getCotizacion().getCliente());
				MensajesDAO.saveEntity(mensaje);
			}
		}
		
	}
	
	public Cotizacion rechazarCotizacion(Cotizacion cot)
	{
		cot.setEstado("Rechazada");
		return CotizacionDAO.saveCotizacion(cot);
	}
}