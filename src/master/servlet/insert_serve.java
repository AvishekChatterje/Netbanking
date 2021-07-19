package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import master.dao.Register_DAO;
import master.dto.Register_DTO;
import master.dto.User;

/**
 * Servlet implementation class customer_password
 */
public class insert_serve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String name=user.getName();
		String phno=user.getPhno();
		String email=user.getEmail_no();
		String adhar=user.getAdhar_no();
		String pan=user.getPan_card();
		String dob=user.getDob();
		String gender=user.getGender();
		String address=user.getAddress();
		String street=user.getStreet();
		String pin=user.getPin();				
		String pass=session.getAttribute("pass").toString();
		String cid=request.getParameter("cid");
		Register_DTO rdto=new Register_DTO();
		rdto.setCid(cid);
		rdto.setPass(pass);
		rdto.setName(name);
		rdto.setPhno(phno);
		rdto.setEmail_no(email);
		rdto.setAdhar_no(adhar);
		rdto.setPan_card(pan);
		rdto.setDob(dob);
		rdto.setGender(gender);
		rdto.setAddress(address);
		rdto.setStreet(street);
		rdto.setPin(pin);
		Register_DAO rdao=new Register_DAO();
		rdao.insertData(rdto);
		response.sendRedirect("TWelcome_admin.jsp");
	}

}
