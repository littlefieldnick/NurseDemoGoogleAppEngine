package edu.usm.cos420.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.usm.cos420.model.Nurse;

public class NurseTableGateway {
	String dbUrl;
	
	public NurseTableGateway(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public void addToNursesTable(Nurse n) throws ClassNotFoundException, SQLException {

		try(Connection conn = DriverManager.getConnection(this.dbUrl)){
			/**
			 * ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
			 * is needed for inserting to a cloud database
			 */
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet uprs = stmt.executeQuery("SELECT * FROM nurses");

			uprs.moveToInsertRow();

			uprs.updateInt("userId", n.getId());
			uprs.updateString("firstName",n.getFirstName());
			uprs.updateString("lastName", n.getLastName());
			uprs.updateString("countryCode", n.getCountryCode());

			uprs.insertRow();
			
			if (conn != null)
				conn.close();
		}



		/*
		 * An alternative way of updating the table ... have to know
		 * the column number and will need to change with changes in table
		 * 
		 * st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		 * ResultSet.CONCUR_UPDATABLE);
		 * 
		 * PreparedStatement ps =
		 * con.prepareStatement("insert into nurses values(?,?,?,?)");
		 * 
		 * ps.setInt(1, n.getId()); 
		 * ps.setString(2, n.getFirstName());
		 * ps.setString(3, n.getLastName()); 
		 * ps.setString(4, n.getCountryCode());
		 * 
		 * int i = ps.executeUpdate();
		 */



		

	}

	/**
	 * Pulls all the nurses from the DB and returns an ArrayList of them
	 * 
	 * @return ArrayList<Nurse>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Nurse> getAllNurses() throws ClassNotFoundException, SQLException {
		ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
		try(Connection conn = DriverManager.getConnection(this.dbUrl)){
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
