package clientes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.BusinessDelegate;

public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer nroCliente = Integer.parseInt(request.getParameter("nroCliente"));

		boolean clienteExiste = BusinessDelegate.getInstancia().checkearSiClienteExiste(nroCliente);
		PrintWriter out = response.getWriter();
		out.print(clienteExiste);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
