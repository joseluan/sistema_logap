package br.com.logap.sistema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.jetbrains.annotations.Nullable;

@Entity
public class Parque {

	@Id
	@GeneratedValue
	private int id;

	@Nullable
	private String nome;

	private int latitude;

	private int longitude;

	@Nullable
	private float potencia_instalada;

	@ManyToOne
	@Nullable
	private Complexo complexo;

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

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public float getPotencia_instalada() {
		return potencia_instalada;
	}

	public void setPotencia_instalada(float potencia_instalada) {
		this.potencia_instalada = potencia_instalada;
	}

	public Complexo getComplexo() {
		return complexo;
	}

	public void setComplexo(Complexo complexo) {
		this.complexo = complexo;
	}

}
