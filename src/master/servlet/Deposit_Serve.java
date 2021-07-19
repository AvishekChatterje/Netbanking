package master.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.Account_DAO;
import master.dao.Transaction_DAO;
import master.dto.Transaction_DTO;

/**
 * Servlet implementation class Deposit_Serve
 */
public class Deposit_Serve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		LocalDate da=LocalDate.now();
		String acc_no=request.getParameter("acc_no");
		int amt=Integer.parseInt(request.getParameter("amt"));
		Account_DAO adao=new Account_DAO();
		adao.updateBalance(acc_no, amt);
		Transaction_DTO tdto=new Transaction_DTO();
		tdto.setCid(new Transaction_DAO().getCid(acc_no));
		tdto.setAcc_no(acc_no);
		tdto.setDotrans(da.toString());
		tdto.setCredit(amt);
		tdto.setDebit(0);
		tdto.setBalance(adao.getBalance(acc_no));
		new Transaction_DAO().insertData(tdto);
		
		response.sendRedirect("TWelcome_admin.jsp");
	}

}
