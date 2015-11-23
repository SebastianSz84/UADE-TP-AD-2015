package cotizaciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RMI.GestionRodamientos;
import bean.RodamientoDTO;

import com.google.gson.Gson;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.print("asdasf");
		RodamientoDTO[] cosas = new Gson().fromJson(request.getReader().readLine(), RodamientoDTO[].class);
		for( RodamientoDTO rodDTO : cosas ){
			System.out.println(rodDTO.getTipo()+" "+rodDTO.getCodigoSKF());
		}
	}

}