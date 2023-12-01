<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/registro/style.css">
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
</head>
<body>
	<header>
		<nav style="display: flex; justify-content: center; align-items: center; height: 60px;">
    <ul style="list-style: none; display: flex; align-items: center; gap: 20px;">
        <li>
            <a><img style="width: 50px; z-index: auto; " class="imgLogo" src="https://red.utec.edu.uy/wp-content/uploads/2018/11/09-Isotipo-1.png" alt="Logo UTEC"></a>
        </li>
			<ul>
				<li><a href="/Proyecto-PInfra/index.jsp">Inicio</a></li>
				<li><a href="/Proyecto-PInfra/pages/login/login.jsp">Iniciar sesión</a></li>
	</header>
	</ul>
	</nav>

	<main>
		<h1>Registro de usuario</h1>
		
		<%
		if (request.getSession().getAttribute("errorMensaje") != null) {
		%>
		<span><%=request.getSession().getAttribute("errorMensaje")%></span>
		<%
		}
		%>

		<form action="/Proyecto-PInfra/SvUsuarioRegistro" method="POST">
		<p style="color: red;">Los campos marcados con (*) son obligatorios.</p>

			<table>
				<tr>
					 <td>Primer Nombre *</td>
    				<td><input type="text" name="nombre1" id="nombre1" oninput="actualizarCorreoEstudiante()" /></td>
				</tr>
				<tr>
					<td>Segundo Nombre</td>
					<td><input type="text" name="nombre2" /></td>
				</tr>
				<tr>
					 <td>Primer Apellido *</td>
    				<td><input type="text" name="apellido1" id="apellido1" oninput="actualizarCorreoEstudiante()" /></td>
				</tr>
				<tr>
					<td>Segundo Apellido</td>
					<td><input type="text" name="apellido2" /></td>
				</tr>
				<tr>
					<td>Documento *</td>
					<td><input type="text" name="documento" oninput="validarNumero(event)"/></td>
				</tr>
				<tr>
					<td>Fecha de nacimiento *</td>
					<td><input type="date" name="fechaNacimiento" /></td>
				</tr>
				<tr>

				<tr>
					<td>Mail institucional</td>
				    <td><input type="text" name="mailInstitucional" id="mailInstitucional" readonly /></td>
				</tr></tr>
				
				<tr>
					<td>Mail personal *</td>
					<td><input type="text" name="mailPersonal" /></td></tr>
				
				
				<tr>
					 <td>Nombre de usuario</td>
    			<td><input type="text" name="nombreUsuario" id="nombreUsuario" readonly /></td>
				</tr>

				<tr>
					<td>Contraseña *</td>
					 <td>
				        <input type="password" name="password" id="password" />
				        <button type="button" onclick="togglePasswordVisibility()">Ver Contraseña</button>
				    </td>
				</tr>
				<tr>
					<td>Teléfono</td>
					<td><input type="text" name="telefono" oninput="validarNumero(event)"/></td>
				</tr>
				<tr>
					<td>Departamento *</td>
					<td><select name="departamento" id="departamentoSelect">
							<option value="" selected disabled>Seleccione
								Departamento</option>
							<option value="Artigas">Artigas</option>
							<option value="Canelones">Canelones</option>
							<option value="Cerro Largo">Cerro Largo</option>
							<option value="Colonia">Colonia</option>
							<option value="Durazno">Durazno</option>
							<option value="Flores">Flores</option>
							<option value="Florida">Florida</option>
							<option value="Lavalleja">Lavalleja</option>
							<option value="Maldonado">Maldonado</option>
							<option value="Montevideo">Montevideo</option>
							<option value="Paysandú">Paysandú</option>
							<option value="Río Negro">Río Negro</option>
							<option value="Rivera">Rivera</option>
							<option value="Rocha">Rocha</option>
							<option value="Salto">Salto</option>
							<option value="San José">San José</option>
							<option value="Soriano">Soriano</option>
							<option value="Tacuarembó">Tacuarembó</option>
							<option value="Treinta y Tres">Treinta y Tres</option>
					</select></td>

				</tr>
				<tr>
					<td>Ciudad *</td>
					<td><select name="ciudad" id="ciudadSelect">
							<option value="" selected disabled>Seleccione Ciudad</option>
					</select></td>
				</tr>

				</tr>
				<tr>
					<td>Itr</td>
					<td><select name="itr">
							<option value="" selected disabled>Seleccione Itr</option>
							<option value="Minas">Minas</option>
							<option value="Melo">Melo</option>
							<option value="Durazno">Durazno</option>
							<option value="Fray Bentos">Fray Bentos</option>
					</select></td>
				</tr>
				<tr>
					<td>Seleccione Rol *</td>
					<td><select name="rol" id="rolSelect"
						onchange="actualizarCampos()">
							<option value="" selected disabled>Seleccione Rol</option>
							<option value="Analista">Analista</option>
							<option value="Tutor">Tutor</option>
							<option value="Estudiante">Estudiante</option>
					</select></td>
				</tr>
				<tr id="areaRow" style="display: none;">
					<td>Área *</td>
					<td><select name="area" id="areaSelect">
							<option value="" selected disabled>Seleccione Area</option>
							<option value="Infraestructura">Infraestructura</option>
							<option value="Testing">Testing</option>
							<option value="Programacion">Programacion</option>
					</select></td>
				</tr>
				<tr id="rolTutorRow" style="display: none;">
					<td>Rol *</td>
					<td><select name="rolTutor" id="rolTutorSelect">
							<option value="" selected disabled>Seleccione Rol</option>
							<option value="Tutor">Tutor</option>
							<option value="Encargado">Encargado</option>
					</select></td>
				</tr>
				<tr id="generacionRow" style="display: none;">
					<td>Generación *</td>
					<td><input type="number" name="generacion"
						id="generacionSelect" placeholder="Escriba aquí su generación..."
						oninput="validarNumero(event)"></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Registrar" /></td>
				</tr>
			</table>
		</form>
		<script>
    // Definir las ciudades por departamento
    const ciudadesPorDepartamento = {
        "Artigas": ["Artigas", "Bella Unión", "Tomás Gomensoro", "Pintadito"],
        "Canelones": ["Canelones", "Santa Lucía", "Las Piedras", "Progreso", "Tala", "Atlántida"],
        "Cerro Largo": ["Melo", "Río Branco", "Fraile Muerto", "Aceguá", "Bañado de Medina"],
        "Colonia": ["Colonia del Sacramento", "Carmelo", "Nueva Helvecia", "Juan Lacaze", "Florencio Sánchez"],
     "Durazno": ["Durazno", "Sarandí del Yí", "Blanquillo", "Sarandí de Navarro"],
     "Flores": ["Trinidad", "Tranqueras", "Cerro Colorado", "Ismael Cortinas"],
     "Florida": ["Florida", "Sarandí Grande", "Casupá", "Independencia"],
     "Lavalleja": ["Minas", "José Pedro Varela", "Mariscala", "José Batlle y Ordóñez"],
     "Maldonado": ["Maldonado", "Punta del Este", "San Carlos", "Aiguá", "Pan de Azúcar"],
     "Montevideo": ["Montevideo", "Ciudad de la Costa"],
     "Paysandú": ["Paysandú", "Guichón", "Chacras de Paysandú", "Porvenir"],
     "Río Negro": ["Fray Bentos", "Young", "Nuevo Berlín", "San Javier"],
     "Rivera": ["Rivera", "Tranqueras", "Vichadero", "Minas de Corrales"],
     "Rocha": ["Rocha", "La Paloma", "Chuy", "Castillos", "Valizas"],
     "Salto": ["Salto", "Constitución", "Daymán", "Arapey"],
     "San José": ["San José de Mayo", "Libertad", "Ecilda Paullier", "Rafael Perazza"],
     "Soriano": ["Mercedes", "Cardona", "Dolores", "José Enrique Rodó"],
     "Tacuarembó": ["Tacuarembó", "Paso de los Toros", "San Gregorio de Polanco", "Ansina"],
     "Treinta y Tres": ["Treinta y Tres", "Santa Clara", "Rincón de Valentines", "Vergara"]
 };

    function actualizarCiudades() {
        const departamentoSelect = document.getElementById("departamentoSelect");
        const ciudadSelect = document.getElementById("ciudadSelect");
        const departamentoSeleccionado = departamentoSelect.value;

        ciudadSelect.innerHTML = "";

        const ciudades = ciudadesPorDepartamento[departamentoSeleccionado];

        if (ciudades) {
            ciudades.forEach((ciudad) => {
                const opcion = document.createElement("option");
                opcion.text = ciudad;
                opcion.value = ciudad;
                ciudadSelect.appendChild(opcion);
            });
        }
    }

    const departamentoSelect = document.getElementById("departamentoSelect");
    departamentoSelect.addEventListener("change", actualizarCiudades);

    actualizarCiudades();

    function actualizarCampos() {
        const rolSelect = document.getElementById("rolSelect");
        const areaRow = document.getElementById("areaRow");
        const rolTutorRow = document.getElementById("rolTutorRow");
        const generacionRow = document.getElementById("generacionRow");
        const mailInstitucionalInput = document.getElementById("mailInstitucional");

        if (rolSelect.value === "Tutor") {
            areaRow.style.display = "table-row";
            rolTutorRow.style.display = "table-row";
        } else {
            areaRow.style.display = "none";
            rolTutorRow.style.display = "none";
        }

        if (rolSelect.value === "Estudiante") {
            generacionRow.style.display = "table-row";
            actualizarCorreoEstudiante();
        } else {
            generacionRow.style.display = "none";
            actualizarCorreoEstudiante();
        }
    }

    function generarCorreoEstudiante(nombre, apellido) {
        return nombre.toLowerCase() + "." + apellido.toLowerCase() + "@estudiantes.utec.edu.uy";
    }

    function generarCorreoOtrosRoles() {
        const nombre1 = document.getElementById("nombre1").value;
        const apellido1 = document.getElementById("apellido1").value;
        return nombre1.toLowerCase() + "." + apellido1.toLowerCase() + "@utec.edu.uy";
    }

    function validarNumero(event) {
        const input = event.target;
        const valor = input.value.trim();

        if (!valor.match(/^\d+$/)) {
            input.value = valor.replace(/\D/g, '');
        }
    }

    function actualizarCorreoEstudiante() {
        const nombre1 = document.getElementById("nombre1").value;
        const apellido1 = document.getElementById("apellido1").value;
        const mailInstitucionalInput = document.getElementById("mailInstitucional");
        const nombreUsuarioInput = document.getElementById("nombreUsuario");

        const mailInstitucional = (rolSelect.value === "Estudiante")
            ? generarCorreoEstudiante(nombre1, apellido1)
            : generarCorreoOtrosRoles();

        mailInstitucionalInput.value = mailInstitucional;
        nombreUsuarioInput.value = generarNombreUsuario(nombre1, apellido1);
    }
    function generarNombreUsuario(nombre, apellido) {
        return nombre.toLowerCase() + "." + apellido.toLowerCase();
    }

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