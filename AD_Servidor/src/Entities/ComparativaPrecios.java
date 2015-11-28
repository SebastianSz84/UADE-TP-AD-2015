package Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import Dao.ComparativaPreciosDAO;
import bean.ItemCotizacionDTO;

@Entity
@Table(name = "ComparativaPrecios")
public class ComparativaPrecios
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private Date fecha;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ItemsComparativa", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns =
	{
		@JoinColumn(name = "idItemProveedor", referencedColumnName = "id")
	})
	private List<ItemProveedor> items;
	
	private static ComparativaPrecios instancia;
	
	public ItemProveedor getMejorPrecio(ItemCotizacionDTO itCotDTO)
	{
		for (ItemProveedor itPro : this.items)
		{
			if (itPro.getRodamiento().getCodigoSKF().equals(itCotDTO.getRod().getCodigoSKF()))
			{
				return itPro;
			}
		}
		return null;
	}
	
	public ItemProveedor buscarRodamiento(String codigoSKF)
	{
		for (ItemProveedor item : items)
		{
			if (item.getRodamiento().getCodigoSKF().equals(codigoSKF))
			{
				return item;
			}
		}
		return null;
	}
	
	public void ActualizarPrecio(ItemProveedor itemProveedorFinal)
	{
		ItemProveedor item = buscarRodamiento(itemProveedorFinal.getRodamiento().getCodigoSKF());
		if (item != null)
		{
			items.remove(item);
			items.add(itemProveedorFinal);
		}
		else
		{
			items.add(itemProveedorFinal);
		}
	}
	
	public static ComparativaPrecios getInstancia()
	{
		if (instancia == null)
		{
			instancia = ComparativaPreciosDAO.getComparativa();
		}
		return instancia;
	}
	
	public static void setInstancia(ComparativaPrecios instancia)
	{
		ComparativaPrecios.instancia = instancia;
	}
	
	public List<ItemProveedor> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemProveedor> items)
	{
		this.items = items;
	}
	
	public ItemProveedor getItemSKF(String codigoSKF)
	{
		for (ItemProveedor itPr : items)
		{
			if (itPr.getRodamiento().getCodigoSKF().equals(codigoSKF))
			{
				return itPr;
			}
		}
		return null;
	}
	
	private ComparativaPrecios()
	{
	}
	
	public boolean deleteItems()
	{
		return ComparativaPreciosDAO.deleteItems();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
}