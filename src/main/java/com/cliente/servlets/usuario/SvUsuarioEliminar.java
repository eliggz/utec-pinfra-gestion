package com.cliente.servlets.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.servicios.ServiceEstado;
import com.cliente.servicios.ServiceItr;
import com.cliente.servicios.ServiceUsuario;
import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Usuario;

/**
 * Servlet implementation class SvUsuarioEliminar
 */
@WebServlet("/SvUsuarioEliminar")
public class SvUsuarioEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvUsuarioEliminar() {
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
		
		Long id = null;
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
		     id = Long.parseLong(idParam);
		 
		} else {
			request.getSession().setAttribute("errorMensaje", "No se pudo Eliminar el Usuario");
		}
		Estado estado = ServiceEstado.buscarEstado(3l);
		
		Usuario usuarioModificado = ServiceUsuario.buscarUsuario(id);
		
		usuarioModificado.setEstado(estado);
		
		if (ServiceUsuario.actualizarUsuario(usuarioModificado) != null) {
			response.sendRedirect("/Proyecto-PInfra/pages/configuracion/usuarios.jsp");
		}else {
			request.getSession().setAttribute("errorMensaje", "No se pudo Eliminar el Usuario");
		}
	
	}

}
