package br.com.logap.sistema.dao;

import javax.persistence.EntityManager;

public class Main {
	public static void main(String[] args) {
		EntityManager em = Database.getInstance().getEntityManager();
		System.out.println("Deu certo");
	}
}
