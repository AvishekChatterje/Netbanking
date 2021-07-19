package master.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.Account_DAO;
import master.dao.Fd_DAO;
import master.dao.Transaction_DAO;
import master.dto.Fd_DTO;
import master.dto.Transaction_DTO;
import master.utilities.AccountNo_generator;
import master.utilities.Calculate_FD;

/**
 * Servlet implementation class insert_fd_serve
 */
public class insert_fd_serve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		int amount=Integer.parseInt(request.getSession().getAttribute("amount").toString());
		int time=Integer.parseInt(request.getParameter("time"));
		String cid=request.getSession().getAttribute("cid").toString();
		String fd_acc_no=new AccountNo_generator().generateAcc_no();
		double receive=new Calculate_FD().getFdAmount(amount, time);
		LocalDate d=LocalDate.now();
		String start=d.toString();
		LocalDate later=d.plusMonths(time*12);
		String end=later.toString();
		
		Fd_DTO fdto=new Fd_DTO();
		fdto.setCid(cid);
		fdto.setFd_acc_no(fd_acc_no);
		fdto.setDuration(time);
		fdto.setFd_pay(amount);
		fdto.setFd_recieve(receive);
		fdto.setStart(start);
		fdto.setEnd(end);
		 Fd_DAO fdao=new Fd_DAO();
		fdao.insertFD(fdto);// Fd table insert complete
		
		Account_DAO adao=new Account_DAO();
		adao.deductBalance(adao.getAccount(cid), amount);//Balance Deduction
		
		Transaction_DTO tdto=new Transaction_DTO();
		tdto.setCid(cid);
		tdto.setAcc_no(adao.getAccount(cid));
		tdto.setDotrans(d.toString());
		tdto.setCredit(0);
		tdto.setDebit(amount);
		tdto.setBalance(adao.getBalance(adao.getAccount(cid)));
		new Transaction_DAO().insertData(tdto); // Transaction Page Updation
		response.sendRedirect("TWelcome_admin.jsp");
	}
}
