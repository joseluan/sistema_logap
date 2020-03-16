/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logap.sistema.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.logap.sistema.model.Usuario;

/**
 *
 * @author Luan
 */
public class UsuarioDAO implements Serializable {
	private static final long serialVersionUID = -8892665506599113364L;
	private EntityManager em = Database.getInstance().getEntityManager();

	public Usuario findWithLoginAndPassword(String login, String senha) {
		Query query = em.createQuery("SELECT x FROM Usuario x WHERE x.login = :login and x.password = :password ");
		query.setParameter("login", login);
		query.setParameter("password", senha);
		return (Usuario) query.getSingleResult();
	}

	public Usuario getById(int id) {
		Usuario u = new Usuario();
		try {
			u = em.find(Usuario.class, id);
		} catch (NullPointerException e) {
			return null;
		}
		return u;
	}

	public void persist(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		List<Usuario> lista = null;
		try {
			Query query = this.em.createQuery("SELECT x FROM Usuario x");
			lista = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lista;
	}

	public void merge(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void remove(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

}
