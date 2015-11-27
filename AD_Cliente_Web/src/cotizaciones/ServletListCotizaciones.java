package cotizaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.ParserJson;
import RMI.GestionRodamientos;
import bean.CotizacionDTO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ServletListCotizaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListCotizaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject jObj = ParserJson.parsearJsonObject(request);
		Integer nroCliente = jObj.get("nroCliente").getAsInt();

		List<CotizacionDTO> lista = GestionRodamientos.getInstancia().getSolicitudesConformadasPorCliente(nroCliente);
		String listaGson = new Gson().toJson(lista);
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf8");
		response.setContentType("application/json");
		out.print(listaGson);
	}
}
