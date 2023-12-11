

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.Student;
import mypack.StudentDAO;
import mypack.StudentDAODataImpl;
import mypack.StudentDAOFileImpl;

import java.io.IOException;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StudentDAO std;
		
		String name=request.getParameter("Name");
		String address=request.getParameter("Address");
		System.out.println(name+address);
		
		Student s1=new Student();
		s1.setName(name);
		s1.setAddress(address);
		
		String s=request.getParameter("dataOption");
		System.out.println(s);
		
		if("file".equals(s)) {
			
			std=new StudentDAOFileImpl();
			std.addStudent(s1);
			
		}
		else if("database".equals(s)) {
			
			std=new StudentDAODataImpl();
			std.addStudent(s1);
		}
		
				
	}

}
