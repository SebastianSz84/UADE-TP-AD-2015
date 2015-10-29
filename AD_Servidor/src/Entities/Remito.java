package Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Remitos")
public class Remito
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String codigo;
	private Date fecha;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idRodamiento")
	private List<Rodamiento> rodamientosComprados;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
	
	public List<Rodamiento> getRodamientosComprados()
	{
		return rodamientosComprados;
	}
	
	public void setRodamientosComprados(List<Rodamiento> rodamientosComprados)
	{
		this.rodamientosComprados = rodamientosComprados;
	}
	
	public boolean contieneRodamiento(Rodamiento rodamientoComprado)
	{
		return rodamientosComprados.contains(rodamientoComprado);
	}
	
}
