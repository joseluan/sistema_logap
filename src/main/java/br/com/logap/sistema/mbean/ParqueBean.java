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
import br.com.logap.sistema.dao.ComplexoDAO;
import br.com.logap.sistema.dao.ParqueDAO;
import br.com.logap.sistema.model.Aerogerador;
import br.com.logap.sistema.model.Complexo;
import br.com.logap.sistema.model.Parque;

/**
 * @author Luan
 */
@ManagedBean
@SessionScoped
@ViewScoped
public class ParqueBean extends ParqueDAO implements Serializable {
	private static final long serialVersionUID = -7580566433471411911L;

	private Parque parque = new Parque();
	private List<Parque> parques = list();
	private Parque parqueSelecionado = new Parque();
	private int id_complexo;

	public String adicionar() throws InterruptedException {
		ComplexoDAO dao = new ComplexoDAO();
		this.parque.setComplexo(dao.getById(this.id_complexo));
		persist(this.parque);
		this.parque = new Parque();
		parques = list();
		return null;
	}

	public String retirar(Parque parque_rm) {
		remove(parque_rm);
		this.parques = list();
		return null;
	}

	public String alterar(Parque parque_alt) {
		merge(parque_alt);
		this.parques = list();
		return null;
	}

	public String mostrarTodosParques() {
		this.parques = list();
		return null;
	}

	public String atualizar() {
		merge(this.parqueSelecionado);
		this.parques = list();
		this.parqueSelecionado = null;
		return null;
	}
	
	public List<Parque> getAllParques() {
		return list();
	}

	public Parque getParque() {
		return parque;
	}

	public void setParque(Parque parque) {
		this.parque = parque;
	}

	public List<Parque> getParques() {
		return parques;
	}

	public void setParques(List<Parque> parques) {
		this.parques = parques;
	}

	public Parque getParqueSelecionado() {
		return parqueSelecionado;
	}

	public void setParqueSelecionado(Parque parqueSelecionado) {
		this.parqueSelecionado = parqueSelecionado;
	}

	public int getId_complexo() {
		return id_complexo;
	}

	public void setId_complexo(int id_complexo) {
		this.id_complexo = id_complexo;
	}

	
}
