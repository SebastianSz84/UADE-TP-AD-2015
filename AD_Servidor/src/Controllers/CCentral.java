package Controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Dao.BultoDAO;
import Dao.ComparativaPreciosDAO;
import Dao.OCProveedorDAO;
import Dao.OVentaDAO;
import Dao.PedVentaDAO;
import Dao.ProveedorDAO;
import Dao.RodamientoDAO;
import Entities.Bulto;
import Entities.ComparativaPrecios;
import Entities.ItemBulto;
import Entities.ItemPedVenta;
import Entities.ItemProveedor;
import Entities.OCProveedor;
import Entities.OVenta;
import Entities.PedVenta;
import Entities.Proveedor;
import Entities.Rodamiento;
import Helper.BultosXML;
import Helper.ProveedorListaPreciosXML;
import bean.ItemPedVentaDTO;
import bean.ItemProveedorDTO;
import bean.PedVentaDTO;
import bean.ProveedorDTO;

public class CCentral
{
	private static CCentral instancia;
	
	public void altaProveedor(ProveedorDTO proveedorDTO)
	{
		Proveedor proveedor = new Proveedor(proveedorDTO);
		ProveedorDAO.saveEntity(proveedor);
	}
	
	public void bajaProveedor(int codigoProveedor)
	{
		Proveedor proveedor = buscarProveedor(codigoProveedor);
		proveedor.setInactivo(true);
		ProveedorDAO.saveEntity(proveedor);
	}
	
	public void modificacionProveedor(ProveedorDTO proveedorDTO)
	{
		Proveedor proveedor = buscarProveedor(proveedorDTO.getCodigoProveedor());
		proveedor.modificar(proveedorDTO);
		ProveedorDAO.saveEntity(proveedor);
	}
	
	public void crearOC(ItemPedVenta item)
	{
		OCProveedor oc = new OCProveedor();
		oc.agregarAOC(item.getItCotizacion().getRod(), item.getItCotizacion().getCantidad());
		oc.setProveedor(ProveedorDAO.getProveedor(item.getItCotizacion().getItProveedor().getProveedor().getCodigoProveedor()));
		OCProveedorDAO.saveEntity(oc);
	}
	
	public void ActualizarStock(String codigoSKF, int cantidad, float precio)
	{
		Rodamiento rod = buscarRodamiento(codigoSKF);
		rod.ActualizarStock(cantidad, precio);
		RodamientoDAO.saveEntity(rod);
	}
	
	private Rodamiento buscarRodamiento(String codigoSKF)
	{
		return RodamientoDAO.getRodamiento(codigoSKF);
	}
	
	public int GenerarBultosDeRodamiento(String codigoSKF, int cantidad)
	{
		Rodamiento rodamiento = RodamientoDAO.getRodamiento(codigoSKF);
		if (rodamiento == null)
			return -1;
		rodamiento.getStock().setCantidad(rodamiento.getStock().getCantidad() + cantidad);
		
		List<PedVenta> pedidosVentaPendiente = PedVentaDAO.getListaPedVentaPendientes();
		for (PedVenta pedVenta : pedidosVentaPendiente)
		{
			List<ItemPedVenta> itemsPedVenta = PedVentaDAO.listItemPedVentaByRodamiento(pedVenta.getId(), rodamiento.getCodigoSKF());
			for (ItemPedVenta itemPedVenta : itemsPedVenta)
			{
				if ((rodamiento.getStock().getCantidad() > 0))
				{
					int idOVenta = pedVenta.getCotizacion().getCliente().getOVenta().getId();
					Bulto bulto = BultoDAO.getBultoAbiertoByOV(idOVenta);
					if (bulto == null)
					{
						bulto = new Bulto();
						bulto.setEstado("Abierto");
						bulto.setOficinaDeVenta(pedVenta.getCotizacion().getCliente().getOVenta());
					}
					
					int cantidadUsada = 0;
					if (rodamiento.getStock().getCantidad() >= itemPedVenta.getItCotizacion().getCantidad())
					{
						cantidadUsada += itemPedVenta.getItCotizacion().getCantidad();
						rodamiento.getStock().setCantidad(rodamiento.getStock().getCantidad() - itemPedVenta.getItCotizacion().getCantidad());
					}
					else
					{
						cantidadUsada += rodamiento.getStock().getCantidad();
						
						rodamiento.getStock().setCantidad(0);
					}
					if (rodamiento.getStock().getCantidad() == 0)
					{
						rodamiento.getStock().setPrecio(0);
					}
					
					ItemBulto itemBulto = bulto.buscarItemParaRodamiento(rodamiento.getCodigoSKF());
					if (itemBulto != null)
					{
						itemBulto.setCantidad(itemBulto.getCantidad() + cantidadUsada);
					}
					else
					{
						bulto.agregarRodamientoComprado(rodamiento, cantidadUsada);
					}
					BultoDAO.saveEntity(bulto);
				}
			}
			
		}
		
		RodamientoDAO.saveEntity(rodamiento);
		return 0;
	}
	
	public void CerrarBultosDeRodamiento()
	{
		List<OVenta> oVentas = OVentaDAO.getAll();
		for (OVenta oVenta : oVentas)
		{
			Bulto bulto = BultoDAO.getBultoAbiertoByOV(oVenta.getId());
			
			if (bulto != null)
			{
				bulto.setEstado("Cerrado");
				BultosXML.GenerarXMLBulto(bulto);
				BultoDAO.saveEntity(bulto);
			}
		}
	}
	
	public void generarOrdenesDeCompra(List<PedVentaDTO> pedidos)
	{
		List<OCProveedor> listaOCs = new ArrayList<OCProveedor>();
		for (PedVentaDTO pedido : pedidos)
		{
			for (ItemPedVentaDTO item : pedido.getItems())
			{
				if (item.getCantRecibida() != item.getItCotizacion().getCantidad())
				{
					int cantidad = item.getItCotizacion().getCantidad() - item.getCantRecibida();
					OCProveedor ocProv = buscarOCPorProveedor(listaOCs, item.getItCotizacion().getItProveedor().getIdProveedor());
					if (ocProv != null)
					{
						ocProv.agregarAOC(RodamientoDAO.getRodamiento(item.getItCotizacion().getRod().getCodigoSKF()), cantidad);
					}
					else
					{
						OCProveedor ocProvNueva = new OCProveedor();
						ocProvNueva.agregarAOC(RodamientoDAO.getRodamiento(item.getItCotizacion().getRod().getCodigoSKF()), cantidad);
						ocProvNueva.setEstado("Abierta");
						ocProvNueva.setProveedor(ProveedorDAO.getProveedor(item.getItCotizacion().getItProveedor().getIdProveedor()));
						listaOCs.add(ocProvNueva);
					}
				}
			}
		}
		for (OCProveedor ocProv : listaOCs)
		{
			int i = 1;
			ocProv.setEstado("Liberada");
			ocProv.setCondCompra("Condiciones de Compra " + Integer.toString(i));
			OCProveedorDAO.saveOCProveedor(ocProv);
			i++;
		}
	}
	
	private OCProveedor buscarOCPorProveedor(List<OCProveedor> listaOCs, int codigoProveedor)
	{
		for (OCProveedor ocProv : listaOCs)
		{
			if (ocProv.getProveedor().getCodigoProveedor() == codigoProveedor)
			{
				return ocProv;
			}
		}
		return null;
	}
	
	public void publicarListaDePreciosFinal()
	{
		ComparativaPrecios.getInstancia().deleteItems();
		ComparativaPrecios.getInstancia().setFecha(Calendar.getInstance().getTime());
		for (Rodamiento rod : RodamientoDAO.getListaRodamientos())
		{
			ItemProveedor mejorPrecio = null;
			Proveedor mejorProveedor = null;
			for (Proveedor prov : ProveedorDAO.getListaProveedores())
			{
				ItemProveedor itemProv = prov.getItemProveedor(rod);
				if (itemProv != null && (mejorPrecio == null || mejorPrecio.getPrecio() < itemProv.getPrecio()))
				{
					mejorPrecio = itemProv;
					mejorProveedor = prov;
				}
			}
			
			if (mejorPrecio != null && mejorProveedor != null)
			{
				ComparativaPrecios.getInstancia().ActualizarPrecio(mejorPrecio);
			}
		}
		ComparativaPreciosDAO.saveComparativa(ComparativaPrecios.getInstancia());
	}
	
	public void generarListaDePrecioProveedorAutomatica(String archivoProveedor, int codigoProveedor)
	{
		Proveedor proveedor = buscarProveedor(codigoProveedor);
		if (proveedor != null)
		{
			ProveedorDTO dto = ProveedorListaPreciosXML.leerArchivoListaPrecios(archivoProveedor);
			for (ItemProveedorDTO itemDTO : dto.getRodamientos())
			{
				Rodamiento rod = buscarRodamiento(itemDTO.getSKF());
				if (rod != null)
				{
					proveedor.agregarItem(itemDTO.getCodRodProv(), itemDTO.getPrecio(), itemDTO.getCondiciones(), itemDTO.getDisponible(), rod);
				}
			}
			if (ProveedorDAO.saveEntity(proveedor) != null)
			{
				publicarListaDePreciosFinal();
			}
			
		}
	}
	
	public Proveedor buscarProveedor(int codigoProveedor)
	{
		return ProveedorDAO.getProveedor(codigoProveedor);
	}
	
	public static CCentral getInstancia()
	{
		if (instancia == null)
		{
			instancia = new CCentral();
		}
		return instancia;
	}
	
	public static void setInstancia(CCentral instancia)
	{
		CCentral.instancia = instancia;
	}
	
	public void agregarItemAListaProveedor(ItemProveedorDTO itemProveedorDTO)
	{
		Proveedor proveedor = buscarProveedor(itemProveedorDTO.getIdProveedor());
		if (proveedor != null)
		{
			Rodamiento rod = buscarRodamiento(itemProveedorDTO.getSKF());
			if (rod != null)
			{
				ItemProveedor item = proveedor.buscarItem(itemProveedorDTO.getCodRodProv());
				if (item == null)
				{
					proveedor.agregarItem(itemProveedorDTO.getCodRodProv(), itemProveedorDTO.getPrecio(), itemProveedorDTO.getCondiciones(), itemProveedorDTO.getDisponible(), rod);
				}
				else
				{
					item.actualizar(itemProveedorDTO.getPrecio(), itemProveedorDTO.getCondiciones(), itemProveedorDTO.getDisponible(), rod);
				}
			}
		}
		ProveedorDAO.saveEntity(proveedor);
		
		publicarListaDePreciosFinal();
	}
	
	public ProveedorDTO getProveedorDTO(int id)
	{
		Proveedor proveedor = ProveedorDAO.getProveedor(id);
		if (proveedor != null)
			return proveedor.getDTO();
		return null;
		
	}
}