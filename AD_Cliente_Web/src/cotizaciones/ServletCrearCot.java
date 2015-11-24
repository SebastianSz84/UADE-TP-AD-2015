package cotizaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.ParserJson;
import RMI.GestionRodamientos;
import bean.ItemCotizacionWeb;
import bean.RodamientoDTO;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import controlador.BusinessDelegate;

/**
 * Servlet implementation class servletCotizaciones
 */
public class ServletCrearCot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCrearCot() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RodamientoDTO> lista = GestionRodamientos.getInstancia().getListaRodamientos();
		String listaGson = new Gson().toJson(lista);
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf8");
		response.setContentType("application/json");
		out.print(listaGson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject jObj = ParserJson.parsearJsonObject(request);
		int nroCliente = jObj.get("nroCliente").getAsInt();

		JsonArray itemsCot = jObj.getAsJsonArray("items");
		List<ItemCotizacionWeb> itemsCotLista = new ArrayList<ItemCotizacionWeb>();
		for (int i = 0; i < itemsCot.size(); i++) {
			// while (itemsCot.iterator().hasNext()) {
			ItemCotizacionWeb itCot = new ItemCotizacionWeb();
			itCot.setCantidad(itemsCot.get(i).getAsJsonObject().get("cantidad").getAsInt());
			itCot.setCodigoSKF(itemsCot.get(i).getAsJsonObject().get("codigoSKF").getAsString());
			// itCot.setCantidad(itemsCot.iterator().next().getAsJsonObject().get("cantidad").getAsInt());
			// itCot.setCodigoSKF(itemsCot.iterator().next().getAsJsonObject().get("codigoSKF").getAsString());
			itemsCotLista.add(itCot);
		}
		BusinessDelegate.getInstancia().solicitarCotizacion(nroCliente, itemsCotLista);
	}
}