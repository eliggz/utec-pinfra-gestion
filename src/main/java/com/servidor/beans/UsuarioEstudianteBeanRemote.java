package com.servidor.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.servidor.entidades.UsuarioEstudiante;
import com.servidor.execption.ServiciosException;

@Remote
public interface UsuarioEstudianteBeanRemote {

	UsuarioEstudiante crearUsuarioEstudiante(UsuarioEstudiante usuarioSeleccionado) throws ServiciosException;

	UsuarioEstudiante actualizarUsuarioEstudiante(UsuarioEstudiante Usuario) throws ServiciosException;

	void borrarUsuarioEstudiante(Long id) throws ServiciosException;

	ArrayList<UsuarioEstudiante> listarUsuariosEstudiantes() throws ServiciosException;

}
