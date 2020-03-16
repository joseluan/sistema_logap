package br.com.logap.sistema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.jetbrains.annotations.Nullable;

@Entity
public class Aerogerador {

	@Id
	@GeneratedValue
	private int id;

	@Nullable
	private String nome;

	private float latitude;

	private float longitude;

	@Nullable
	private float altura_torre;
	
	private float diametro_varredura;
	
	private String modelo;
	
	@ManyToOne
	@Nullable
	private Parque parque;

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

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getAltura_torre() {
		return altura_torre;
	}

	public void setAltura_torre(float altura_torre) {
		this.altura_torre = altura_torre;
	}

	public float getDiametro_varredura() {
		return diametro_varredura;
	}

	public void setDiametro_varredura(float diametro_varredura) {
		this.diametro_varredura = diametro_varredura;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Parque getParque() {
		return parque;
	}

	public void setParque(Parque parque) {
		this.parque = parque;
	}
	
}
