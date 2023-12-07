

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class SecondServ
 */
public class SecondServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	List<String> mystr=new ArrayList<String>();
	
       
    		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] name=request.getParameterValues("ch");
		
		for(int i=0;i<name.length;i++) {
			
			mystr.add(name[i]);
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("Proc", mystr);
			
	}

}
