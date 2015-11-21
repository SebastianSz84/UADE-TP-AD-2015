<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cotizaciones</title>
</head>
<body>
	<label> Nro Cliente : </label> <%= request.getParameter("nroCliente")  %> <br/>
	
	<label> Cotizaciones conformadas: </label> <br/>
	
	<form ACTION="/AD_Cliente_Web/servletListarCotizaciones" METHOD="get">
		<INPUT TYPE="submit" VALUE="Crear Cotizacion"></INPUT>
	</form>
</body>
</html>