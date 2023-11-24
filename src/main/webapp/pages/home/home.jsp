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
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/pages/home/style.css">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/Proyecto-PInfra/pages/login/login.jsp">Iniciar
						sesión</a></li>
				<li><a href="/Proyecto-PInfra/pages/registro/registro.jsp">Registrarme</a></li>
				<li><a href="/Proyecto-PInfra/index.jsp">Cerrar sesión</a></li> <!-- hay que hacer el servlet para esto! -->

			</ul>
		</nav>
	</header>

	<main>
		<%
		if (Fabrica.getUsuarioLogueado() != null) {
		%>
		<h2>
			Bienvenido
			<%=Fabrica.getUsuarioLogueado().getNombreUsuario()%>
			a Mi Gestión UTEC
		</h2>
		<%
		}
		%>
		<p>Descubre un mundo de oportunidades y gestiona de manera
			eficiente.</p>

  <div class="pikachu-container">
        <img src="https://www.pngall.com/wp-content/uploads/5/Pikachu-PNG-Image-File.png" alt="Pikachu" class="pikachu">
	</main>
</body>
</html>
