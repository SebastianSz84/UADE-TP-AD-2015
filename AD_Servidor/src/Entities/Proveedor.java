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

import bean.ProveedorDTO;

@Entity
@Table(name = "Proveedor")
public class Proveedor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoProveedor;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigoProveedor")
	private List<ItemProveedor> items;
	
	@Column
	private String direccion;
	
	@Column
	private String nombre;
	
	@Column
	private boolean inactivo;
	
	public boolean isInactivo()
	{
		return inactivo;
	}
	
	public void setInactivo(boolean inactivo)
	{
		this.inactivo = inactivo;
	}
	
	public Proveedor()
	{
		items = new ArrayList<ItemProveedor>();
	}
	
	public Proveedor(ProveedorDTO proveedorDTO)
	{
		this();
		
		this.modificar(proveedorDTO);
	}
	
	public void modificar(ProveedorDTO proveedorDTO)
	{
		this.direccion = proveedorDTO.getDireccion();
		this.nombre = proveedorDTO.getNombre();
	}
	
	public int getCodigoProveedor()
	{
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(int codigoProveedor)
	{
		this.codigoProveedor = codigoProveedor;
	}
	
	public List<ItemProveedor> getItems()
	{
		return this.items;
	}
	
	public void setItems(List<ItemProveedor> items)
	{
		this.items = items;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public ItemProveedor getItemProveedor(Rodamiento rodamiento)
	{
		for (ItemProveedor itemProveedor : items)
		{
			if (itemProveedor.sosElRodamiento(rodamiento.getCodigoSKF()))
			{
				return itemProveedor;
			}
		}
		return null;
	}
	
	public Rodamiento find(String codigoSKF)
	{
		for (ItemProveedor itemProveedor : items)
		{
			if (itemProveedor.sosElRodamiento(codigoSKF))
			{
				return itemProveedor.getRodamiento();
			}
		}
		return null;
	}
	
	public void agregarItem(String codigoItem, float precio, String condiciones, boolean disponible, Rodamiento rodamiento)
	{
		ItemProveedor item = buscarItem(codigoItem);
		if (item != null)
		{
			item.actualizar(precio, condiciones, disponible, rodamiento);
		}
		else
		{
			items.add(new ItemProveedor(this, codigoItem, precio, condiciones, disponible, rodamiento));
		}
		
	}
	
	public ItemProveedor buscarItem(String codigoItem)
	{
		for (ItemProveedor item : items)
		{
			if (item.getCodigo().equals(codigoItem))
			{
				return item;
			}
		}
		return null;
	}
	
	public ProveedorDTO getDTO()
	{
		ProveedorDTO provDTO = new ProveedorDTO();
		provDTO.setCodigoProveedor(this.codigoProveedor);
		return provDTO;
	}
	
}