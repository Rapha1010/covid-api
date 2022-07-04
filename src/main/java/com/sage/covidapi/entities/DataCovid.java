package com.sage.covidapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.h2.store.Data;

@Entity
@Table(name = "data_covid")
public class DataCovid implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String date;
	private String uf;
	private String city;
	private Integer confirmedCases;
	private Integer deaths;
	private Integer estimatedPopulation;
	
	public DataCovid() {}
	
	public DataCovid( String data, String uf, String city, Integer confirmedCases, Integer deaths, Integer estimatedPopulation) {
		super();
		this.date = data;
		this.uf = uf;
		this.city = city;
		this.confirmedCases = confirmedCases;
		this.deaths = deaths;
		this.estimatedPopulation = estimatedPopulation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return date;
	}

	public void setData(String data) {
		this.date = data;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getConfirmedCases() {
		return confirmedCases;
	}

	public void setConfirmedCases(Integer confirmedCases) {
		this.confirmedCases = confirmedCases;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getEstimatedPopulation() {
		return estimatedPopulation;
	}

	public void setEstimatedPopulation(Integer estimatedPopulation) {
		this.estimatedPopulation = estimatedPopulation;
	}
	
	
	
}
