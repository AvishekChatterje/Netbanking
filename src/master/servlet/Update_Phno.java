package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.Register_DAO;

/**
 * Servlet implementation class Update_Phno
 */
public class Update_Phno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
        // TODO Auto-generated constructor stub

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String cid=request.getParameter("cid");
		String phno=request.getParameter("phno");
		Register_DAO rdao=new Register_DAO();
		rdao.updatePhno(cid,phno);
		response.sendRedirect("Update.jsp");
	}

}
