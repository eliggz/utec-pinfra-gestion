package com.servidor.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import com.servidor.entidades.Usuario;
import com.servidor.execption.PersistenciaException;
import com.servidor.execption.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	Usuario crearUsuario(Usuario Usuario) throws ServiciosException;

	Usuario actualizarUsuario(Usuario Usuario) throws ServiciosException;

	void borrarUsuario(Long id) throws ServiciosException;

	ArrayList<Usuario> listarUsuarios() throws ServiciosException;

	List<Usuario> listarUsuariosConFiltro(String nombre) throws ServiciosException;

	List<Usuario> listarUsuariosPorDepto(String nombreDepto) throws ServiciosException;

	List<Usuario> seleccionarUsuarios(String criterioNombre,
			String criterioDepartamento, Boolean criterioActivo) throws PersistenciaException;
	Usuario buscarEmpleado(Long id);
}
