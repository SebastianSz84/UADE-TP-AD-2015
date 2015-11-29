package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mensajes")
public class Mensajes
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idCliente")
	public Cliente cli;
	
	@Column
	public String texto;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Cliente getCli()
	{
		return cli;
	}
	
	public void setCli(Cliente cli)
	{
		this.cli = cli;
	}
	
	public String getTexto()
	{
		return texto;
	}
	
	public void setTexto(String mensaje)
	{
		this.texto = mensaje;
	}
}