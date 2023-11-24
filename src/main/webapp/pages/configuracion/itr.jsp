<%@page import="com.cliente.servicios.ServiceUsuario"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@page import="com.cliente.contexto.Fabrica"%>
<%@page import="com.servidor.entidades.Itr"%>
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
				<li><a href="/Proyecto-PInfra/pages/login/login.jsp">Iniciar
						sesión</a></li>
				<li><a href="/Proyecto-PInfra/pages/registro/registro.jsp">Registrarme</a></li>
				<li><a href="/Proyecto-PInfra/index.jsp">Cerrar sesión</a></li>
				<!-- hay que hacer el servlet para esto! -->

			</ul>
		</nav>
	</header>

	<div class="container">
		<h1>Lista de ITRs</h1>

		<!-- Tabla para mostrar los datos -->
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Departamento</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				
					<%
	List<Itr> listaITR = Fabrica.getListaDeItrs();
        for (Itr itr : listaITR) {
        	System.out.println(itr.getNombre());
    %>
    <tr>
	<td><%=itr.getIdItr()%></td>
	<td><%=itr.getNombre()%></td>
	<td><%=itr.getDepartamento()%></td>
	<td>
	<button class="btn-delete">Eliminar</button>
	<button class="btn-edit">Modificar</button>
	</td>
	</tr>
	<% 
    } 
    %>
			</tbody>
		</table>

		<div class="add-btn" onclick="mostrarFormulario()">+</div>

	<div id="formularioAgregar" class="formulario-Agregar">
    <h2>Agregar ITR</h2>
    <form action="/Proyecto-PInfra/SvItrAgregar" method="post">
        <input type="hidden" name="id" id="id"> 
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        <br> 
        <label for="departamento">Departamento:</label> 
        <input type="text" id="departamento" name="departamento" required><br>
        <br> 
        <input type="submit" value="Guardar">
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
</script>
</body>
</html>
