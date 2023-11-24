package com.servidor.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ESTADO database table.
 *
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ESTADO")
	private long idEstado;

	private String descripcion;

	//bi-directional many-to-one association to Itr
	@OneToMany(mappedBy="estado")
	private List<Itr> itrs;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="estado")
	private List<Usuario> usuarios;

	public Estado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Itr> getItrs() {
		return this.itrs;
	}

	public void setItrs(List<Itr> itrs) {
		this.itrs = itrs;
	}

	public Itr addItr(Itr itr) {
		getItrs().add(itr);
		itr.setEstado(this);

		return itr;
	}

	public Itr removeItr(Itr itr) {
		getItrs().remove(itr);
		itr.setEstado(null);

		return itr;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEstado(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEstado(null);

		return usuario;
	}

}