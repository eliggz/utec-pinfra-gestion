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
<title>Mi perfil</title>
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/configuracion/stylePerfil.css">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/Proyecto-PInfra/pages/home/home.jsp">Inicio</a></li>
				<%
				Usuario usuarioLogueado = Fabrica.getUsuarioLogueado();
				if (usuarioLogueado.getRol().getIdRol() == 1l) {
				%>
				<li><a href="/Proyecto-PInfra/pages/configuracion/usuarios.jsp">Gestión
						de Usuarios</a></li>
				<li><a href="/Proyecto-PInfra/pages/configuracion/itr.jsp">Gestión
						de Itrs</a></li>
				<%
				}
				%>
			</ul>
		</nav>
	</header>

	<div class="container">
		<h1>Modificar Perfil</h1>
		<form action="/Proyecto-Pinfra/SvUsuarioModificar" method="post">

			<label for="nombreUsuario">Nombre de Usuario:</label> <input
				type="text" id="nombreUsuario" name="nombreUsuario"
				placeholder="Nombre de Usuario"
				value="<%=usuarioLogueado.getNombreUsuario()%>" readonly> <label
				for="password">Contraseña:</label> <input type="password"
				id="password" name="password" placeholder="Contraseña"
				value="<%=usuarioLogueado.getPassword()%>" required>
			<button type="button" onclick="togglePasswordVisibility()">Ver
				Contraseña</button>
			<br>

			<!-- Otros campos del formulario -->
			<label for="nombre1">Primer Nombre:</label> <input type="text"
				id="nombre1" name="nombre1"
				placeholder="Ingrese su primer nombre..."
				value="<%=usuarioLogueado.getNombre1()%>" required> <label
				for="nombre2">Segundo Nombre:</label> <input type="text"
				id="nombre2" name="nombre2"
				placeholder="Ingrese su segundo nombre..."
				<%if (usuarioLogueado.getNombre2() != null) {%>
				value="<%=usuarioLogueado.getNombre2()%>" <%}%>> <label
				for="apellido1">Primer Apellido:</label> <input type="text"
				id="apellido1" name="apellido1"
				placeholder="Ingrese su primer apellido..."
				value="<%=usuarioLogueado.getApellido1()%>"> <label
				for="apellido2">Segundo Apellido:</label> <input type="text"
				id="apellido2" name="apellido2"
				placeholder="Ingrese su segundo apellido..."
				<%if (usuarioLogueado.getApellido2() != null) {%>
				value="<%=usuarioLogueado.getApellido2()%>" <%}%>> <label
				for="documento">Documento:</label> <input type="text" id="documento"
				name="documento" placeholder="Ingrese su documento..."
				value="<%=usuarioLogueado.getDocumento()%>"> <label>Fecha
				de nacimiento</label> <input type="date" name="fechaNacimiento" /> <br>
			<label>Mail personal</label> <input type="text" name="mailPersonal" />


			<!-- El campo de nombre de usuario no se debe editar en el perfil -->

			<input type="submit" value="Guardar Cambios">
		</form>
	</div>


	<script>
		function togglePasswordVisibility() {
			const passwordInput = document.getElementById("password");
			const buttonText = document
					.querySelector("button[onclick='togglePasswordVisibility()']");

			if (passwordInput.type === "password") {
				passwordInput.type = "text";
				buttonText.textContent = "Ocultar Contraseña";
			} else {
				passwordInput.type = "password";
				buttonText.textContent = "Ver Contraseña";
			}
		}
	</script>
</body>
</html>