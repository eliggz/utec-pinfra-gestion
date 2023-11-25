package com.servidor.beans;

import java.util.List;

import javax.ejb.Remote;

import com.servidor.entidades.Estado;
import com.servidor.execption.ServiciosException;


@Remote
public interface EstadoBeanRemote {

	Estado buscarEstado(Long id) throws ServiciosException;

	List<Estado> listarEstados() throws ServiciosException;

	Long obtenerIdPorNombre(String nombre);

}
