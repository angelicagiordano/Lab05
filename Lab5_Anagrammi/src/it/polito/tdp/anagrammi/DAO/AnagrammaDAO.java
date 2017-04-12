package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {

	public boolean isCorrect(String parolaDaCercare){
		
			final String sql = "SELECT * FROM parola WHERE nome=?";

			

			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);

				st.setString(1, parolaDaCercare); //al punto interrogativo sostituisco il codice
				ResultSet rs = st.executeQuery();


				if(rs.next()){
					return true;
				}else{
					return false;}
				//conn.close();
				

			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db");
			}

	}
	
}
