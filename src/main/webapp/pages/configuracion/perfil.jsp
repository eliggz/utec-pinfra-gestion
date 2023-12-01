<%@page import="com.cliente.servicios.ServiceUsuario"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@page import="com.cliente.contexto.Fabrica"%>
<%@page import="com.servidor.entidades.Itr"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
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
		<nav style="display: flex; justify-content: center; align-items: center; height: 60px;">
    <ul style="list-style: none; display: flex; align-items: center; gap: 20px;">
        <li>
            <a><img style="width: 50px; z-index: auto; " class="imgLogo" src="https://red.utec.edu.uy/wp-content/uploads/2018/11/09-Isotipo-1.png" alt="Logo UTEC"></a>
        </li>
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
		<div style="text-align: center; margin-bottom: 10px">
    <% if (request.getSession().getAttribute("exitoMensaje") != null) { %>
        <span id="exitoMensaje" style="display: none; color: green;"><%= request.getSession().getAttribute("exitoMensaje") %></span>
    <% } %>
</div>

	<div style="text-align: center; margin-bottom: 10px">
    <% if (request.getSession().getAttribute("errorMensaje") != null) { %>
        <span id="errorMensaje" style="display: none; color: red;"><%= request.getSession().getAttribute("errorMensaje") %></span>
    <% } %>
</div>


		<form action="/Proyecto-PInfra/SvUsuarioPerfil" method="POST">

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
				value="<%=usuarioLogueado.getNombre1()%>" required> 
				
				<label for="nombre2">Segundo Nombre:</label> <input type="text"
				id="nombre2" name="nombre2"
				placeholder="Ingrese su segundo nombre..."
				<%if (usuarioLogueado.getNombre2() != null) {%>
				value="<%=usuarioLogueado.getNombre2()%>" <%}%>> 
				
				<label for="apellido1">Primer Apellido:</label> <input type="text"
				id="apellido1" name="apellido1"
				placeholder="Ingrese su primer apellido..."
				value="<%=usuarioLogueado.getApellido1()%>"> 
				
				<label for="apellido2">Segundo Apellido:</label> <input type="text"
				id="apellido2" name="apellido2"
				placeholder="Ingrese su segundo apellido..."
				<%if (usuarioLogueado.getApellido2() != null) {%>
				value="<%=usuarioLogueado.getApellido2()%>" <%}%>>
				
				 <label for="documento">Documento:</label> <input oninput="validarNumero(event)" type="text" id="documento"
				name="documento" placeholder="Ingrese su documento..."
				value="<%=usuarioLogueado.getDocumento()%>">
				
				<label for="fechaNacimiento">Fecha de nacimiento</label>
				<input type="date" name="fechaNacimiento" <% if (usuarioLogueado.getFechaNacimiento() != null) {
			    // Obtener la fecha de nacimiento del usuario
			    Date fechaNacimiento = usuarioLogueado.getFechaNacimiento();
			    // Crear un formateador para el nuevo formato "YYYY-MM-DD"
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    // Formatear la fecha a una cadena en el formato correcto
			    String fechaFormateada = dateFormat.format(fechaNacimiento);
					%>
    			value="<%= fechaFormateada %>"
				<% } %> />
			
				<br>
				
			<label for="mailPersonal">Mail personal</label> <input <%if (usuarioLogueado.getMailPersonal() != null) {%>
				value="<%=usuarioLogueado.getMailPersonal()%>" <%}%>  type="text" name="mailPersonal" />
			
			
			<label for="telefono">Teléfono</label><input <%if (usuarioLogueado.getTelefono() != null) {%>
				value="<%=usuarioLogueado.getTelefono()%>" <%}%> type="text" name="telefono" oninput="validarNumero(event)"/></td>


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

		function validarNumero(event) {
	        const input = event.target;
	        const valor = input.value.trim();

	        if (!valor.match(/^\d+$/)) {
	            input.value = valor.replace(/\D/g, '');
	        }
	    }


		var exitoMensaje = document.getElementById('exitoMensaje');

		// Mostrar el mensaje si existe
		if (exitoMensaje && exitoMensaje.innerText.trim() !== '') {
		    exitoMensaje.style.display = 'block';
		    // Puedes agregar estilos o animaciones adicionales aquí
		    // Por ejemplo: exitoMensaje.classList.add('animacion-pop');
		    // Asegúrate de tener estilos CSS correspondientes para la animación
		}
	</script>
</body>
</html>