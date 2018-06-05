package com.esgi.jee_project.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import com.esgi.jee_project.domaine.Taches;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.esgi.jee_project.domaine.Taches;

public class TachesDao{

	
	private DataSource dataSource;
	
	public DataSource getDatasource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void saveTaches(Taches taches) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			final String TACHES_INSERT = "INSERT into taches(id, libelle, id_user, date, urgent) VALUES (?,?,?,?,?)";
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(TACHES_INSERT);
			stmt.setInt(1, taches.getId());
			stmt.setString(1, taches.getLibelle());
			stmt.setInt(3, taches.getId_user());
			stmt.setDate(4, (Date) taches.getDate());
			stmt.setBoolean(5, taches.getUrgent());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null){stmt.close();};
				if(conn != null){conn.close();};
			} catch (Exception e2) {
				
			}
		}
		
	}
	

	public Taches findByTachesId(int id){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			final String TACHES_GET = "SELECT * FROM taches WHERE id = ?";
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(TACHES_GET);
			stmt.setInt(1, id);
			Taches taches = null;
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				taches = new Taches(
					rs.getInt("id"),
					rs.getString("libelle"),
					rs.getInt("id_user"),
					rs.getDate("date"),
					rs.getBoolean("Urgent")
				);
			}
			rs.close();
			stmt.close();
			return taches;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	

	

}
