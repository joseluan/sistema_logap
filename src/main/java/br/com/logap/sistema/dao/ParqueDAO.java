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
import br.com.logap.sistema.model.Parque;

/**
 *
 * @author Luan
 */
public class ParqueDAO implements Serializable {
	private static final long serialVersionUID = -8892665506599113364L;
	private EntityManager em = Database.getInstance().getEntityManager();
	
	public Parque getById(int id) {
		Parque p = new Parque();
		try {
			p = em.find(Parque.class, id);
		} catch (NullPointerException e) {
			return null;
		}
		return p;
	}
	
	public void persist(Parque parque) {
		try {
			em.getTransaction().begin();
			em.persist(parque);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Parque> list() {
		List<Parque> lista = null;
		try {
			Query query = this.em.createQuery("SELECT x FROM Parque x");
			lista = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lista;
	}

	public void merge(Parque parque) {
		try {
			em.getTransaction().begin();
			em.merge(parque);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void remove(Parque parque) {
		try {
			em.getTransaction().begin();
			em.remove(parque);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

}
