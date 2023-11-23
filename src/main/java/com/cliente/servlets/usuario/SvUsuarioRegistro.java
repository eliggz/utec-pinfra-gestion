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
import com.cliente.servicios.ServiceItr;
import com.cliente.servicios.ServiceRol;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Rol;

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
		Long idRol = null;
		switch (rolString.toLowerCase()) {
	        case "analista":
	            idRol = 1l;
	            break;
	        case "tutor":
	        	idRol = 2l;
	            break;
	        case "estudiante":
	        	idRol = 3l;
	            break;
	    }
		Rol rol = ServiceRol.buscarRol(idRol);
		
		if(request.getParameter("area") != null || request.getParameter("rolTutor") != null) {
			String area = request.getParameter("area");
			String rolTutor = request.getParameter("rolTutor");
			System.out.println("area: " + area);
			System.out.println("rolTutor: " + rolTutor);
		} 
		
		if(request.getParameter("generacion") != null) {
			int generacion=  Integer.parseInt(request.getParameter("generacion"));
			System.out.println("generacion: " + generacion);
		
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
		
	}
	
	

}
