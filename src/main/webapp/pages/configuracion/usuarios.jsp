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
		<button onclick="mostrarTodosUsuarios()">Mostrar Todos</button>
		 <button onclick="filtrarUsuarios('VALIDADO')">Mostrar Validados</button>
         <button onclick="filtrarUsuarios('NO VALIDADO')">Mostrar No Validados</button>
         <button onclick="filtrarUsuarios('ELIMINADO')">Mostrar Eliminados</button>
         
		<!-- Tabla para mostrar los datos -->
		<table id="tablaUsuarios">
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
			<tbody id="tbodyUsuarios">
				<%
                    List<Usuario> listaUsuarios = Fabrica.getListaDeUsuarios();
                    for (Usuario usu : listaUsuarios) {
                    
                %>
                <form  action="/Proyecto-PInfra/SvUsuarioEliminar" method="POST">
				 <tr class="filaUsuario">
					<td><%=usu.getIdUsuario()%></td>
					<td><%=usu.getNombre1()%></td>
					<td><%=usu.getApellido1()%></td>
					<td><%=usu.getDocumento()%></td>
					<td><%=usu.getRol().getNombre()%></td>
					<td><%=usu.getEstado().getDescripcion()%></td>
					<td>
					
						<button name="id" value="<%=usu.getIdUsuario()%>" class="btn-delete">Eliminar</button>
						</form>
						<button class="btn-edit"
							onclick="mostrarFormularioEdicion('<%=usu.getIdUsuario()%>')">Modificar</button>
					
				</td>
				<% if (request.getSession().getAttribute("errorMensaje") != null) { %>
    <span><%= request.getSession().getAttribute("errorMensaje") %></span>
		<% } %>
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
	
	<script>
        function mostrarFormularioEdicion(id) {
            var form = document.getElementById('formEditarUsuario_' + id);
            form.style.display = (form.style.display === 'none') ? 'table-row' : 'none';
        }
        function ocultarFormulario(idUsuario) {
            document.getElementById('formEditarUsuario_' + idUsuario).style.display = 'none';
        }

        function mostrarTodosUsuarios() {
            var filasUsuarios = document.getElementsByClassName('filaUsuario');

            for (var i = 0; i < filasUsuarios.length; i++) {
                filasUsuarios[i].style.display = 'table-row';
            }
        }

        function filtrarUsuarios(estado) {
            var filasUsuarios = document.getElementsByClassName('filaUsuario');

            for (var i = 0; i < filasUsuarios.length; i++) {
                var estadoUsuario = filasUsuarios[i].querySelector('td:nth-child(6)').innerText;
                if (estado === 'TODOS' || estadoUsuario === estado) {
                    filasUsuarios[i].style.display = 'table-row';
                } else {
                    filasUsuarios[i].style.display = 'none';
                }
            }
        }
        
    </script>
</body>
</html>
