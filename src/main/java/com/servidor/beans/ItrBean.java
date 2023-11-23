package com.servidor.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.Itr;
import com.servidor.execption.ServiciosException;


/**
 * Session Bean implementation class ItrBean
 */
@Stateless
public class ItrBean implements ItrBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ItrBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Itr> listarItr() throws ServiciosException {
		TypedQuery<Itr> query = em.createNamedQuery("Itr.findAll", Itr.class);
		return query.getResultList();
	}

	@Override
	public List<Itr> listarItrConFiltro(String nombre) throws ServiciosException {
		TypedQuery<Itr> query = em.createQuery("SELECT i FROM Itr i WHERE i.nombre LIKE :filtro", Itr.class);
		query.setParameter("filtro", nombre);
		return query.getResultList();
	}

	@Override
	public List<Itr> listarItr1() throws ServiciosException{
		TypedQuery<Itr> query = em.createQuery("SELECT i FROM Itr i WHERE i.id =1", Itr.class);
		return query.getResultList();
	}
	@Override
    public Itr crearItr(Itr itr) throws ServiciosException {
        try {
            em.persist(itr);
            em.flush();
            System.out.println("Itr creado con éxito");
            return itr;
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
	@Override
	public Long obtenerIdPorNombre(String nombreItr) {
	    TypedQuery<Long> query = em.createQuery(
	        "SELECT i.idItr FROM Itr i WHERE UPPER(i.nombre) = UPPER(:nombre)", Long.class
	    );
	    query.setParameter("nombre", nombreItr);

	    try {
	        Long itrId = query.getSingleResult();
	        return itrId;
	    } catch (NoResultException e) {
	    	System.out.println("no se encontró la id");
	        return null; // Retorna null si no se encuentra ningún resultado
	    }
	}
	@Override
    public Itr bajaLogicaItr(long idItr) throws ServiciosException {
		Itr itr = null;
        try {
        	itr = em.find(Itr.class, idItr);

            if (itr != null) {
            	Itr estadoEliminado = em.find(Itr.class, 3L);
//            	itr.setVisible(0);
                //em.flush();
            } else {
                throw new ServiciosException("No se pudo encontrar al ITR");
            }
        } catch (Exception e) {
            throw new ServiciosException("Error al buscar el ITR");
        }
        return itr;
    }
	@Override
	public Itr validarItr(long idItr) throws ServiciosException {
	    Itr itr = null;
	    try {
	        itr = em.find(Itr.class, idItr);

	        if (itr != null) {
//	            itr.setVisible(1); // Cambiar a estado válido
	        } else {
	            throw new ServiciosException("No se pudo encontrar al ITR");
	        }
	    } catch (Exception e) {
	        throw new ServiciosException("Error al buscar el ITR");
	    }
	    return itr;
	}

	@Override
    public ArrayList<Itr> listarItrEstado() {
        try {
            TypedQuery<Itr> query = em.createQuery(
                    "SELECT i FROM Itr i WHERE i.visible = 1", Itr.class);
            return new ArrayList<>(query.getResultList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Itr actualizarItr(Itr itr) throws ServiciosException {
        try {
            em.merge(itr);
            em.flush();
            System.out.println("Itr modificado con éxito");
            return itr;
        } catch (PersistenceException e) {
            throw new ServiciosException("No se pudo modificar el Itr");
        }
    }


    @Override
	public Itr buscarItr(Long id) throws ServiciosException {
		try {
			Itr itr = em.find(Itr.class, id);
		return itr;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo encontrar el ITR");
		}

	}

}
