package com.cliente.servlets.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.servicios.ServiceItr;
import com.cliente.servicios.ServiceUsuario;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Usuario;

/**
 * Servlet implementation class SvUsuarioModificar
 */
@WebServlet("/SvUsuarioModificar")
public class SvUsuarioModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvUsuarioModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("departamento");
		long idUsu = Long.parseLong(request.getParameter("id"));

		Usuario usuarioModificado = ServiceUsuario.buscarUsuario(idUsu);
		usuarioModificado.setNombre1(nombre );
		usuarioModificado.setApellido1(apellido);
		usuarioModificado.setDocumento(documento);

		if (ServiceUsuario.actualizarUsuario(usuarioModificado) != null) {
			response.sendRedirect("/Proyecto-PInfra/pages/configuracion/usuarios.jsp");
		}else {
			request.getSession().setAttribute("errorMensaje", "No se pudo Modificar el Usuario");
		}
	}

}
