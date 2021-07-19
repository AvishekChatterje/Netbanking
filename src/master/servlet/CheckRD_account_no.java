package master.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.Account_DAO;

/**
 * Servlet implementation class CheckRD_account_no
 */
public class CheckRD_account_no extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String cid=request.getParameter("cid");
		PrintWriter pw=response.getWriter();
		pw.print(cid);
		if(cid.equals(new Account_DAO().checkAcc(cid)))
		{
			request.getSession().setAttribute("cid",cid);
			request.getRequestDispatcher("Create_rd_amt.jsp").forward(request, response);
		}
		else
		{
			pw.println("Customer ID not found");
			pw.println("<br>");
			pw.println("Please enter the Credentials again.");
			RequestDispatcher rd=request.getRequestDispatcher("Create_rd.jsp");
			rd.include(request, response);
		}
	}

}
