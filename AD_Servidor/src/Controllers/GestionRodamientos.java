package Controllers;

import java.io.File;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Dao.ClienteDAO;
import Dao.CotizacionDAO;
import Dao.FormaPagoDAO;
import Dao.OVentaDAO;
import Dao.RodamientoDAO;
import Entities.Cliente;
import Entities.ComparativaPrecios;
import Entities.Cotizacion;
import Entities.FormaPago;
import Entities.ItemCotizacion;
import Entities.OVenta;
import Entities.Rodamiento;
import Entities.Stock;
import Helper.BultosXML;
import Helper.CotizacionesXML;
import bean.BultoDTO;
import bean.ClienteDTO;
import bean.CotizacionDTO;
import bean.FormaDePagoDTO;
import bean.ItemCotizacionDTO;
import bean.OVentaDTO;
import bean.PedVentaDTO;
import bean.RodamientoDTO;

public class GestionRodamientos implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GestionRodamientos instancia;
	private List<OVenta> oventas = new Vector<OVenta>();
	
	private GestionRodamientos()
	{
	}
	
	public List<RodamientoDTO> getListaRodamientos() throws RemoteException
	{
		List<RodamientoDTO> listaRodDTO = new ArrayList<>();
		for (Rodamiento rodamiento : RodamientoDAO.getListaRodamientos())
		{
			listaRodDTO.add(rodamiento.getDTO());
		}
		return listaRodDTO;
	}
	
	public boolean solicitarCotizacion(int nroCliente, List<ItemCotizacionDTO> itemsCotLista) throws RemoteException
	{
		Cliente cli = ClienteDAO.getCliente(nroCliente);
		if (cli != null)
		{
			Cotizacion cot = new Cotizacion();
			cot.setFecha(Calendar.getInstance().getTime());
			cot.setEstado("Pendiente");
			cot.setCliente(cli);
			List<ItemCotizacion> listaItems = new ArrayList<>();
			for (ItemCotizacionDTO itCotDTO : itemsCotLista)
			{
				{
					Rodamiento rod = RodamientoDAO.getRodamiento(itCotDTO.getRod().getCodigoSKF());
					if (rod != null)
					{
						ItemCotizacion itCot = new ItemCotizacion();
						itCot.setCantidad(itCotDTO.getCantidad());
						itCot.setRod(rod);
						itCot.setCot(cot);
						itCot.setCotizado(false);
						listaItems.add(itCot);
					}
				}
			}
			cot.setItems(listaItems);
			return CotizacionesXML.generarXMLSolicitudCotizacion(CotizacionDAO.saveCotizacion(cot));
		}
		return false;
	}
	
	public void armarCotizacones()
	{
		List<OVenta> oVentas = OVentaDAO.getAll();
		for (OVenta ov : oVentas)
		{
			File[] files = CotizacionesXML.obtenerXMLCotizacionParaArmar(ov);
			if (files != null)
			{
				for (int i = 0; i < files.length; i++)
				{
					CotizacionDTO cotDTO = CotizacionesXML.leerXMLCotizacionParaArmar(files[i]);
					ov.generarCotizacion(cotDTO);
					
					files[i].delete();
				}
			}
		}
	}
	
	public String aceptarCotizacion(int nroCotizacion) throws RemoteException
	{
		Cotizacion cot = CotizacionDAO.getCotizacion(nroCotizacion);
		if (cot != null)
		{
			OVenta ov = OVentaDAO.getOVenta(cot.getCliente().getOVenta().getId());
			
			if (ov != null)
			{
				CotizacionesXML.borrarXMLCotizacionAceptada(cot);
				
				boolean esAceptable = true;
				List<ItemCotizacionDTO> itemsCotLista = new ArrayList<>();
				for (ItemCotizacion item : cot.getItems())
				{
					if (!ComparativaPrecios.getInstancia().rodamientoValido(item.getItProveedor().getCodigo()))
					{
						esAceptable = false;
					}
					else
					{
						itemsCotLista.add(item.getDTO());
					}
				}
				
				if (esAceptable && CotizacionesXML.generarXMLAceptarCotizacion(ov.aceptarCotizacion(cot)))
				{
					return "Aceptada";
				}
				else
				{
					ov.rechazarCotizacion(cot);
					if (itemsCotLista.size() > 0)
					{
						if (solicitarCotizacion(cot.getCliente().getId(), itemsCotLista))
						{
							return "Nueva";
						}
					}
				}
			}
		}
		return "Error";
	}
	
	public void procesarCotAceptadas()
	{
		List<OVenta> oVentas = OVentaDAO.getAll();
		for (OVenta ov : oVentas)
		{
			File[] files = CotizacionesXML.obtenerXMLCotizacionesAceptadas(ov);
			if (files != null)
			{
				List<PedVentaDTO> listaPedVta = new ArrayList<>();
				for (int i = 0; i < files.length; i++)
				{
					CotizacionDTO cotDTO = CotizacionesXML.leerXMLCotizacionAceptada(files[i]);
					if (cotDTO != null)
					{
						Cotizacion cot = CotizacionDAO.getCotizacion(cotDTO.getId());
						cot.setEstado("Procesada");
						listaPedVta.add(ov.crearPedidoVenta(cot));
						files[i].delete();
					}
				}
				if (!listaPedVta.isEmpty())
				{
					CCentral.getInstancia().generarOrdenesDeCompra(listaPedVta);
					listaPedVta.clear();
				}
			}
		}
	}
	
	public void leerXMLBultos()
	{
		oventas = OVentaDAO.getAll();
		for (OVenta ov : oventas)
		{
			File[] files = BultosXML.obtenerXMLBultos(ov);
			if (files != null)
			{
				for (int i = 0; i < files.length; i++)
				{
					BultoDTO bultoDTO = BultosXML.leerXMLBulto(files[i]);
					
					ov.completarPedidoVenta(bultoDTO);
					
					files[i].delete();
				}
			}
		}
	}
	
	public static GestionRodamientos getInstancia()
	{
		if (instancia == null)
		{
			instancia = new GestionRodamientos();
		}
		return instancia;
	}
	
	public static void setInstancia(GestionRodamientos instancia)
	{
		GestionRodamientos.instancia = instancia;
	}
	
	public List<CotizacionDTO> getSolicitudesConformadasPorCliente(int nroCliente) throws RemoteException
	{
		List<CotizacionDTO> cotizacionesDTO = new Vector<CotizacionDTO>();
		Cliente cliente = ClienteDAO.getCliente(nroCliente);
		List<Cotizacion> cotizaciones = cliente.getOVenta().listCotizacionesPorCliente(nroCliente);
		
		for (Cotizacion c : cotizaciones)
		{
			cotizacionesDTO.add(c.getDTO());
		}
		
		return cotizacionesDTO;
		
	}
	
	public boolean checkearSiClienteExiste(int nroCliente) throws RemoteException
	{
		Cliente cliente = ClienteDAO.getCliente(nroCliente);
		return cliente != null;
	}
	
	public CotizacionDTO leerCotizacion(int idCotizacion) throws RemoteException
	{
		return CotizacionDAO.getCotizacion(idCotizacion).getDTO();
	}
	
	public void altaCliente(ClienteDTO clienteDTO)
	{
		OVenta oventa = OVentaDAO.getOVenta(clienteDTO.getOVenta().getId());
		oventa.altaCliente(clienteDTO);
	}
	
	public void bajaCliente(int codigoCliente)
	{
		Cliente cliente = ClienteDAO.getCliente(codigoCliente);
		OVenta oventa = OVentaDAO.getOVenta(cliente.getOVenta().getId());
		oventa.bajaCliente(cliente);
	}
	
	public void modificacionCliente(ClienteDTO clienteDTO)
	{
		OVenta oventa = OVentaDAO.getOVenta(clienteDTO.getOVenta().getId());
		oventa.modificacionCliente(clienteDTO);
	}
	
	public OVentaDTO getOVentaDTO(int id)
	{
		OVenta oventa = OVentaDAO.getOVenta(id);
		if (oventa != null)
			return oventa.getDTO();
		return null;
	}
	
	public ClienteDTO getClienteDTO(int id)
	{
		Cliente cliente = ClienteDAO.getCliente(id);
		if (cliente != null)
			return cliente.getDTO();
		return null;
	}
	
	public FormaDePagoDTO getForma(int id)
	{
		FormaPago forma = FormaPagoDAO.getFormaPago(id);
		if (forma != null)
			return forma.getDTO();
		return null;
	}
	
	public RodamientoDTO getRodamiento(String codigoSKF)
	{
		Rodamiento rod = RodamientoDAO.getRodamiento(codigoSKF);
		if (rod != null)
		{
			return rod.getDTO();
		}
		return null;
	}
	
	public boolean altaRodamiento(RodamientoDTO rodDTO)
	{
		Rodamiento rod = new Rodamiento();
		rod.setCodigoSKF(rodDTO.getCodigoSKF());
		rod.setTipo(rodDTO.getTipo());
		Stock stk = new Stock();
		stk.setCantidad(rodDTO.getStock().getCantidad());
		stk.setPrecio(rodDTO.getStock().getPrecio());
		rod.setStock(stk);
		if (RodamientoDAO.saveRodamiento(rod) != null)
		{
			return true;
		}
		return false;
	}
	
	public boolean modificarRodamiento(RodamientoDTO rodDTO)
	{
		Rodamiento rod = RodamientoDAO.getRodamiento(rodDTO.getCodigoSKF());
		rod.setTipo(rodDTO.getTipo());
		rod.getStock().setCantidad(rodDTO.getStock().getCantidad());
		rod.getStock().setPrecio(rodDTO.getStock().getPrecio());
		if (RodamientoDAO.saveRodamiento(rod) != null)
		{
			return true;
		}
		return false;
	}
	
	public boolean bajaRodamiento(String codigoSKF)
	{
		Rodamiento rod = RodamientoDAO.getRodamiento(codigoSKF);
		if (rod != null)
		{
			rod.setInactivo(true);
			if (RodamientoDAO.saveRodamiento(rod) != null)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean existenCotAbiertasXRod(String codigoSKF)
	{
		return CotizacionDAO.getCantCotAbiertasXRod(codigoSKF) != 0;
	}
}