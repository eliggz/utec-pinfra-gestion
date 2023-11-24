package com.cliente.servlets.usuario;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.Fabrica;
import com.cliente.servicios.ServiceEstado;
import com.cliente.servicios.ServiceItr;
import com.cliente.servicios.ServiceRol;
import com.cliente.servicios.ServiceUsuario;
import com.cliente.servicios.ServiceUsuarioAnalista;
import com.cliente.servicios.ServiceUsuarioEstudiante;
import com.cliente.servicios.ServiceUsuarioTutor;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Rol;
import com.servidor.entidades.Usuario;
import com.servidor.entidades.UsuarioAnalista;
import com.servidor.entidades.UsuarioTutor;
import com.servidor.entidades.UsuarioEstudiante;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SvUsuarioRegistro
 */
@WebServlet(name = "ServletRegistro", urlPatterns = "/SvUsuarioRegistro")
public class SvUsuarioRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvUsuarioRegistro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String nombre1 = request.getParameter("nombre1");
		String nombre2 = request.getParameter("nombre2");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String documento = request.getParameter("documento");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String fechaNacimientoStr = request.getParameter("fechaNacimiento"); 
		Date fechaNacimiento = null;

		try {
			fechaNacimiento = dateFormat.parse(fechaNacimientoStr); 
		} catch (ParseException e) {

			e.printStackTrace();
		}

		String mailInstitucional = request.getParameter("mailInstitucional");
		String mailPersonal = request.getParameter("mailPersonal");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String departamento = request.getParameter("departamento");
		String ciudad = request.getParameter("ciudad");

		Itr itr = ServiceItr.encontrarItrPorNombre(request.getParameter("itr"));
		String rolString = request.getParameter("rol");
		Rol rol = null;
		

		if(rolString.equals("Analista")) {
			rol = ServiceRol.buscarRol(1l);
			System.out.println("El rol encontrado: " + rol.getNombre()); // Verificar que se obtenga el rol correctamente
			
		} else if(rolString.equals("Tutor")) {
			rol = ServiceRol.buscarRol(2l);

		}else if(rolString.equals("Estudiante")) {

			rol = ServiceRol.buscarRol(3l);
		} else {
			System.out.println("está vacío");
		}
		


		Usuario usuario = new Usuario();
		usuario.setNombre1(nombre1);
		usuario.setNombre2(nombre2);
		usuario.setApellido1(apellido1);
		usuario.setApellido2(apellido2);
		usuario.setDocumento(documento);
		usuario.setFechaNacimiento(fechaNacimiento);
		usuario.setMailInstitucional(mailInstitucional);
		usuario.setMailPersonal(mailPersonal);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setPassword(password);
		usuario.setTelefono(telefono);
		usuario.setDepartamento(departamento);
		usuario.setCiudad(ciudad);
		usuario.setItr(itr);
		usuario.setRol(rol);
		ServiceEstado.asignarEstadoUsuario(usuario, 1l);  // el ID 1 es para inactivo!!
		
		Usuario usuarioEnLaBase = ServiceUsuario.crearUsuario(usuario);
		
		
		if(rol.getIdRol()==1) {
			UsuarioAnalista usuarioAnalista = new UsuarioAnalista();
			
			usuarioAnalista.setUsuario(usuarioEnLaBase);
			ServiceUsuarioAnalista.crearUsuarioAnalista(usuarioAnalista);
		} else if(rol.getIdRol()==2) {
			String area = request.getParameter("area");
			String rolTutor = request.getParameter("rolTutor");
			System.out.println("area: " + area);
			System.out.println("rolTutor: " + rolTutor);

			UsuarioTutor usuarioTutor = new UsuarioTutor();
			usuarioTutor.setUsuario(usuario);
			usuarioTutor.setArea(area);
			usuarioTutor.setRol(rol);

			usuarioTutor.setUsuario(usuarioEnLaBase);
			ServiceUsuarioTutor.crearUsuarioTutor(usuarioTutor);

		} else if(rol.getIdRol()==3) {
			int generacion=  Integer.parseInt(request.getParameter("generacion"));
			System.out.println("generacion: " + generacion);
			UsuarioEstudiante usuarioEstudiante = new UsuarioEstudiante();
			usuarioEstudiante.setUsuario(usuario);
			usuarioEstudiante.setGeneracion(generacion);
			usuarioEstudiante.setUsuario(usuarioEnLaBase);
			ServiceUsuarioEstudiante.crearUsuarioEstudiante(usuarioEstudiante);
		}


		

		System.out.println("nombre1: " + nombre1);
		System.out.println("nombre2: " + nombre2);
		System.out.println("apellido1: " + apellido1);
		System.out.println("apellido2: " + apellido2);
		System.out.println("documento: " + documento);
		System.out.println("fechaNacimiento: " + fechaNacimiento);
		System.out.println("mailInstitucional: " + mailInstitucional);
		System.out.println("mailPersonal: " + mailPersonal);
		System.out.println("nombreUsuario: " + nombreUsuario);
		System.out.println("password: " + password);
		System.out.println("telefono: " + telefono);
		System.out.println("departamento: " + departamento);
		System.out.println("ciudad: " + ciudad);
		System.out.println("rol: " + rol.getNombre());

	}



}
