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

import br.com.logap.sistema.model.Aerogerador;
import br.com.logap.sistema.model.Complexo;

/**
 *
 * @author Luan
 */
public class AerogeradorDAO implements Serializable {
	private static final long serialVersionUID = -8892665506599113364L;
	private EntityManager em = Database.getInstance().getEntityManager();
	
	public Aerogerador getById(int id) {
		Aerogerador ae = new Aerogerador();
		try {
			ae = em.find(Aerogerador.class, id);
		} catch (NullPointerException e) {
			return null;
		}
		return ae;
	}

	public void persist(Aerogerador aerogerador) {
		try {
			em.getTransaction().begin();
			em.persist(aerogerador);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Aerogerador> list() {
		List<Aerogerador> lista = null;
		try {
			Query query = this.em.createQuery("SELECT x FROM Aerogerador x");
			lista = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lista;
	}

	public void merge(Aerogerador aerogerador) {
		try {
			em.getTransaction().begin();
			em.merge(aerogerador);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void remove(Aerogerador aerogerador) {
		try {
			em.getTransaction().begin();
			em.remove(aerogerador);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

}
