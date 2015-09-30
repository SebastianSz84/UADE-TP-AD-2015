package Entities;

public class ItemProveedor
{
	private String codigo;
	private float precio;
	private String condiciones;
	private boolean disponible;
	private Rodamiento rodamiento;
	
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
	
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public Rodamiento getRodamiento()
	{
		return rodamiento;
	}
}
