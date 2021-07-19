package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.Transaction_DAO;

/**
 * Servlet implementation class Delete_savings
 */
public class Delete_savings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String acc_no=request.getParameter("acc_no");
		new Transaction_DAO().deleteSaving(acc_no);
		response.sendRedirect("TWelcome_admin.jsp");
	}

}
