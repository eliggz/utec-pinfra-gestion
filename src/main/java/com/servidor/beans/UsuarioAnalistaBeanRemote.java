package com.servidor.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.servidor.entidades.UsuarioAnalista;
import com.servidor.execption.ServiciosException;

@Remote
public interface UsuarioAnalistaBeanRemote {

	void borrarUsuarioAnalista(Long id) throws ServiciosException;

	UsuarioAnalista actualizarUsuarioAnalista(UsuarioAnalista Usuario) throws ServiciosException;

	/**
	 * Default constructor.
	 */
	UsuarioAnalista crearUsuarioAnalista(UsuarioAnalista usuarioSeleccionado) throws ServiciosException;

	ArrayList<UsuarioAnalista> listarUsuariosAnalistas() throws ServiciosException;

}
