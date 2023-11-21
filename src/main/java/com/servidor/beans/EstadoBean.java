package com.servidor.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.servidor.entidades.Estado;
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

    @Override
	public Estado buscarEstado(Long id) throws ServiciosException {
		try {
			Estado estado = em.find(Estado.class, id);
		return estado;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo encontrar el estado");
		}

	}

}
