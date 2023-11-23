<%@page import="com.cliente.servicios.ServiceUsuario"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@page import="com.cliente.contexto.Fabrica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.getSession().removeAttribute("errorMensaje");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyecto PInfra</title>
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/Proyecto-PInfra/index.jsp">Inicio</a></li>
				<li><a href="/Proyecto-PInfra/pages/login/index.jsp">Iniciar sesión</a></li>
				<li><a href="/Proyecto-PInfra/pages/registro/registro.jsp">Registrarme</a></li>
				
				<li>
					<%
					if (request.getSession().getAttribute("usuarioLogueado") != null) {
						Usuario usuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
					%>
					<span>Bienvenido desde la sesión: <%=usuarioLogueado.getNombreUsuario()%></span>
					<%
					}
					%>
				</li>
				<li>
					<%
					if (Fabrica.getUsuarioLogueado() != null) {
					%>
					<span>Bienvenido desde la fabrica: <%=Fabrica.getUsuarioLogueado().getNombreUsuario()%></span>
					<%
					}
					%>
				</li>
			</ul>
		</nav>
	</header>

	<main>
		<h2>Bienvenido a tu Proyecto PInfra</h2>
		<p>Descubre un mundo de oportunidades y gestiona tus usuarios de manera eficiente.</p>
		
	</main>
</body>
</html>
