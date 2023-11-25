<%@page import="com.cliente.servicios.ServiceUsuario"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@page import="com.cliente.contexto.Fabrica"%>
<%@page import="com.servidor.entidades.Itr"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
		<nav>
			<ul>
			<% if(Fabrica.getUsuarioLogueado().getRol().getIdRol()==1l) { %>
				<li><a href="/Proyecto-PInfra/pages/configuracion/usuarios.jsp">Gestión de Usuarios</a></li>
				<li><a href="/Proyecto-PInfra/pages/configuracion/itr.jsp">Gestión de Itrs</a></li>
				
				<% } %>
				<li><a href="/Proyecto-PInfra/index.jsp">Cerrar sesión</a></li> <!-- hay que hacer el servlet para esto! -->
			</ul>
		</nav>
	</header>

</body>
</html>