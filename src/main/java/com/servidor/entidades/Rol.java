package com.servidor.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ROL database table.
 *
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_IDROL_GENERATOR", sequenceName="ROL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_IDROL_GENERATOR")
	@Column(name="ID_ROL")
	private long idRol;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to RolFuncion
	@OneToMany(mappedBy="rol")
	private List<RolFuncion> rolFuncions;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to UsuarioTutor
	@OneToMany(mappedBy="rol")
	private List<UsuarioTutor> usuarioTutors;

	public Rol() {
	}

	public long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RolFuncion> getRolFuncions() {
		return this.rolFuncions;
	}

	public void setRolFuncions(List<RolFuncion> rolFuncions) {
		this.rolFuncions = rolFuncions;
	}

	public RolFuncion addRolFuncion(RolFuncion rolFuncion) {
		getRolFuncions().add(rolFuncion);
		rolFuncion.setRol(this);

		return rolFuncion;
	}

	public RolFuncion removeRolFuncion(RolFuncion rolFuncion) {
		getRolFuncions().remove(rolFuncion);
		rolFuncion.setRol(null);

		return rolFuncion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

	public List<UsuarioTutor> getUsuarioTutors() {
		return this.usuarioTutors;
	}

	public void setUsuarioTutors(List<UsuarioTutor> usuarioTutors) {
		this.usuarioTutors = usuarioTutors;
	}

	public UsuarioTutor addUsuarioTutor(UsuarioTutor usuarioTutor) {
		getUsuarioTutors().add(usuarioTutor);
		usuarioTutor.setRol(this);

		return usuarioTutor;
	}

	public UsuarioTutor removeUsuarioTutor(UsuarioTutor usuarioTutor) {
		getUsuarioTutors().remove(usuarioTutor);
		usuarioTutor.setRol(null);

		return usuarioTutor;
	}

}