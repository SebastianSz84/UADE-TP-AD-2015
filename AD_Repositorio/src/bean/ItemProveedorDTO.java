package bean;

public class ItemProveedorDTO {
	private String sku;
	private String codRodProv;
	private float precio;
	
	public ItemProveedorDTO(String sku,String codRodProve,float precio){
		this.sku = sku;
		this.codRodProv = codRodProv;
		this.precio = precio;
	}
}
