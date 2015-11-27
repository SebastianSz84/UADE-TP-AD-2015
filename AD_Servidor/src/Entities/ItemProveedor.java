package Entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bean.ItemProveedorDTO;

@Entity
@Table(name = "ItemProveedor")
public class ItemProveedor
{
	@EmbeddedId
	private ItemProveedorId id;
	
	@Column
	private float precio;
	
	@Column
	private String condiciones;
	
	@Column
	private boolean disponible;
	
	@OneToOne
	@JoinColumn(name = "codigoSKF")
	private Rodamiento rodamiento;
	
	public ItemProveedor(Proveedor proveedor, String codigo, float precio, String condiciones, boolean disponible, Rodamiento rodamiento)
	{
		ItemProveedorId itProvId = new ItemProveedorId();
		itProvId.setCodigo(codigo);
		itProvId.setProveedor(proveedor);
		this.setId(itProvId);
		this.precio = precio;
		this.condiciones = condiciones;
		this.disponible = disponible;
		this.rodamiento = rodamiento;
	}
	
	public boolean existeRodamiento(String codigoSKF)
	{
		return true;
	}
	
	public void actualizarCantidad(Rodamiento rodamiento, int cantidad)
	{
		
	}
	
	public boolean sosElRodamiento(String codigoSKF)
	{
		return rodamiento.sosRodamiento(codigoSKF);
	}
	
	public void actualizar(float precio, String condiciones, boolean disponible, Rodamiento rodamiento)
	{
		this.setCondiciones(condiciones);
		this.setDisponible(disponible);
		this.setRodamiento(rodamiento);
		this.setPrecio(precio);
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento r)
	{
		this.rodamiento = r;
	}
	
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	public String getCondiciones()
	{
		return condiciones;
	}
	
	public void setCondiciones(String condiciones)
	{
		this.condiciones = condiciones;
	}
	
	public boolean isDisponible()
	{
		return disponible;
	}
	
	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	
	public ItemProveedorDTO getDTO()
	{
		ItemProveedorDTO itPrDTO = new ItemProveedorDTO(this.getRodamiento().getCodigoSKF(), this.getId().getCodigo(), this.getPrecio(), this.isDisponible(), this.getCondiciones());
		return itPrDTO;
	}
	
	public ItemProveedor()
	{
	}
	
	public ItemProveedorId getId()
	{
		return id;
	}
	
	public void setId(ItemProveedorId id)
	{
		this.id = id;
	}
}