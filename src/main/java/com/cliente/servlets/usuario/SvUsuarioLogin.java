package com.cliente.servlets.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.Fabrica;
import com.cliente.servicios.ServiceUsuario;
import com.servidor.entidades.Usuario;

@WebServlet(name = "ServletLogin", urlPatterns = "/SvUsuarioLogin")
public class SvUsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SvUsuarioLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().removeAttribute("errorMensaje");

		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");

		if (nombreUsuario.isEmpty() || clave.isEmpty()) {
			request.getSession().setAttribute("errorMensaje", "Los campos son obligatorios");
			response.sendRedirect("/Proyecto-PInfra/pages/login/login.jsp");
			return;
		}

		Usuario usuarioLogueado = ServiceUsuario.login(nombreUsuario, clave);

		if (usuarioLogueado == null) {
			request.getSession().setAttribute("errorMensaje", "Datos de Usuario incorrectos o Usuario Sin Validar");
			response.sendRedirect("/Proyecto-PInfra/pages/login/login.jsp");
			return;
		} 

		request.getSession().removeAttribute("errorMensaje");
		request.getSession().setAttribute("usuarioLogueado", usuarioLogueado);
		Fabrica.setUsuarioLogueado(usuarioLogueado);
		response.sendRedirect("/Proyecto-PInfra/pages/home/home.jsp");

	}

}
