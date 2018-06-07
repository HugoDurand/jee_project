package com.esgi.jee_project.model;

import java.util.Date;

/**
 * Model de la table taches
 */

public class Taches {
	private int id;
	private String libelle;
	private String user;
	private String date;
	private Boolean urgent;

	public Taches() {
	}

	public Taches(String libelle, String user, String date, Boolean urgent) {
		this.libelle = libelle;
		this.user = user;
		this.date = date;
		this.urgent = urgent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getUrgent() {
		return urgent;
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

}
