
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
				<li><a href="/Proyecto-PInfra/pages/login/index.jsp">Inicio
						de sesión</a></li>
				<li>
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
					%> <span>Bienvenido desde la fabrica: <%=Fabrica.getUsuarioLogueado().getNombreUsuario()%>
				</span> <%
 }
 %>
				</li>
			</ul>
		</nav>
	</header>

	<main>
		<h2>Mi primer app</h2>

		<select>
			<option selected>Selecciona un número</option>
			<%
			for (int numero = 1; numero <= 6; numero++) {
			%>
			<option value="<%=numero%>"><%=numero%>
			</option>
			<%
			}
			%>
		</select>

		<table>
			<thead>
				<tr>
					<th>Documento</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (ServiceUsuario.listarTodosLosUsuarios() != null && ServiceUsuario.listarTodosLosUsuarios().size() > 0) {
					for (Usuario usuario : ServiceUsuario.listarTodosLosUsuarios()) {
				%>
				<tr>
					<td><%=usuario.getDocumento()%></td>
					<td><%=usuario.getNombre1()%></td>
					<td><%=usuario.getApellido1()%></td>
					<td>
						<form action="/Proyecto-PInfra/SvBorrar" method="POST">
							<input type="hidden" value="<%=usuario.getIdUsuario()%>"
								name="idUsuario">
							<button type="submit">Borrar</button>
						</form>
					</td>
				</tr>
				<%
				}
				} else {
				%>

				<span>No hay usuarios</span>

				<%
				}
				%>
			</tbody>
		</table>

	</main>
</body>
</html>