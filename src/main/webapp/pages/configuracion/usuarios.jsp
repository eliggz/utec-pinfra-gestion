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
    <link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/pages/home/style.css">
    <script>
        function mostrarFormularioEdicion(id) {
            var form = document.getElementById('formEditarItr_' + id);
            form.style.display = (form.style.display === 'none') ? 'table-row' : 'none';
        }
    </script>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="/Proyecto-PInfra/pages/login/login.jsp">Iniciar sesión</a></li>
                <li><a href="/Proyecto-PInfra/pages/registro/registro.jsp">Registrarme</a></li>
                <li><a href="/Proyecto-PInfra/index.jsp">Cerrar sesión</a></li>
                <!-- hay que hacer el servlet para esto! -->
            </ul>
        </nav>
    </header>

    <main>
        <%
            if (Fabrica.getUsuarioLogueado() != null) {
        %>
        <h2>
            Bienvenido
            <%=Fabrica.getUsuarioLogueado().getNombreUsuario()%>
            a Mi Gestión UTEC
        </h2>
        <%
            }
        %>
        <p>Descubre un mundo de oportunidades y gestiona de manera eficiente.</p>

        <div class="pikachu-container">
            <img src="https://www.pngall.com/wp-content/uploads/5/Pikachu-PNG-Image-File.png" alt="Pikachu" class="pikachu">
        </div>
    </main>

    <div class="container">
        <h1>Lista de ITRs</h1>
        <!-- Tabla para mostrar los datos -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Documento</th>
                    <th>Rol</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Usuario> listaUsuario = Fabrica.getListaDeUsuarios();
                    for (Usuario usu : listaUsuario) {
                %>
                <tr>
                    <td><%=usu.getIdUsuario()%></td>
                    <td><%=usu.getNombre1()%></td>
                    <td><%=usu.getApellido1()%></td>
                    <td><%=usu.getDocumento()%></td>
                    <td><%=usu.getRol().getDescripcion()%></td>
                    <td>
                        <button class="btn-delete">Eliminar</button>
                        <button class="btn-edit" onclick="mostrarFormularioEdicion('<%=usu.getIdUsuario()%>')">Modificar</button>
                    </td>
                </tr>
                <!-- Formulario de edición oculto por defecto -->
                <tr id="formEditarItr_<%=usu.getIdUsuario()%>" style="display: none;">
                    <td colspan="6">
                        <!-- Generar el formulario de edición del Usuario -->
                        <form action="/Proyecto-PInfra/SvUsuarioModificar" method="post">
                            <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>">

                            <label for="editNombre_<%=usu.getIdUsuario()%>">Nombre:</label>
                            <input type="text" id="editNombre_<%=usu.getIdUsuario()%>" name="nombre" value="<%=usu.getNombre1()%>">

                            <label for="editApellido_<%=usu.getIdUsuario()%>">Apellido:</label>
                            <input type="text" id="editApellido_<%=usu.getIdUsuario()%>" name="apellido" value="<%=usu.getApellido1()%>">

                            <!-- Otros campos de la Itr -->
                            <button type="submit">Guardar Cambios</button>
                        </form>
                        <% if (request.getSession().getAttribute("errorMensaje") != null) { %>
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
