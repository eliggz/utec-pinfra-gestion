package com.servidor.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Usuario;
import com.servidor.execption.ServiciosException;


/**
 * Session Bean implementation class EstadoBean
 */
@Stateless
@LocalBean
public class EstadoBean implements EstadoBeanRemote {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor.
     */
    public EstadoBean() {
        // TODO Auto-generated constructor stub
    }

    public Estado buscarEstado(Long id) throws ServiciosException {
		try {
			Estado estado = em.find(Estado.class, id);
		return estado;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo encontrar el estado");
		}

	}
    
    
    @Override
	public List<Estado> listarEstados() throws ServiciosException {
		TypedQuery<Estado> query = em.createNamedQuery("Estado.findAll", Estado.class);
		return query.getResultList();
	}
    
    
    @Override
	public Long obtenerIdPorNombre(String nombre) {
	    TypedQuery<Long> query = em.createQuery(
	        "SELECT i.idEstado FROM Estado i WHERE UPPER(i.nombre) = UPPER(:nombre)", Long.class
	    );
	    query.setParameter("nombre", nombre);

	    try {
	        Long id = query.getSingleResult();
	        return id;
	    } catch (NoResultException e) {
	    	System.out.println("no se encontró la id");
	        return null; // Retorna null si no se encuentra ningún resultado
	    }
	}
}
