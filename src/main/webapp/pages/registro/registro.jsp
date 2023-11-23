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
		<nav>
			<ul>
				<li><a href="/Proyecto-PInfra/index.jsp">Inicio</a></li>
				<li><a href="/Proyecto-PInfra/pages/login/index.jsp">Iniciar
						sesión</a></li>
	</header>
	</ul>
	</nav>

	<main>
		<h1>Registro de usuario</h1>

		<form action="/Proyecto-PInfra/SvUsuarioRegistro" method="POST">

			<table>
				<tr>
					<td>Primer Nombre</td>
					<td><input type="text" name="nombre1" /></td>
				</tr>
				<tr>
					<td>Segundo Nombre</td>
					<td><input type="text" name="nombre2" /></td>
				</tr>
				<tr>
					<td>Primer Apellido</td>
					<td><input type="text" name="apellido1" /></td>
				</tr>
				<tr>
					<td>Segundo Apellido</td>
					<td><input type="text" name="apellido2" /></td>
				</tr>
				<tr>
					<td>Documento</td>
					<td><input type="text" name="documento" /></td>
				</tr>
				<tr>
					<td>Fecha de nacimiento</td>
					<td><input type="date" name="fechaNacimiento" /></td>
				</tr>
				<tr>
					<td>Mail institucional</td>
					<td><input type="text" name="mailInstitucional" /></td>
				</tr>
				<tr>
					<td>Mail personal</td>
					<td><input type="text" name="mailPersonal" /></td>
				</tr>
				<tr>
					<td>Nombre de usuario</td>
					<td><input type="text" name="nombreUsuario" /></td>
				</tr>

				<tr>
					<td>Contraseña</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Teléfono</td>
					<td><input type="text" name="telefono" /></td>
				</tr>
				<tr>
					<td>Departamento</td>
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
					<td>Ciudad</td>
					<td><select name="ciudad" id="ciudadSelect">
							<option value="" selected disabled>Seleccione Ciudad</option>
					</select></td>
				</tr>

				</tr>
				<tr>
					<td>Itr</td>
					<td><select name="itr">
							<option value="Minas">Minas</option>
							<option value="Melo">Melo</option>
							<option value="Durazno">Durazno</option>
							<option value="Fray Bentos">Fray Bentos</option>
					</select></td>
				</tr>
				<tr>
					<td>Soy un...</td>
					<td><select name="rol" id="rolSelect"
						onchange="actualizarCampos()">
							<option value="Analista">Analista</option>
							<option value="Tutor">Tutor</option>
							<option value="Estudiante">Estudiante</option>
					</select></td>
				</tr>
				<tr id="areaRow" style="display: none;">
					<td>Área</td>
					<td><select name="area" id="areaSelect">
							<option value="Infraestructura">Infraestructura</option>
							<option value="Testing">Testing</option>
							<option value="Programacion">Programacion</option>
					</select></td>
				</tr>
				<tr id="rolTutorRow" style="display: none;">
					<td>Rol</td>
					<td><select name="rolTutor" id="rolTutorSelect">
							<option value="Tutor">Tutor</option>
							<option value="Encargado">Encargado</option>
					</select></td>
				</tr>
				<tr id="generacionRow" style="display: none;">
					<td>Generación</td>
					<td><input type="number" name="generacion" id="generacionSelect" placeholder="Escriba aquí su generación..." oninput="validarNumero(event)"></td>
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

 // Función para actualizar las opciones del select de ciudades
 function actualizarCiudades() {
     const departamentoSelect = document.getElementById("departamentoSelect");
     const ciudadSelect = document.getElementById("ciudadSelect");
     const departamentoSeleccionado = departamentoSelect.value;

     ciudadSelect.innerHTML = ""; // Limpiar las opciones actuales

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

 // Definir los tipos de Rol
function actualizarCampos() {
    var rolSelect = document.getElementById("rolSelect");
    var areaRow = document.getElementById("areaRow");
    var rolTutorRow = document.getElementById("rolTutorRow");
    var generacionRow = document.getElementById("generacionRow"); // Agregar paréntesis faltante después de document.getElementById

    // Mostrar u ocultar campos según el rol seleccionado
    if (rolSelect.value === "Tutor") {
        areaRow.style.display = "table-row";
        rolTutorRow.style.display = "table-row";
    } else {
        areaRow.style.display = "none";
        rolTutorRow.style.display = "none";
    }

    if (rolSelect.value === "Estudiante") {
        generacionRow.style.display = "table-row";
    } else {
        generacionRow.style.display = "none";
    } 
}

function validarNumero(event) {
    const input = event.target;
    const valor = input.value.trim();

    if (!valor.match(/^\d+$/)) {
        input.value = valor.replace(/\D/g, ''); // Elimina cualquier carácter que no sea un número
    }
}
</script>
</body>
</html>