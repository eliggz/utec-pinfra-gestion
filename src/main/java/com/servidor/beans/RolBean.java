package com.servidor.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.Rol;
import com.servidor.execption.ServiciosException;


/**
 * Session Bean implementation class RolBean
 */
@Stateless
public class RolBean implements RolBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public RolBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Rol> listarRoles() throws ServiciosException {
		TypedQuery<Rol> query = em.createNamedQuery("Rol.findAll", Rol.class);
		return query.getResultList();
	}

	@Override
	public List<Rol> listarRolConFiltro(String nombre) throws ServiciosException {
		TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r WHERE r.nombre LIKE :filtro", Rol.class);
		query.setParameter("filtro", "%" + nombre + "%");
		return query.getResultList();
	}

	   @Override
		public Rol buscarRol(Long id) throws ServiciosException {
			try {
				Rol rol = em.find(Rol.class, id);
			return rol;
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar el rol");
			}

		}
}
