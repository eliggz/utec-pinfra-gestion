package com.cliente.servlets.itr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.servicios.ServiceEstado;
import com.cliente.servicios.ServiceItr;
import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;

/**
 * Servlet implementation class SvItrEliminar
 */
@WebServlet("/SvItrEliminar")
public class SvItrEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvItrEliminar() {
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
		Long idItr = null;
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
		     idItr = Long.parseLong(idParam);
		 
		} else {
			request.getSession().setAttribute("errorMensaje", "No se pudo Eliminar el ITR");
		}
		Estado estado = ServiceEstado.buscarEstado(3l);
		
		Itr itrModificado = ServiceItr.buscarItr(idItr);
		
		itrModificado.setEstado(estado);
		
		if (ServiceItr.actualizarItr(itrModificado) != null) {
			response.sendRedirect("/Proyecto-PInfra/pages/configuracion/itr.jsp");
		}else {
			request.getSession().setAttribute("errorMensaje", "No se pudo Eliminar el ITR");
		}
	}

}
