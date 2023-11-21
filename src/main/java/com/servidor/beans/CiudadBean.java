package com.servidor.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.Ciudad;
import com.servidor.execption.ServiciosException;

/**
 * Session Bean implementation class CiudadBean
 */
@Stateless
public class CiudadBean implements CiudadBeanRemote {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CiudadBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Ciudad crearCiudad(Ciudad ciudad) throws ServiciosException {
		try {
			em.persist(ciudad);
			em.flush();
			System.out.println("Ciudad creada con éxito");
			return ciudad;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear la ciudad");
		}
	}

	@Override
	public Ciudad actualizarCiudad(Ciudad ciudad) throws ServiciosException {
		try {
			em.merge(ciudad);
			em.flush();
			System.out.println("Ciudad modificada con éxito");
			return ciudad;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar la ciudad");
		}
	}

	@Override
	public void borrarCiudad(Long id) throws ServiciosException {
		try {
			Ciudad ciudad = em.find(Ciudad.class, id);
			em.remove(ciudad);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la ciudad");
		}

	}

	@Override
	public ArrayList<Ciudad> listarCiudades() throws ServiciosException {
		try {

			TypedQuery<Ciudad> query = em.createNamedQuery("Ciudad.findAll", Ciudad.class);
			return (ArrayList<Ciudad>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo obtener la ciudades");
		}
	}

	@Override
	public List<Ciudad> listarCiudadesConFiltro(String nombre) throws ServiciosException {
		try {

			TypedQuery<Ciudad> query = em.createQuery("SELECT c FROM Ciudad c WHERE c.nombre LIKE :filtro",
					Ciudad.class);
			query.setParameter("filtro", "%" + nombre + "%");
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo obtener la ciudades");
		}
	}

	@Override
	public List<Ciudad> listarCiudadesPorDepto(String nombreDepto) throws ServiciosException {
		try {

			TypedQuery<Ciudad> query = em.createQuery(
					"SELECT c FROM Ciudad c INNER JOIN c.departamento d WHERE d.nombre = :nombreDepto", Ciudad.class);
			query.setParameter("nombreDepto", nombreDepto);

			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo listar las cidudades por departamento");
		}
	}


	@Override
	public Ciudad buscarCiudad(Long id) throws ServiciosException {
		try {
			Ciudad ciudad = em.find(Ciudad.class, id);
		return ciudad;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo encontrar la ciudad");
		}

	}

}
