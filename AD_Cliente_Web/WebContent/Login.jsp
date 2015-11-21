<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<H2 ALIGN="CENTER">Ingrese Nro Cliente</H2>
		
		<form ACTION="/AD_Cliente_Web/servletLogin" METHOD="get">
			<label> Nro Cliente : </label> <input type="text" name="nroCliente" id="txtNroCliente">
			<center>
				<input TYPE="submit" VALUE="Conectar" onclick="return checkNroCliente();"></input>
			</center>
		</form>
</body>

<script>
function checkNroCliente() {
	nroCliente = document.getElementById("txtNroCliente").value;
	if (nroCliente == ""){
		alert('Nro cliente vacio!');
		return false;
	}
	return true;
}
</script>


</html>