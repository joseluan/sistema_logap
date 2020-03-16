/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logap.sistema.mbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.sistema.dao.AerogeradorDAO;
import br.com.logap.sistema.dao.ParqueDAO;
import br.com.logap.sistema.model.Aerogerador;
import br.com.logap.sistema.model.Parque;

/**
 * @author Luan
 */
@ManagedBean
@SessionScoped
@ViewScoped
public class AerogeradorBean extends AerogeradorDAO implements Serializable {
	private static final long serialVersionUID = -7580566433471411911L;

	private Aerogerador aerogerador = new Aerogerador();
	private List<Aerogerador> aerogeradores = list();
	private Aerogerador aerogeradorSelecionado = new Aerogerador();
	private int id_parque;

	public String adicionar() throws InterruptedException {
		ParqueDAO dao = new ParqueDAO();
		this.aerogerador.setParque(dao.getById(this.id_parque));
		persist(this.aerogerador);
		this.aerogerador = new Aerogerador();
		this.aerogeradores = list();
		return null;
	}

	public String retirar(Aerogerador aerogerador_rm) {
		remove(aerogerador_rm);
		this.aerogeradores = list();
		return null;
	}

	public String alterar(Aerogerador aerogerador_alt) {
		merge(aerogerador_alt);
		this.aerogeradores = list();
		return null;
	}

	public String mostrarTodosParques() {
		this.aerogeradores = list();
		return null;
	}

	public String atualizar() {
		merge(this.aerogeradorSelecionado);
		this.aerogeradores = list();
		this.aerogeradorSelecionado = null;
		return null;
	}

	public Aerogerador getAerogerador() {
		return aerogerador;
	}

	public void setAerogerador(Aerogerador aerogerador) {
		this.aerogerador = aerogerador;
	}

	public List<Aerogerador> getAerogeradores() {
		return aerogeradores;
	}

	public void setAerogeradores(List<Aerogerador> aerogeradores) {
		this.aerogeradores = aerogeradores;
	}

	public Aerogerador getAerogeradorSelecionado() {
		return aerogeradorSelecionado;
	}

	public void setAerogeradorSelecionado(Aerogerador aerogeradorSelecionado) {
		this.aerogeradorSelecionado = aerogeradorSelecionado;
	}

	public int getId_parque() {
		return id_parque;
	}

	public void setId_parque(int id_parque) {
		this.id_parque = id_parque;
	}
	
}
