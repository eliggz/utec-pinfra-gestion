package com.servidor.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 * Session Bean implementation class RolFuncionalidadBean
 */
@Stateless
public class RolFuncionalidadBean implements RolFuncionalidadBeanRemote {


	@PersistenceContext
	private EntityManager em;


    /**
     * Default constructor.
     */
    public RolFuncionalidadBean() {
        // TODO Auto-generated constructor stub
    }



}
