package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Dao.CotizacionDAO;
import bean.CotizacionDTO;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(nullable = false, length = 50)
	public String nombre;

	@Column(nullable = false, length = 50)
	public String direccion;

	public void aceptarCotizacion(CotizacionDTO cotDTO) {
		Cotizacion cot = CotizacionDAO.getCotizacion(cotDTO.getId());

		if (cot != null) {
			cot.aceptar();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}