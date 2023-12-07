

import jakarta.servlet.ServletConfig;
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
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private Connection con;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String ss="jdbc:mysql://localhost:3306/bit";
			 con=DriverManager.getConnection(ss,"root","pass@1234");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
			PrintWriter pw=resp.getWriter();
			//con=ds.getConnection();
			pw.println(con);
			String name=req.getParameter("name");
			String address=req.getParameter("address");
			String emaillogin=req.getParameter("emaillogin");
			//String login=req.getParameter("login");
			String password=req.getParameter("password");
			//String name=req.getParameter("name");
            try {
			PreparedStatement pst=con.prepareStatement("insert into register values(?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2, address);
			pst.setString(3, emaillogin);
			pst.setString(4, password);
           int k=pst.executeUpdate();
			pw.println("hello");
			if(k>0) {
				pw.println(k+" row affected");
				resp.sendRedirect("Success.html"); 
			}
			else {
				pw.println("not affected");
			}

            }
            catch(Exception e) {}
            
            
			
						
			

	}
		

}
