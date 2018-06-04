package com.esgi.jee_project.domaine;

import java.util.Date;

public class Taches {
	
	public int id;
	private String libelle;
	private int id_user;
	private Date date;
	private Boolean urgent;
	
	public Taches(){
		super();
	}
	
	
	public Taches(int id, String libelle, int id_user, Date date, Boolean urgent) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.id_user = id_user;
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
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getUrgent() {
		return urgent;
	}
	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}
	
	

}
