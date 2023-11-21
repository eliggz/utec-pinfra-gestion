package com.servidor.entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the USUARIO_ANALISTA database table.
 *
 */
@Entity
@Table(name="USUARIO_ANALISTA")
@NamedQuery(name="UsuarioAnalista.findAll", query="SELECT u FROM UsuarioAnalista u")
public class UsuarioAnalista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ANALISTA_IDANALISTA_GENERATOR", sequenceName="ANALISTAS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ANALISTA_IDANALISTA_GENERATOR")
	@Column(name="ID_ANALISTA")
	private long idAnalista;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public UsuarioAnalista() {
	}

	public long getIdAnalista() {
		return this.idAnalista;
	}

	public void setIdAnalista(long idAnalista) {
		this.idAnalista = idAnalista;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}