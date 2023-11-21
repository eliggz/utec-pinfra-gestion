package com.servidor.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the DEPARTAMENTOS database table.
 *
 */
@Entity
@Table(name="DEPARTAMENTOS")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTAMENTOS_IDDEPTO_GENERATOR", sequenceName="DEPARTAMENTOS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTAMENTOS_IDDEPTO_GENERATOR")
	@Column(name="ID_DEPTO")
	private long idDepto;

	private String nombre;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="departamento")
	private List<Ciudad> ciudades;

	//bi-directional many-to-one association to Itr
	@OneToMany(mappedBy="departamento")
	private List<Itr> itrs;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="departamento")
	private List<Usuario> usuarios;

	public Departamento() {
	}


	public Departamento(long idDepto) {
		super();
		this.idDepto = idDepto;
	}



	public long getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(long idDepto) {
		this.idDepto = idDepto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Ciudad addCiudade(Ciudad ciudade) {
		getCiudades().add(ciudade);
		ciudade.setDepartamento(this);

		return ciudade;
	}

	public Ciudad removeCiudade(Ciudad ciudade) {
		getCiudades().remove(ciudade);
		ciudade.setDepartamento(null);

		return ciudade;
	}

	public List<Itr> getItrs() {
		return this.itrs;
	}

	public void setItrs(List<Itr> itrs) {
		this.itrs = itrs;
	}

	public Itr addItr(Itr itr) {
		getItrs().add(itr);
		itr.setDepartamento(this);

		return itr;
	}

	public Itr removeItr(Itr itr) {
		getItrs().remove(itr);
		itr.setDepartamento(null);

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
		usuario.setDepartamento(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setDepartamento(null);

		return usuario;
	}

}