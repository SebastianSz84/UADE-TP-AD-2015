package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Dao.OVentaDAO;
import bean.ClienteDTO;

@Entity
@Table(name = "Cliente")
public class Cliente
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@Column(nullable = false, length = 50)
	private String direccion;
	
	@ManyToMany
	@JoinTable(name = "Clientes_Formas", joinColumns = @JoinColumn(name = "idCliente"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<FormaPago> formas;
	
	@ManyToOne
	@JoinColumn(name = "idOVenta")
	private OVenta oVenta;
	
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
	
	public OVenta getOVenta()
	{
		return oVenta;
	}
	
	public void setOventa(OVenta oVenta)
	{
		this.oVenta = oVenta;
	}
	
	public ClienteDTO getDTO()
	{
		ClienteDTO cliDTO = new ClienteDTO();
		cliDTO.setDireccion(this.direccion);
		cliDTO.setNombre(this.nombre);
		cliDTO.setOVenta(this.oVenta.getDTO());
		cliDTO.setId(this.id);
		return cliDTO;
	}
	
	public Cliente(ClienteDTO clienteDTO)
	{
		modificar(clienteDTO);
	}
	
	public void modificar(ClienteDTO clienteDTO)
	{
		this.nombre = clienteDTO.getNombre();
		this.direccion = clienteDTO.getDireccion();
		this.oVenta = OVentaDAO.getOVenta(clienteDTO.getId());
	}
}