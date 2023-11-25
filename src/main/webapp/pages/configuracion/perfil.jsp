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
                <% if(Fabrica.getUsuarioLogueado().getRol().getIdRol() == 1l) { %>
                    <li><a href="/Proyecto-PInfra/pages/configuracion/usuarios.jsp">Gesti�n de Usuarios</a></li>
                    <li><a href="/Proyecto-PInfra/pages/configuracion/itr.jsp">Gesti�n de Itrs</a></li>
                <% } %>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h1>Modificar Perfil</h1>
        <form action="/ruta/de/modificacion/perfil" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" placeholder="Nombre" required>
            
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" placeholder="Email" required>
            
            <label for="password">Contrase�a:</label>
            <input type="password" id="password" name="password" placeholder="Contrase�a" required>
            
            <input type="submit" value="Guardar Cambios">
        </form>
    </div>
</body>
</html>