package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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

import bean.ClienteDTO;
import bean.FormaDePagoDTO;

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
	
	@Column
	private boolean inactivo;
	
	@ManyToMany
	@JoinTable(name = "Clientes_Formas", joinColumns = @JoinColumn(name = "idCliente"), inverseJoinColumns = @JoinColumn(name = "idForma"))
	private List<FormaPago> formas;
	
	@ManyToOne
	@JoinColumn(name = "idOVenta", referencedColumnName = "id")
	private OVenta oVenta;
	
	Cliente()
	{
		formas = new ArrayList<>();
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
		
		List<FormaDePagoDTO> formasDTO = new Vector<FormaDePagoDTO>();
		for (FormaPago forma : formas)
		{
			formasDTO.add(forma.getDTO());
		}
		
		cliDTO.setFormasDepago(formasDTO);
		return cliDTO;
	}
	
	public Cliente(OVenta oventa, ClienteDTO clienteDTO)
	{
		formas = new ArrayList<>();
		modificar(oventa, clienteDTO);
	}
	
	public void modificar(OVenta oventa, ClienteDTO clienteDTO)
	{
		this.nombre = clienteDTO.getNombre();
		this.direccion = clienteDTO.getDireccion();
		this.oVenta = oventa;
		
		for (FormaDePagoDTO forma : clienteDTO.getFormasDepago())
		{
			formas.add(new FormaPago(forma));
		}
	}
}