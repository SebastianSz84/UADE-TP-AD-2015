package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemProveedorId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "codigoProveedor")
	private Proveedor proveedor;
	
	@Column(length = 50, nullable = false)
	private String codigo;
	
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
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
}