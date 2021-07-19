package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.Register_DAO;

/**
 * Servlet implementation class Update_Pan
 */
public class Update_Pan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String cid=request.getParameter("cid");
		String pan=request.getParameter("pan");
		Register_DAO rdao=new Register_DAO();
		rdao.updatePan(cid,pan);
		response.sendRedirect("Update.jsp");
	}

}
