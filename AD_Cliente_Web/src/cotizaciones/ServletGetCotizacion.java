package cotizaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RMI.CCentral;
import RMI.GestionRodamientos;
import bean.CotizacionDTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServletGetCotizacion
 */
public class ServletGetCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGetCotizacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nroCliente = Integer.parseInt(request.getParameter("nroCliente"));
		List<CotizacionDTO> lista = GestionRodamientos.getInstancia().getSolicitudesConformadasPorCliente(nroCliente);
		String listaGson = new Gson().toJson(lista);
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf8");
		response.setContentType("application/json");
		out.print(listaGson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
