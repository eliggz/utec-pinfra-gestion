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
import com.cliente.servicios.ServiceUsuario;
import com.servidor.entidades.Usuario;

/**
 * Servlet implementation class SvUsuarioPerfil
 */
@WebServlet("/SvUsuarioPerfil")
public class SvUsuarioPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvUsuarioPerfil() {
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
		doGet(request, response);
		
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
		String mailPersonal = request.getParameter("mailPersonal");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		Usuario usuarioLogueado = Fabrica.getUsuarioLogueado();

					if(nombre1 != null || nombre1.equals("")) {
						usuarioLogueado.setNombre1(nombre1);
					} 
					if(nombre2 != null || nombre2.equals("")) {
						usuarioLogueado.setNombre2(nombre2);
					}
					if(apellido1 != null || apellido1.equals("")) {
						usuarioLogueado.setApellido1(apellido1);
					}
					if(apellido2 != null || apellido2.equals("")) {
						usuarioLogueado.setApellido2(apellido2);
					}
					if(documento != null || documento.equals("")) {
						usuarioLogueado.setDocumento(documento);
					}
					if(mailPersonal != null || mailPersonal.equals("")) {
						usuarioLogueado.setMailPersonal(mailPersonal);
					}
					if(password != null || password.equals("")) {
						usuarioLogueado.setPassword(password);
					}
					if(fechaNacimiento != null) {
						usuarioLogueado.setFechaNacimiento(fechaNacimiento);
					}
					if(telefono != null || telefono.equals("")) {
						usuarioLogueado.setTelefono(telefono);
					}
					
					try {
					    ServiceUsuario.actualizarUsuario(usuarioLogueado);
					    request.getSession().setAttribute("exitoMensaje", "Su usuario se actualizó correctamente");
					    response.sendRedirect("/Proyecto-PInfra/pages/configuracion/perfil.jsp");
					} catch (Exception e) {
					    e.printStackTrace();
					    request.getSession().setAttribute("errorMensaje", "Error al actualizar usuario");
					    response.sendRedirect("/Proyecto-PInfra/pages/configuracion/perfil.jsp");
					}
					
					 

	}

}
