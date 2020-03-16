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

import br.com.logap.sistema.dao.ComplexoDAO;
import br.com.logap.sistema.model.Complexo;

/**
 * @author Luan
 */
@ManagedBean
@SessionScoped
@ViewScoped
public class ComplexoBean extends ComplexoDAO implements Serializable {
	private static final long serialVersionUID = -7580566433471411911L;

	private Complexo complexo = new Complexo();
	private List<Complexo> complexos = list();
	private Complexo complexoSelecionado = new Complexo();

	public List<Complexo> getAllComplexos() {
		return list();
	}

	public String adicionar() throws InterruptedException {
		persist(this.complexo);
		this.complexo = new Complexo();
		this.complexos = list();
		return null;
	}

	public String retirar(Complexo Complexo_rm) {
		remove(Complexo_rm);
		this.complexos = list();
		return null;
	}

	public String alterar(Complexo Complexo_rm) {
		merge(Complexo_rm);
		this.complexos = list();
		return null;
	}

	public String mostrarTodasComplexos() {
		this.complexos = list();
		return null;
	}

	public String atualizar() {
		merge(this.complexoSelecionado);
		this.complexos = list();
		this.complexoSelecionado = null;
		return null;
	}

	// GET E SETS
	public Complexo getComplexo() {
		return this.complexo;
	}

	public void setComplexo(Complexo complexo) {
		this.complexo = complexo;
	}

	public List<Complexo> getComplexos() {
		return this.complexos;
	}

	public void setComplexos(List<Complexo> complexos) {
		this.complexos = complexos;
	}

	public Complexo getComplexoSelecionada() {
		return this.complexoSelecionado;
	}

	public void setComplexoSelecionada(Complexo complexoSelecionado) {
		this.complexoSelecionado = complexoSelecionado;
	}

}
