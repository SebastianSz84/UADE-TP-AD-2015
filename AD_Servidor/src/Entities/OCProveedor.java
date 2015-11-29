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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OCProveedor")
public class OCProveedor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "codigoProveedor")
	private Proveedor proveedor;
	
	@Column(length = 100)
	private String condCompra;
	
	@Column(nullable = false, length = 50)
	private String estado;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idOCProveedor")
	private List<ItemOCProveedor> items;
	
	public List<ItemOCProveedor> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemOCProveedor> items)
	{
		this.items = items;
	}
	
	public OCProveedor()
	{
		items = new ArrayList<ItemOCProveedor>();
	}
	
	public void agregarAOC(Rodamiento rodamiento, int cantidad)
	{
		ItemOCProveedor item = buscarRodamientoEnOC(rodamiento.getCodigoSKF());
		if (item == null)
		{
			item = new ItemOCProveedor();
			item.setCantidad(cantidad);
			item.setRodamiento(rodamiento);
			item.setOcProveedor(this);
			items.add(item);
		}
		else
		{
			item.actualizarCantidad(cantidad);
		}
	}
	
	public ItemOCProveedor buscarRodamientoEnOC(String SKF)
	{
		for (ItemOCProveedor item : items)
		{
			if (item.getRodamiento().getCodigoSKF().equals(SKF))
			{
				return item;
			}
		}
		return null;
	}
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
	
	public String getCondCompra()
	{
		return condCompra;
	}
	
	public void setCondCompra(String condCompra)
	{
		this.condCompra = condCompra;
	}
}