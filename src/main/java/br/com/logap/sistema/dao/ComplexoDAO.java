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

import br.com.logap.sistema.model.Complexo;

/**
 *
 * @author Luan
 */
public class ComplexoDAO implements Serializable {
	private static final long serialVersionUID = -8892665506599113364L;
	private EntityManager em = Database.getInstance().getEntityManager();

	public Complexo getById(int id) {
		Complexo ce = new Complexo();
		try {
			ce = em.find(Complexo.class, id);
		} catch (NullPointerException e) {
			return null;
		}
		return ce;
	}

	public void persist(Complexo complexo) {
		try {
			em.getTransaction().begin();
			em.persist(complexo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Complexo> list() {
		List<Complexo> lista = null;
		try {
			Query query = this.em.createQuery("SELECT x FROM Complexo x");
			lista = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lista;
	}

	public void merge(Complexo complexo) {
		try {
			em.getTransaction().begin();
			em.merge(complexo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void remove(Complexo complexo) {
		try {
			em.getTransaction().begin();
			em.remove(complexo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

}
