package com.esgi.jee_project.dao;

import java.util.List;

import com.esgi.jee_project.model.Taches;

/**
 * Interface qui definie les methodes du model Taches
 */
public interface TachesDAO {
	
	public void saveOrUpdate(Taches taches);
	
	public void delete(int tachesId);
	
	public Taches get(int tachesId);
	
	public List<Taches> list();
}
