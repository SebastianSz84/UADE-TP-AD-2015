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
import bean.ItemCotizacionDTO;
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
		List<RodamientoDTO> lista = BusinessDelegate.getInstancia().getListaRodamientos();
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
		List<ItemCotizacionDTO> itemsCotLista = new ArrayList<>();
		for (int i = 0; i < itemsCot.size(); i++) {
			ItemCotizacionDTO itCot = new ItemCotizacionDTO();
			itCot.setCantidad(itemsCot.get(i).getAsJsonObject().get("cantidad").getAsInt());
			RodamientoDTO rodDTO = new RodamientoDTO();
			rodDTO.setCodigoSKF(itemsCot.get(i).getAsJsonObject().get("codigoSKF").getAsString());
			itCot.setRod(rodDTO);
			itemsCotLista.add(itCot);
		}
		if (BusinessDelegate.getInstancia().solicitarCotizacion(nroCliente, itemsCotLista)) {
			// Actualizar response con texto de OK.
		} else {
			// Actualizar response con texto de Not OK.
		}
	}
}