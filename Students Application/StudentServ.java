

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class StudentServ
 */
public class StudentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Integer> mylist1=new ArrayList<Integer>();
	private Connection con;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("Name");
		int age=Integer.parseInt(request.getParameter("Age"));
		String adr=request.getParameter("Address");
		try {
			PreparedStatement pst=con.prepareStatement("insert into student(name,age,address) values(?,?,?)");
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, adr);
			int k=pst.executeUpdate();
			
			pw.println(k+"row affected!!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void init() throws ServletException {
		String ss="jdbc:mysql://localhost:3306/bit";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(ss,"root","pass@1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		try {
			PreparedStatement pst1=con.prepareStatement("select rollno from student");
			ResultSet rs=pst1.executeQuery();
			
			while(rs.next()) {
				
				int k=rs.getInt("rollno");
				System.out.println(k);
				mylist1.add(k);
			}
			
			request.setAttribute("rolllist",mylist1);
			RequestDispatcher rd=request.getRequestDispatcher("Report.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
