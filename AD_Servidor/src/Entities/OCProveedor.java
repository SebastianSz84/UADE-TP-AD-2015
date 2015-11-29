package Entities;

import java.util.ArrayList;
import java.util.List;

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
	
	@Column(nullable = false, length = 50)
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "idCondCompra", referencedColumnName = "id")
	private CondCompra condCompra; // Ver qué onda las condiciones de compra
	
	@Column(nullable = false, length = 50)
	private String estado;
	
	@OneToMany
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
			items.add(item);
		}
		else
		{
			item.actualizarCantidad(cantidad);
		}
		
		/*
		 * ItemOCProveedor item = new ItemOCProveedor(); item.setCantidad(cantidad); item.setRodamiento(rodamiento); items.add(item);
		 */
		
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
	
	public String getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public CondCompra getCondCompra()
	{
		return condCompra;
	}
	
	public void setCondCompra(CondCompra condCompra)
	{
		this.condCompra = condCompra;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
}