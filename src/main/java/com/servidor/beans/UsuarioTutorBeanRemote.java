package com.servidor.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.servidor.entidades.UsuarioTutor;
import com.servidor.execption.ServiciosException;

@Remote
public interface UsuarioTutorBeanRemote {

	UsuarioTutor crearUsuarioTutor(UsuarioTutor usuarioSeleccionado) throws ServiciosException;

	UsuarioTutor actualizarUsuarioTutor(UsuarioTutor Usuario) throws ServiciosException;

	void borrarUsuarioTutor(Long id) throws ServiciosException;

	ArrayList<UsuarioTutor> listarUsuariosTutores() throws ServiciosException;

}
