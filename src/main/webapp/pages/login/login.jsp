<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/pages/login/styleLogin.css">

</head>
<body>
    <header>
    <nav class="navbar">
        <a class="logo" href="#">
            <img class="imgLogo" src="https://red.utec.edu.uy/wp-content/uploads/2018/11/09-Isotipo-1.png" alt="Logo UTEC">
        </a>
        <ul class="menu">
            <li>
                <a href="/Proyecto-PInfra/index.jsp">Pantalla principal</a>
            </li>
            <li>
                <a href="/Proyecto-PInfra/pages/registro/registro.jsp">Registrarme</a>
            </li>
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
            <label>Nombre de usuario <input type="text" name="nombreUsuario" placeholder="Ingrese su usuario..."></label>
            <label>Contraseña <input type="password" name="clave" id="password" placeholder="Ingrese su contraseña..."></label>
            <button class="verBtn" type="button" onclick="togglePasswordVisibility()">Ver Contraseña</button>
            <button type="submit">Iniciar</button>
        </form>
    </main>

    <script type="text/javascript">
        function togglePasswordVisibility() {
            const passwordInput = document.getElementById("password");
            const buttonText = document.querySelector("button[onclick='togglePasswordVisibility()']");

            if (passwordInput.type === "password") {
                passwordInput.type = "text";
                buttonText.textContent = "Ocultar Contraseña";
            } else {
                passwordInput.type = "password";
                buttonText.textContent = "Ver Contraseña";
            }
        }
    </script>
</body>
</html>
