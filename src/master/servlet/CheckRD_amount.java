package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import master.dao.Account_DAO;

/**
 * Servlet implementation class CheckRD_amount
 */
public class CheckRD_amount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String cid=(session.getAttribute("cid")).toString();
		int amount=Integer.parseInt(request.getParameter("amt"));
		int time=Integer.parseInt(request.getParameter("time"));
		String acc_no=new Account_DAO().getAccount(cid);
		int bal=new Account_DAO().getBalance(acc_no);
		bal-=500;
		if(bal>=amount)
		{
			request.getSession().setAttribute("cid", cid);
			request.getSession().setAttribute("acc_no", acc_no);
			request.getSession().setAttribute("amount", amount);
			request.getRequestDispatcher("Check_fd_amount_right.jsp").forward(request, response);
		}
		else
		{
			response.sendRedirect("Check_fd_amount_wrong.jsp");
		}
	}

}