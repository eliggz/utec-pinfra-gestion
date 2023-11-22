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
import com.servidor.entidades.UsuarioAnalista;
import com.servidor.execption.PersistenciaException;
import com.servidor.execption.ServiciosException;

/**
 * Session Bean implementation class UsuarioAnalistaBean
 */
@Stateless
@LocalBean
public class UsuarioAnalistaBean implements UsuarioAnalistaBeanRemote {

    /**
     * Default constructor. 
     */
    public UsuarioAnalistaBean() {
        // TODO Auto-generated constructor stub
    }

    
    @PersistenceContext
	private EntityManager em;
    /**
     * Default constructor.
     */
   

	@Override
	public UsuarioAnalista crearUsuarioAnalista(UsuarioAnalista usuarioSeleccionado) throws ServiciosException {
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
	public UsuarioAnalista actualizarUsuarioAnalista(UsuarioAnalista Usuario) throws ServiciosException {
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
	public void borrarUsuarioAnalista(Long id) throws ServiciosException {
		try {
			UsuarioAnalista Usuario = em.find(UsuarioAnalista.class, id);
			em.remove(Usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el Usuario analista");
		}

	}

	@Override
	public ArrayList<UsuarioAnalista> listarUsuariosAnalistas() throws ServiciosException {
		try {

			TypedQuery<UsuarioAnalista> query = em.createNamedQuery("UsuarioAnalista.findAll", UsuarioAnalista.class);
			return (ArrayList<UsuarioAnalista>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiciosException("No se pudo obtener los Usuarios");
		}
	}



//	@Override
//	public List<Usuario> seleccionarUsuarios(String criterioNombre,
//			String criterioDepartamento, Boolean criterioActivo) throws PersistenciaException {
//		try {
//
//			String query= 	"Select e from Usuario e  ";
//			String queryCriterio="";
//			if (criterioNombre!=null && ! criterioNombre.contentEquals("")) {
//				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " e.nombre like '%"+criterioNombre +"%' ";
//			}
//			if (criterioDepartamento!=null && ! criterioDepartamento.equals("")) {
//				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" e.departamento='"+criterioDepartamento+"'  " ;
//			}
//			/*
//			if (criterioActivo!=null) {
//				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" e.activo  " ;
//			}*/
//			if (!queryCriterio.contentEquals("")) {
//				query+=" where "+queryCriterio;
//			}
//			List<Usuario> resultList = (List<Usuario>) em.createQuery(query,Usuario.class)
//								 .getResultList();
//			return  resultList;
//			}catch(PersistenceException e) {
//				throw new PersistenciaException("No se pudo hacer la consulta." + e.getMessage(),e);
//			}
//	}
}
