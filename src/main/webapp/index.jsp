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
				
				<li><a href="/Proyecto-PInfra/pages/login/login.jsp">Iniciar sesión</a></li>
				<li><a href="/Proyecto-PInfra/pages/login/login.jsp">Gestión de Usuarios</a></li>
				<li><a href="/Proyecto-PInfra/pages/registro/registro.jsp">Registrarme</a></li>

		<%-- 		<li>
					<%
					if (request.getSession().getAttribute("usuarioLogueado") != null) {
						Usuario usuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
					%> <span>Bienvenido desde la sesión: <%=usuarioLogueado.getNombreUsuario()%></span>
					<%
					}
					%>
				</li>
				<li>
					<%
					if (Fabrica.getUsuarioLogueado() != null) {
					%> <span>Bienvenido desde la fabrica: <%=Fabrica.getUsuarioLogueado().getNombreUsuario()%></span>
					<%
					}
					%>
				</li> --%>
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
