package com.servidor.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.Usuario;
import com.servidor.execption.PersistenciaException;
import com.servidor.execption.ServiciosException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
@LocalBean
public class UsuarioBean implements UsuarioBeanRemote {


	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor.
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Usuario crearUsuario(Usuario usuarioSeleccionado) throws ServiciosException {
		try {
			em.persist(usuarioSeleccionado);
			em.flush();
			System.out.println("Usuario creado con éxito");
			return usuarioSeleccionado;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el Usuario");
		}
	}

	@Override
	public Usuario actualizarUsuario(Usuario Usuario) throws ServiciosException {
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
	public void borrarUsuario(Long id) throws ServiciosException {
		try {
			Usuario Usuario = em.find(Usuario.class, id);
			em.remove(Usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la Usuario");
		}

	}

	@Override
	public ArrayList<Usuario> listarUsuarios() throws ServiciosException {
		try {

			TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
			return (ArrayList<Usuario>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo obtener la Usuarios");
		}
	}

	@Override
	public List<Usuario> listarUsuariosConFiltro(String nombre) throws ServiciosException {
		try {

			TypedQuery<Usuario> query = em.createQuery("SELECT c FROM Usuario c WHERE c.nombre LIKE :filtro",
					Usuario.class);
			query.setParameter("filtro", "%" + nombre + "%");
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo obtener la Usuarioes");
		}
	}

	@Override
	public List<Usuario> listarUsuariosPorDepto(String nombreDepto) throws ServiciosException {
		try {

			TypedQuery<Usuario> query = em.createQuery(
					"SELECT c FROM Usuario c INNER JOIN c.departamento d WHERE d.nombre = :nombreDepto", Usuario.class);
			query.setParameter("nombreDepto", nombreDepto);

			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo listar las cidudades por departamento");
		}
	}


	@Override
	public Usuario buscarUsuario(Long id) {
		Usuario Usuario = em.find(Usuario.class, id);
		return Usuario;
	}

	public List<Usuario> buscarEmpleados() throws PersistenciaException {
		try {

		String query= 	"Select e from Usuario e";
		List<Usuario> resultList = (List<Usuario>) em.createQuery(query,Usuario.class)
							 .getResultList();
		return  resultList;
		}catch(PersistenceException e) {
			throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(),e);
		}

	}


	@Override
	public List<Usuario> seleccionarUsuarios(String criterioNombre,
			String criterioDepartamento, Boolean criterioActivo) throws PersistenciaException {
		try {

			String query= 	"Select e from Usuario e  ";
			String queryCriterio="";
			if (criterioNombre!=null && ! criterioNombre.contentEquals("")) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " e.nombre like '%"+criterioNombre +"%' ";
			}
			if (criterioDepartamento!=null && ! criterioDepartamento.equals("")) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" e.departamento='"+criterioDepartamento+"'  " ;
			}
			/*
			if (criterioActivo!=null) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" e.activo  " ;
			}*/
			if (!queryCriterio.contentEquals("")) {
				query+=" where "+queryCriterio;
			}
			List<Usuario> resultList = (List<Usuario>) em.createQuery(query,Usuario.class)
								 .getResultList();
			return  resultList;
			}catch(PersistenceException e) {
				throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(),e);
			}
	}
}
