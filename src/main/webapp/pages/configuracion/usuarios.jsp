<%@page import="com.cliente.servicios.ServiceUsuario"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@page import="com.cliente.contexto.Fabrica"%>
<%@page import="com.servidor.entidades.Itr"%>
<%@page import="com.servidor.entidades.Rol"%>
<%@page import="com.servidor.entidades.Estado"%>
<%@page import="java.util.*"%>
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
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/configuracion/styleITR.css">
<script>
        function mostrarFormularioEdicion(id) {
            var form = document.getElementById('formEditarUsuario_' + id);
            form.style.display = (form.style.display === 'none') ? 'table-row' : 'none';
        }
        function ocultarFormulario(idUsuario) {
            document.getElementById('formEditarUsuario_' + idUsuario).style.display = 'none';
        }
    </script>
</head>
<body>
	<header>
		<nav>
			<ul>
			<li><a href="/Proyecto-PInfra/pages/home/home.jsp">Inicio</a></li>
				<% if(Fabrica.getUsuarioLogueado().getRol().getIdRol()==1l) { %>
		
				<li><a href="/Proyecto-PInfra/pages/configuracion/itr.jsp">Gestión de Itrs</a></li>
				
				<% } %>
				<li><a href="/Proyecto-PInfra/pages/configuracion/perfil.jsp">Mi perfil</a></li>
				
				<!-- hay que hacer el servlet para esto! -->
			</ul>
		</nav>
	</header>

	<div class="container">
		<h1>Lista de Usuarios</h1>
		<!-- Tabla para mostrar los datos -->
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Documento</th>
					<th>Rol</th>
					<th>Estado</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
                    List<Usuario> listaUsuarios = Fabrica.getListaDeUsuarios();
                    for (Usuario usu : listaUsuarios) {
                %>
				<tr>
					<td><%=usu.getIdUsuario()%></td>
					<td><%=usu.getNombre1()%></td>
					<td><%=usu.getApellido1()%></td>
					<td><%=usu.getDocumento()%></td>
					<td><%=usu.getRol().getNombre()%></td>
					<td><%=usu.getEstado().getDescripcion()%></td>
					<td>
						<button class="btn-delete">Eliminar</button>
						<button class="btn-edit"
							onclick="mostrarFormularioEdicion('<%=usu.getIdUsuario()%>')">Modificar</button>
					</td>
				</tr>
				<!-- Formulario de edición oculto por defecto -->
				<tr id="formEditarUsuario_<%=usu.getIdUsuario()%>"
					style="display: none;">
					<td colspan="6">
						<!-- Generar el formulario de edición del Usuario -->
						<form action="/Proyecto-PInfra/SvUsuarioModificar" method="post">
							<input type="hidden" name="id" value="<%=usu.getIdUsuario()%>">

							<label for="editNombre_<%=usu.getIdUsuario()%>">Nombre:</label> <input
								type="text" id="editNombre_<%=usu.getIdUsuario()%>"
								name="nombre" value="<%=usu.getNombre1()%>"> <label
								for="editApellido_<%=usu.getIdUsuario()%>">Apellido:</label> <input
								type="text" id="editApellido_<%=usu.getIdUsuario()%>"
								name="apellido" value="<%=usu.getApellido1()%>"> <label
								for="editEstado_<%=usu.getIdUsuario()%>">Estado</label> 
								
								<select id="editEstado_<%=usu.getIdUsuario()%>" name="estado">
								<% 
       							 List<Estado> listaEstados = Fabrica.getListaDeEstados();
        							for (Estado aux : listaEstados) {
  							  %>
							<option value="<%=aux.getIdEstado()%>"> <%=aux.getDescripcion()%> </option>
								<% } %>
							</select> 
							<!-- Otros campos de la Itr -->
							<button type="submit">Guardar Cambios</button>
							<button type="button" onclick="ocultarFormulario('<%=usu.getIdUsuario()%>')">Cancelar</button>

						</form> <% if (request.getSession().getAttribute("errorMensaje") != null) { %>
						<span><%=request.getSession().getAttribute("errorMensaje")%></span>
						<% } %>
					</td>
				</tr>
				<%
                    }
                %>
			</tbody>
		</table>
	</div>
</body>
</html>
