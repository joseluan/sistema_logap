package br.com.logap.sistema.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.jetbrains.annotations.Nullable;

@Entity
public class Complexo {
	@Id
	@GeneratedValue
	private int id;

	@Nullable
	private String nome;

	@Nullable
	private String identificador;

	private String uf;

	@OneToMany(mappedBy = "complexo", targetEntity = Parque.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Parque> parques;

	// gets e sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Parque> getParques() {
		return parques;
	}

	public void setParques(List<Parque> parques) {
		this.parques = parques;
	}

}
