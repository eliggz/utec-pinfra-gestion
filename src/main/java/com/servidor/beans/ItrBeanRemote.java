package com.servidor.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import com.servidor.entidades.Itr;
import com.servidor.execption.ServiciosException;

@Remote
public interface ItrBeanRemote {

	List<Itr> listarItr() throws ServiciosException;

	List<Itr> listarItrConFiltro(String nombre) throws ServiciosException;

	List<Itr> listarItr1() throws ServiciosException;

	Itr crearItr(Itr itr) throws ServiciosException;

	ArrayList<Itr> listarItrEstado();

	Long obtenerIdPorNombre(String nombreItr);

	Itr bajaLogicaItr(long idItr) throws ServiciosException;

	Itr validarItr(long idItr) throws ServiciosException;

	Itr actualizarItr(Itr itr) throws ServiciosException;

	Itr buscarItr(Long id) throws ServiciosException;

	ArrayList<Itr> listarItrValidadas();

	ArrayList<Itr> listarItrNoValidadas();



}
