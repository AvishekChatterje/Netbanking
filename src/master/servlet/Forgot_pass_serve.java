package master.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.Register_DAO;
import master.utilities.Sending_mails;

/**
 * Servlet implementation class Forgot_pass_serve
 */
public class Forgot_pass_serve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String cid=request.getParameter("cid");
		Register_DAO rdao=new Register_DAO();
		String pass=rdao.getPassword(cid);
		String email=rdao.getEmail(cid);
		//String email="deyarpita119@gmail.com";
		new Sending_mails().sendEmail(email, pass);
		PrintWriter pw=response.getWriter();
		//pw.println(cid);
		//pw.println(email);
		pw.println(pass);
		}

}