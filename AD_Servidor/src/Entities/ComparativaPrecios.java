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
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idComparativa")
	private List<ItemComparativa> items;
	
	private static ComparativaPrecios instancia;
	
	public ItemProveedor getMejorPrecio(ItemCotizacionDTO itCotDTO)
	{
		for (ItemComparativa itPro : this.items)
		{
			if (itPro.getRodamiento().getCodigoSKF().equals(itCotDTO.getRod().getCodigoSKF()))
			{
				return itPro.getItemProveedor();
			}
		}
		return null;
	}
	
	public ItemProveedor buscarRodamiento(String codigoSKF)
	{
		for (ItemComparativa item : items)
		{
			if (item.getRodamiento().getCodigoSKF().equals(codigoSKF))
			{
				return item.getItemProveedor();
			}
		}
		return null;
	}
	
	public void ActualizarPrecio(ItemProveedor itemProveedorFinal)
	{
		ItemProveedor item = buscarRodamiento(itemProveedorFinal.getRodamiento().getCodigoSKF());
		if (item != null)
		{
			for (ItemComparativa itemComp : items)
			{
				if (itemComp.getItemProveedor().getRodamiento().getCodigoSKF() == itemProveedorFinal.getRodamiento().getCodigoSKF())
				{
					items.remove(itemComp);
					break;
				}
			}
		}
		ItemComparativa nuevo = new ItemComparativa();
		nuevo.setComparativa(this);
		nuevo.setItemProveedor(itemProveedorFinal);
		nuevo.setRodamiento(itemProveedorFinal.getRodamiento());
		items.add(nuevo);
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
	
	public List<ItemComparativa> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemComparativa> items)
	{
		this.items = items;
	}
	
	public ItemProveedor getItemSKF(String codigoSKF)
	{
		for (ItemComparativa itPr : items)
		{
			if (itPr.getRodamiento().getCodigoSKF().equals(codigoSKF))
			{
				return itPr.getItemProveedor();
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
	
	public boolean rodamientoValido(String codigo)
	{
		for (ItemComparativa itPr : items)
		{
			if (itPr.getItemProveedor().getCodigo().equals(codigo))
			{
				return true;
			}
		}
		return false;
	}
}