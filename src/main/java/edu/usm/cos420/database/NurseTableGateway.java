package edu.usm.cos420.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.usm.cos420.model.Nurse;

public class NurseTableGateway {
	
	/**
	 * Pulls all the nurses from the DB and returns an ArrayList of them
	 * 
	 * @return ArrayList<Nurse>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Nurse> getAllNurses(String dbUrl) throws ClassNotFoundException, SQLException {
		ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
		try(Connection conn = DriverManager.getConnection(dbUrl)){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT userID, firstName, lastName, countryCode FROM nurses");
			
			while (rs.next()) {
				Nurse n = new Nurse();
				n.setId(rs.getInt(1));
				n.setFirstName(rs.getString(2));
				n.setLastName(rs.getString(3));
				n.setCountryCode(rs.getString(4));
				nurseList.add(n);
			}
			
			if (conn != null)
				conn.close();
		}

		return nurseList;
	}
	
	
	
}
