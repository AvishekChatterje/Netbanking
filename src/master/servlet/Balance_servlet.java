package master.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import master.dao.Account_DAO;
import master.dao.Transaction_DAO;
import master.dto.Account_DTO;
import master.dto.Transaction_DTO;

/**
 * Servlet implementation class Balance_servlet
 */
public class Balance_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession hsession=request.getSession();
		String cid=(hsession.getAttribute("cid")).toString();
		String acc_no=request.getParameter("acc_no");
		int bal=500;
		LocalDate d=LocalDate.now();
		
		Account_DTO adto=new Account_DTO();
		adto.setCid(cid);
		adto.setBalance(bal);
		adto.setAcc_no(acc_no);
		adto.setDop(d.toString());
		Account_DAO adao=new Account_DAO();
		adao.insertData(adto);
		Transaction_DTO tdto=new Transaction_DTO();
		tdto.setCid(cid);
		tdto.setAcc_no(acc_no);
		tdto.setDotrans(d.toString());
		tdto.setCredit(0);
		tdto.setDebit(0);
		tdto.setBalance(bal);
		Transaction_DAO tdao=new Transaction_DAO();
		tdao.insertData(tdto);
		response.sendRedirect("TWelcome_admin.jsp");
	}

}
