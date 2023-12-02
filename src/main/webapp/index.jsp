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

  <a href="/Proyecto-PInfra/index.jsp">
    <img class="imgLogo" src="https://red.utec.edu.uy/wp-content/uploads/2018/11/06-isologotipo-para-fondo-blanco-1.png" alt="Logo UTEC">
  </a>

<div id="banner-home">
  <img class="imgBanner" src="ruta_de_la_imagen" alt="Imagen">
</div>

<div id="banner-home" class="">
  <img src="https://utec.edu.uy/assets/static/home/header.png" alt="Imagen" />
</div>

<main>
  <h1>Mi Gestión UTEC</h1>

  <p>Portal oficial de la Universidad Tecnológica del Uruguay</p>

  <div class="button-container">
    <a href="/Proyecto-PInfra/pages/login/login.jsp" class="button">Iniciar sesión</a>
    <a href="/Proyecto-PInfra/pages/registro/registro.jsp" class="button">Registrarme</a>
  </div>
</main>

<footer>
  <nav>
    <a href="https://git.utec.edu.uy/five-backup/proyecto-infra" target="_blank">Proyecto en GitHub</a>
  </nav>
</footer>
</body>
</html>
