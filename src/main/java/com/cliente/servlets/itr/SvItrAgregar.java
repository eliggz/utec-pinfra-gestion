package com.cliente.servlets.itr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.servicios.ServiceItr;
import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;

/**
 * Servlet implementation class SvItrAgregar
 */
@WebServlet(name = "ServletAgregarItr", urlPatterns = "/SvItrAgregar")
public class SvItrAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvItrAgregar() {
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
		
		String nombreItr = request.getParameter("nombre");
		String departamentoItr = request.getParameter("departamento");
		
		Itr itr = new Itr();
		Estado estado = new Estado();
		estado.setIdEstado(2);
		itr.setDepartamento(departamentoItr);
		itr.setNombre(nombreItr);
		itr.setEstado(estado);
		
		Itr itrPersistida = ServiceItr.crearItr(itr);
		
		
	}

}
