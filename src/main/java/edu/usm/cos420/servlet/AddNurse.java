package edu.usm.cos420.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usm.cos420.database.NurseTableGateway;
import edu.usm.cos420.model.Nurse;

/**
 * Servlet implementation class AddNurse
 */
@WebServlet("/AddNurse")
public class AddNurse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNurse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strId=request.getParameter("id");  
		int id=Integer.parseInt(strId.trim());
		String lastName=request.getParameter("lastName");  
		String firstName=request.getParameter("firstName");  
		String countryCode=request.getParameter("countryCode");  
		
		Nurse n = new Nurse();
	    n.setId(id);
	    n.setFirstName(firstName);
	    n.setLastName(lastName);
	    n.setCountryCode(countryCode);
	    try {
	    	String connect = this.getServletContext().getInitParameter("sql.urlRemote");
	    	NurseTableGateway gateway = new NurseTableGateway(connect);
			System.out.println("Connection to Database: " +  connect);
			gateway.addToNursesTable(n);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//After posting request, redirect to list page
		ServletContext sc = getServletContext();
		response.sendRedirect("/DisplayNursesDB");
	}

}
