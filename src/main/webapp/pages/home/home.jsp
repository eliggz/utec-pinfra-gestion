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
				
				<% if(Fabrica.getUsuarioLogueado().getRol().getIdRol()==1l) { %>
				<li><a href="/Proyecto-PInfra/pages/configuracion/usuarios.jsp">Gestión de Usuarios</a></li>
				<li><a href="/Proyecto-PInfra/pages/configuracion/itr.jsp">Gestión de Itrs</a></li>
				
				<% } %>
				<li><a href="/Proyecto-PInfra/pages/home/home.jsp">Mi perfil</a></li>
				<form action="/Proyecto-PInfra/SvLogout" method="post">
				<li><button onclick="cerrarSesion()">Cerrar sesión</button></li>
				</form>

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

  <!-- <div class="pikachu-container">
        <img src="https://www.pngall.com/wp-content/uploads/5/Pikachu-PNG-Image-File.png" alt="Pikachu" class="pikachu"> -->
	</main>
	<script>
function cerrarSesion() {
    // Realizar alguna lógica o llamada AJAX si es necesario
    // Redireccionar a tu servlet de logout
    window.location.href = "/Proyecto-PInfra/SvLogout";
}
</script>
</body>
</html>
