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
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetServ extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection con;

    public void init() throws ServletException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = "jdbc:mysql://localhost:3306/bit";
        String username = "root";
        String password = "pass@1234";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database connection error", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM register");
             ResultSet rs = pst.executeQuery()) {

            StringBuilder html = new StringBuilder();
            html.append("<!DOCTYPE html>");
            html.append("<html>");
            html.append("<head>");
            html.append("<meta charset=\"UTF-8\">");
            html.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            html.append("<title>User Information</title>");
            html.append("<style>");
            html.append("table { width: 50%; border-collapse: collapse; margin: 20px 0; }");
            html.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            html.append("th { background-color: #f2f2f2; }");
            html.append("</style>");
            html.append("</head>");
            html.append("<body>");

            html.append("<h2>User Information</h2>");

            // Generate HTML table dynamically based on data
            html.append("<table>");
            html.append("<tr><th>Name</th><th>Address</th><th>EmailLogin</th><th>Password</th></tr>");

            while (rs.next()) {
                html.append("<tr>");
                html.append("<td>").append(rs.getString("name")).append("</td>");
                html.append("<td>").append(rs.getString("address")).append("</td>");
                html.append("<td>").append(rs.getString("emaillogin")).append("</td>");
                html.append("<td>").append(rs.getString("password")).append("</td>");
                html.append("</tr>");
            }

            html.append("</table>");

            html.append("</body>");
            html.append("</html>");

            out.println(html.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database query error", e);
        }
    }

    public void destroy() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
