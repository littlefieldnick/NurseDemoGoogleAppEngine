package edu.usm.cos420.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.usm.cos420.database.NurseTableGateway;
import edu.usm.cos420.model.Nurse;

/**
 * Servlet implementation class DisplayNursesDB
 * 
 *    -- no error handling ! (other than to throw the exceptions)
 */
@WebServlet("/DisplayNursesDB")
public class DisplayNursesDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayNursesDB() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException
    {
        HttpSession sess = request.getSession();
        ServletContext sc = getServletContext();
     	ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
		try {
			String connect = this.getServletContext().getInitParameter("sql.urlRemote");
			System.out.println("Connection to Database: " +  connect);
			nurseList = NurseTableGateway.getAllNurses(connect); 
		} catch (SQLException e) {
		   System.err.println("Exception: " + e.getMessage());
	    } catch (Exception e) {
			   System.err.println("Exception: " + e.getMessage());
	    }		
	
        request.setAttribute("nurseList", nurseList);
        request.setAttribute("hello", "world");
        sc.setAttribute("nurseList", nurseList);
        sc.setAttribute("hello", "world");
        sess.setAttribute("nurseList", nurseList);
        sess.setAttribute("hello", "world");
        RequestDispatcher rd = sc.getRequestDispatcher("/Nurses.jsp");
        rd.forward(request, response);	
     }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			processRequest(request,response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			processRequest(request,response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
