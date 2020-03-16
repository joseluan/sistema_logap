package br.com.logap.sistema.mbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.logap.sistema.utils.AbstractController;

@ManagedBean
@SessionScoped
public class ListaBean extends AbstractController{
	private int num, sum;
	List<Integer> lista = new ArrayList<Integer>();
	
	public String add() {
		this.lista.add(this.num);
		addMsgInfo("12345679!");
		return "";
	}
	
	public String isSum() {
		for(int item: this.lista) {
			int i = Collections.binarySearch(this.lista, this.sum-item); 
			if(i >= 0) {				
				int temp = this.lista.get(i);
				addMsgInfo("Os n�meros encontrados s�o: " + item + " + " + temp + " = " + this.sum);
			}
		} 
		return null;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public List<Integer> getLista() {
		return lista;
	}

	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}
	
}
