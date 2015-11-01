package Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Factura
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idCliente")
	public Cliente cli;
	
	@OneToOne
	@JoinColumn(name = "idPedidoVenta")
	public PedVenta pedido;
	
	public float getTotal()
	{
		return 0;
	}
}
