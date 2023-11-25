package com.cliente.servlets.itr;

import java.awt.image.RescaleOp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.servicios.ServiceItr;
import com.servidor.entidades.Itr;

@WebServlet("/SvItrModificar")
public class SvItrModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvItrModificar() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		String nombre = request.getParameter("nombre");
		String departamento = request.getParameter("departamento");
		long idItr = Long.parseLong(request.getParameter("id"));

		Itr itrModificado = ServiceItr.buscarItr(idItr);
		itrModificado.setNombre(nombre);
		itrModificado.setDepartamento(departamento);
		if (ServiceItr.actualizarItr(itrModificado) != null) {
			response.sendRedirect("/Proyecto-PInfra/pages/configuracion/itr.jsp");
		}else {
			request.getSession().setAttribute("errorMensaje", "No se pudo Modificar el ITR");
		}
	}
}
