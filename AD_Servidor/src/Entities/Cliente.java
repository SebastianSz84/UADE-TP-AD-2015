package Entities;

import javax.persistence.*;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int codigo;

	@Column (nullable=false, length=50)
	public String nombre;

	@Column (nullable=false, length=50)
	public String direccion;
	
	@ManyToOne
	@JoinColumn(name="idOVenta")
	public OVenta OficinaDeVenta;
}
