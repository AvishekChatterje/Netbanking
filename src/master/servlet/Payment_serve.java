package master.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import master.dao.Account_DAO;
import master.dao.Transaction_DAO;
import master.dto.Transaction_DTO;

/**
 * Servlet implementation class Payment_serve
 */
public class Payment_serve extends HttpServlet {
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
		String acc_no_from=new Account_DAO().getAccount(cid);
		String acc_no_to=request.getParameter("acc_no_to");
		int amt=Integer.parseInt(request.getParameter("amt"));
		int bal_from=new Account_DAO().getBalance(acc_no_from);
		int bal_to=new Account_DAO().getBalance(acc_no_to);
		LocalDate d=LocalDate.now();
		int after_trans=bal_from-amt;
		if(after_trans<500)
		{
			pw.println("Your balance is not enough to make the transaction");
			pw.println("<br>");
			RequestDispatcher rd=request.getRequestDispatcher("TPayment.jsp");
			rd.include(request, response);
		}
		else
		{
			new Account_DAO().updateBalance(acc_no_to, amt);
			Transaction_DAO tdao=new Transaction_DAO();
			Transaction_DTO tdto=new Transaction_DTO();
			tdto.setCid(tdao.getCid(acc_no_to));
			tdto.setAcc_no(acc_no_to);
			tdto.setDotrans(d.toString());
			tdto.setCredit(amt);
			tdto.setDebit(0);
			tdto.setBalance(bal_to+amt);
			tdao.insertData(tdto);
			
			new Account_DAO().deductBalance(acc_no_from, amt);
			Transaction_DTO tdto2=new Transaction_DTO();
			tdto2.setCid(cid);
			tdto2.setAcc_no(acc_no_from);
			tdto2.setDotrans(d.toString());
			tdto2.setCredit(0);
			tdto2.setDebit(amt);
			tdto2.setBalance(bal_from-amt);
			Transaction_DAO tdao2=new Transaction_DAO();
			tdao2.insertData(tdto2);
			response.sendRedirect("Savings_success_mssg.jsp");
		}
	}

}
