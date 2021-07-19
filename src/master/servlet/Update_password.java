package master.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import master.dao.Register_DAO;

/**
 * Servlet implementation class Update_password
 */
public class Update_password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		String cid=session.getAttribute("cid").toString();
		String old_pass=request.getParameter("old_pass");
		String new_pass=request.getParameter("new_pass");
		Register_DAO rdao=new Register_DAO();
		 String p=rdao.getPassword(cid);
		 if(p.equals(old_pass))
		 {
			 rdao.updatePass(cid,new_pass);
			 pw.println("Password is Updated");
			 RequestDispatcher rd=request.getRequestDispatcher("Update_pass.jsp");
			 rd.include(request, response);
		 }
		 else
		 {
			 pw.println("Old password is incorrect! ");
			 pw.println("<br>");
			 pw.println("Please enter the credentials again. ");
			 RequestDispatcher rd=request.getRequestDispatcher("Update_pass.jsp");
			 rd.include(request, response);
		 }
	}

}
