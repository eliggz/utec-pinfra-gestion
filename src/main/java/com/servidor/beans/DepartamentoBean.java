package com.servidor.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.Departamento;
import com.servidor.execption.ServiciosException;


/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class DepartamentoBean implements DepartamentoBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public DepartamentoBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Departamento crearDepartamento(Departamento departamento) throws ServiciosException {
		try {
			em.persist(departamento);
			em.flush();
			System.out.println("Departamento creado con éxito");
			return departamento;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el departamento");
		}
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) throws ServiciosException {
		try {
			em.merge(departamento);
			em.flush();
			System.out.println("Departamento modificado con éxito");
			return departamento;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el departamento");
		}
	}

	@Override
	public void borrarDepartamento(Long id) throws ServiciosException {
		try {
			Departamento departamento = em.find(Departamento.class, id);
			em.remove(departamento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el departamento");
		}

	}

	@Override
	public Departamento buscarDepartamento(Long id) throws ServiciosException {
		try {
			Departamento departamento = em.find(Departamento.class, id);
		return departamento;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo encontrar el departamento");
		}

	}

	@Override
	public List<Departamento> listarDepartamentos() throws ServiciosException {
		try {
			TypedQuery<Departamento> query = em.createNamedQuery("Departamento.findAll", Departamento.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo borrar el departamento");
		}
	}

	@Override
	public List<Departamento> listarDepartamentoFiltro(String nombre) throws ServiciosException {
		try {
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d WHERE d.nombre LIKE :filtro",
					Departamento.class);
			query.setParameter("filtro", "%" + nombre + "%");
			return query.getResultList();

		} catch (PersistenceException e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo borrar el departamento");
		}
	}

}
