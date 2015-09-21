package Entities;

import javax.persistence.*;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int codigo;

	@Column (nullable=false, length=250)
	public String nombre;

	@Column (nullable=false, length=250)
	public String direccion;
	
}
