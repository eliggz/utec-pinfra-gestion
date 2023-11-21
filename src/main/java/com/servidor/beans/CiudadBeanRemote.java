package com.servidor.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import com.servidor.entidades.Ciudad;
import com.servidor.execption.ServiciosException;


@Remote
public interface CiudadBeanRemote {

	Ciudad crearCiudad(Ciudad ciudad) throws ServiciosException;

	Ciudad actualizarCiudad(Ciudad ciudad) throws ServiciosException;

	void borrarCiudad(Long id) throws ServiciosException;

	ArrayList<Ciudad> listarCiudades() throws ServiciosException;

	List<Ciudad> listarCiudadesConFiltro(String nombre) throws ServiciosException;

	List<Ciudad> listarCiudadesPorDepto(String nombreDepto) throws ServiciosException;

	Ciudad buscarCiudad(Long id) throws ServiciosException;

}
