package com.servidor.beans;

import java.util.List;

import javax.ejb.Remote;

import com.servidor.entidades.Rol;
import com.servidor.execption.ServiciosException;


@Remote
public interface RolBeanRemote {

	List<Rol> listarRoles()throws ServiciosException;

	List<Rol> listarRolConFiltro(String nombre)throws ServiciosException;

	Rol buscarRol(Long id) throws ServiciosException;

}
