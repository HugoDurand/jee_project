package com.esgi.jee_project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.esgi.jee_project.model.Taches;

/**
 * Implémentation de l'interface TachesDao
 */
public class TachesDAOImpl implements TachesDAO {

	private JdbcTemplate jdbcTemplate;
	
	public TachesDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
/**
 * Methode permettant d'ajouter ou de modifier une tache
 */

	@Override
	public void saveOrUpdate(Taches taches) {
		if (taches.getId() > 0) {
			/**
			 * update
			 */
			String sql = "UPDATE taches SET libelle=?, id_user=?, date=?, urgent=?"
						+ " WHERE id=?";
			jdbcTemplate.update(sql, taches.getLibelle(), taches.getId_user(),
					taches.getDate(), taches.getUrgent(), taches.getId());
		} else {
			/**
			 * insert
			 */
			String sql = "INSERT INTO taches (libelle, id_user, date, urgent)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, taches.getLibelle(), taches.getId_user(),
					taches.getDate(), taches.getUrgent());
		}
		
	}
	
/**
 * Methode permettant de supprimer une tache
 */

	@Override
	public void delete(int tachesId) {
		String sql = "DELETE FROM taches WHERE id=?";
		jdbcTemplate.update(sql, tachesId);
	}

	
/**
 * Methode permettant de lister les taches, elles sont classées par date et par urgence.
 */
	@Override
	public List<Taches> list() {
		String sql = "SELECT * FROM taches ORDER BY urgent DESC, date DESC";
		List<Taches> listTaches = jdbcTemplate.query(sql, new RowMapper<Taches>() {

			@Override
			public Taches mapRow(ResultSet rs, int rowNum) throws SQLException {
				Taches aTaches = new Taches();
	
				aTaches.setId(rs.getInt("id"));
				aTaches.setLibelle(rs.getString("libelle"));
				aTaches.setId_user(rs.getInt("id_user"));
				aTaches.setDate(rs.getDate("date"));
				aTaches.setUrgent(rs.getBoolean("urgent"));
				
				return aTaches;
			}
			
		});
		
		return listTaches;
	}

	
/**
 * Methode permettant de récuperer une tache par id
 */
	@Override
	public Taches get(int tachesId) {
		String sql = "SELECT * FROM taches WHERE id=" + tachesId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Taches>() {

			@Override
			public Taches extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Taches taches = new Taches();
					taches.setId(rs.getInt("id"));
					taches.setLibelle(rs.getString("libelle"));
					taches.setId_user(rs.getInt("id_user"));
					taches.setDate(rs.getDate("date"));
					taches.setUrgent(rs.getBoolean("urgent"));;
					return taches;
				}
				
				return null;
			}
			
		});
	}

}
