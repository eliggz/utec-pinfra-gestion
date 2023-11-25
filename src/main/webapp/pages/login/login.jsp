
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/login/style.css">
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/Proyecto-PInfra/index.jsp">Inicio</a></li>
				<li><a href="/Proyecto-PInfra/pages/registro/registro.jsp">Registrarme</a></li>
			</ul>
		</nav>
	</header>

	<main>
		<h2>Login</h2>

		<%
		if (request.getSession().getAttribute("errorMensaje") != null) {
		%>
		<span><%=request.getSession().getAttribute("errorMensaje")%></span>
		<%
		}
		%>
		

		<form action="/Proyecto-PInfra/SvUsuarioLogin" method="POST">
			<label> Nombre de usuario <input type="text"
				name="nombreUsuario" placeholder="Ingrese su usuario...">
			</label> <label> Contraseña <input type="password" name="clave"
				placeholder="Ingrese su contraseña...">
			</label>

			<button type="submit">Iniciar</button>
		</form>
	</main>
</body>
</html>