package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import master.dao.Register_DAO;

/**
 * Servlet implementation class Password_check
 */
public class Password_check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String cid=request.getParameter("cid");
		String pass=request.getParameter("pass");
		Register_DAO rdao=new Register_DAO();
		String check_pass=rdao.getPassword(cid);
		if(pass.equals(check_pass) && pass!="") 
		{
			if(pass.equals("admin"))
			{
				//request.setAttribute("cid", cid);
				session.setAttribute("cid",cid);
				request.getRequestDispatcher("TWelcome_admin.jsp").forward(request, response);
			}
			else
			{
				//request.setAttribute("cid", cid);
				session.setAttribute("cid",cid);
				request.getRequestDispatcher("TWelcome_user.jsp").forward(request, response);
			}
		}
		else
		{
			
			response.sendRedirect("Wrong_pass.jsp");
		}
		}

}
