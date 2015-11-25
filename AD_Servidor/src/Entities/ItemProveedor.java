package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import bean.ItemProveedorDTO;

@Entity
@Table(name = "ItemProveedor")
public class ItemProveedor
{
	@Id
	private String codigo;
	
	@Column
	private float precio;
	
	@Column
	private String condiciones;
	
	@Column
	private boolean disponible;
	
	@ManyToOne
	@JoinColumn(name = "codigoProveedor")
	private Proveedor proveedor;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	@JoinColumn(name = "codigoSKF")
	private Rodamiento rodamiento;
	
	public ItemProveedor(String codigo, float precio, String condiciones, boolean disponible, Rodamiento rodamiento)
	{
		this.codigo = codigo;
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
	
	public String getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
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
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
	
	public ItemProveedorDTO getDTO()
	{
		ItemProveedorDTO itPrDTO = new ItemProveedorDTO(this.getRodamiento().getCodigoSKF(), this.codigo, this.getPrecio(), this.isDisponible(), this.getCondiciones());
		return itPrDTO;
	}
}
