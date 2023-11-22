package com.servidor.beans;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.UsuarioEstudiante;
import com.servidor.execption.ServiciosException;

/**
 * Session Bean implementation class UsuarioEstudianteBean
 */
@Stateless
@LocalBean
public class UsuarioEstudianteBean implements UsuarioEstudianteBeanRemote {

	/**
	 * Default constructor. 
	 */
	public UsuarioEstudianteBean() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public UsuarioEstudiante crearUsuarioEstudiante(UsuarioEstudiante usuarioSeleccionado) throws ServiciosException {
		try {
			em.persist(usuarioSeleccionado);
			em.flush();
			System.out.println("Usuario analista creado con éxito");
			return usuarioSeleccionado;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el Usuario analista");
		}
	}

	@Override
	public UsuarioEstudiante actualizarUsuarioEstudiante(UsuarioEstudiante Usuario) throws ServiciosException {
		try {
			em.merge(Usuario);
			em.flush();
			System.out.println("Usuario modificada con éxito");
			return Usuario;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar la Usuario");
		}
	}

	@Override
	public void borrarUsuarioEstudiante(Long id) throws ServiciosException {
		try {
			UsuarioEstudiante Usuario = em.find(UsuarioEstudiante.class, id);
			em.remove(Usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el Usuario analista");
		}

	}

	@Override
	public ArrayList<UsuarioEstudiante> listarUsuariosEstudiantes() throws ServiciosException {
		try {

			TypedQuery<UsuarioEstudiante> query = em.createNamedQuery("UsuarioEstudiante.findAll", UsuarioEstudiante.class);
			return (ArrayList<UsuarioEstudiante>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo obtener los Usuarios");
		}
	}

}
