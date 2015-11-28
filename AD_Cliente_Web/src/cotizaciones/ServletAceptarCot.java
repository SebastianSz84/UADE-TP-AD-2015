package cotizaciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.ParserJson;

import com.google.gson.JsonObject;

import controlador.BusinessDelegate;

/**
 * Servlet implementation class ServletAceptarCot
 */
public class ServletAceptarCot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAceptarCot() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject jObj = ParserJson.parsearJsonObject(request);

		String strCot = jObj.get("idCotizacion").getAsString();

		if (BusinessDelegate.getInstancia().aceptarCotizacion(Integer.parseInt(strCot))) {
			// Actualizar response con texto de OK.
		} else {
			// Actualizar response con texto de Not OK.
		}
	}
}