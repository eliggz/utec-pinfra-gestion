<%@page import="com.cliente.servicios.ServiceUsuario"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@page import="com.cliente.contexto.Fabrica"%>
<%@page import="com.servidor.entidades.Itr"%>
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
</head>
<body>
	<header>
		<nav>
			<ul>
			<li><a href="/Proyecto-PInfra/pages/home/home.jsp">Inicio</a></li>
			<% if(Fabrica.getUsuarioLogueado().getRol().getIdRol()==1l) { %>
				<li><a href="/Proyecto-PInfra/pages/configuracion/usuarios.jsp">Gestión de Usuarios</a></li>
				
				
				<% } %>
					
				<li><a href="/Proyecto-PInfra/pages/configuracion/perfil.jsp">Mi perfil</a></li>
				
			</ul>
		</nav>
	</header>

	<div class="container">
		<h1>Lista de ITRs</h1>	<!-- Tabla para mostrar los datos -->
		<button onclick="mostrarTodosITRs()">Mostrar Todos</button>
        <button onclick="filtrarITRs('VALIDADO')">Mostrar Validados</button>
        <button onclick="filtrarITRs('NO VALIDADO')">Mostrar No Validados</button>
        <button onclick="filtrarITRs('ELIMINADO')">Mostrar Eliminados</button>
		<table id="tablaITRs"> 
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Departamento</th>
					<th>Estado</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody id="tbodyITRs">

				<%
				List<Itr> listaITR = Fabrica.getListaDeItrs();
				for (Itr itr : listaITR) {
					
						
					
				%>
				
				<form  action="/Proyecto-PInfra/SvItrEliminar" method="POST">
				<tr class="filaITR">
					<td><%=itr.getIdItr()%></td>
					<td><%=itr.getNombre()%></td>
					<td><%=itr.getDepartamento()%></td>
					<td><%=itr.getEstado().getDescripcion()%></td>
					<td>
					<button name="id" value="<%=itr.getIdItr()%>" class="btn-delete">Eliminar</button>
					</form>
						<button class="btn-edit"
							onclick="mostrarFormularioEdicion('<%=itr.getIdItr()%>')">Modificar</button>
					</td>
					<% if (request.getSession().getAttribute("errorMensaje") != null) { %>
    <span><%= request.getSession().getAttribute("errorMensaje") %></span>
		<% } %>
				</tr>
				<!-- Formulario de edición oculto por defecto -->
				<tr id="formEditarItr_<%=itr.getIdItr()%>" style="display: none;">
					<td colspan="4">
						<!-- Generar el formulario de edición de la Itr -->
						<form action="/Proyecto-PInfra/SvItrModificar" method="post">
							<input type="hidden" name="id" value="<%=itr.getIdItr()%>">
							<label for="editNombre_<%=itr.getIdItr()%>">Nombre:</label> <input
								type="text" id="editNombre_<%=itr.getIdItr()%>" name="nombre"
								value="<%=itr.getNombre()%>"> <label
								for="editDepartamento_<%=itr.getIdItr()%>">Departamento:</label>
							<input type="text" id="editDepartamento_<%=itr.getIdItr()%>"
								name="departamento" value="<%=itr.getDepartamento()%>">
						<select id="editEstado_<%= itr.getIdItr() %>" name="estado">
                    
    					<%
   						List<Estado> listaEstados = Fabrica.getListaDeEstados();

    					// Filtrar la lista de estados para excluir el estado 'ELIMINADO'
   						 List<Estado> estadosFiltrados = new ArrayList<>();
    						for (Estado aux : listaEstados) {
     						   if (!aux.getDescripcion().equalsIgnoreCase("ELIMINADO")) {
           						 estadosFiltrados.add(aux);
       					 		}
    						}

    					// Mostrar los estados filtrados en el select
    						for (Estado estado : estadosFiltrados) {
   					 	%>
        			<option value="<%=estado.getIdEstado()%>"> <%=estado.getDescripcion()%> </option>
    					<% } %>
					
                    </select>
                    <!-- Otros campos de la Itr -->
                    <button type="submit">Guardar Cambios</button>
                    <button type="button" onclick="ocultarFormulario('<%= itr.getIdItr() %>')">Cancelar</button>
                </form>
						
						<% if (request.getSession().getAttribute("errorMensaje") != null) { %>
    <span><%= request.getSession().getAttribute("errorMensaje") %></span>
		<% } }%>

					</td>
				</tr>
			</tbody>
		</table>

		<div class="add-btn" onclick="mostrarFormulario()">+</div>

		<div id="formularioAgregar" class="formulario-Agregar">
			<h2>Agregar ITR</h2>
			<form action="/Proyecto-PInfra/SvItrAgregar" method="post">
				<input type="hidden" name="id" id="id"> <label for="nombre">Nombre:</label>
				<input type="text" id="nombre" name="nombre" required><br>
				<br> <label for="departamento">Departamento:</label> <input
					type="text" id="departamento" name="departamento" required><br>
				<br> <input type="submit" value="Guardar">
				<button type="button" onclick="ocultarFormulario()">Cancelar</button>
			</form>
		</div>
	</div>
	<script>
		function mostrarFormulario() {
			document.getElementById('formularioAgregar').style.display = 'block';
		}

		function ocultarFormulario() {
			document.getElementById('formularioAgregar').style.display = 'none';
		}

		function mostrarFormularioEdicion(id) {
			var form = document.getElementById('formEditarItr_' + id);
			form.style.display = (form.style.display === 'none') ? 'table-row'
					: 'none';
		}

			 function mostrarTodosITRs() {
			        var filasITRs = document.getElementsByClassName('filaITR');

			        for (var i = 0; i < filasITRs.length; i++) {
			            filasITRs[i].style.display = 'table-row';
			        }
			    }

			    function filtrarITRs(estado) {
			        var filasITRs = document.getElementsByClassName('filaITR');

			        for (var i = 0; i < filasITRs.length; i++) {
			            var estadoITR = filasITRs[i].getElementsByTagName('td')[3].innerText.trim();
			            if (estado === 'TODOS' || estadoITR === estado) {
			                filasITRs[i].style.display = 'table-row';
			            } else {
			                filasITRs[i].style.display = 'none';
			            }
			        }
			    }
			    
			   

	</script>
</body>
</html>
