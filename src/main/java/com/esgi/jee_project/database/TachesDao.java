package com.esgi.jee_project.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import com.esgi.jee_project.domaine.Taches;

public class TachesDao {
	
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
	
	

}
