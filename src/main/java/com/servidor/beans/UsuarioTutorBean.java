package com.servidor.beans;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.UsuarioTutor;
import com.servidor.execption.ServiciosException;

/**
 * Session Bean implementation class UsuarioTutorBean
 */
@Stateless
@LocalBean
public class UsuarioTutorBean implements UsuarioTutorBeanRemote {

    /**
     * Default constructor. 
     */
    public UsuarioTutorBean() {
        // TODO Auto-generated constructor stub
    }
    
    
	@PersistenceContext
	private EntityManager em;

	@Override
	public UsuarioTutor crearUsuarioTutor(UsuarioTutor usuarioSeleccionado) throws ServiciosException {
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
	public UsuarioTutor actualizarUsuarioTutor(UsuarioTutor Usuario) throws ServiciosException {
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
	public void borrarUsuarioTutor(Long id) throws ServiciosException {
		try {
			UsuarioTutor Usuario = em.find(UsuarioTutor.class, id);
			em.remove(Usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el Usuario analista");
		}

	}

	@Override
	public ArrayList<UsuarioTutor> listarUsuariosTutores() throws ServiciosException {
		try {

			TypedQuery<UsuarioTutor> query = em.createNamedQuery("UsuarioTutor.findAll", UsuarioTutor.class);
			return (ArrayList<UsuarioTutor>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo obtener los Usuarios");
		}
	}

}
