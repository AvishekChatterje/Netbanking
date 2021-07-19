package master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import master.dto.Register_DTO;
import master.utilities.Connection_Factory;

public class Register_DAO 
{
	Connection cn=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String select_query="select * from customer";
	String insert_query="insert into customer values(?,?,?,?,?,?,?,?,?,?,?,?)";
	String delete_query="delete from customer where cid=?";
	public ArrayList<Register_DTO>getData()
	{
		ArrayList <Register_DTO> al=new ArrayList<Register_DTO>();
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(select_query);
		while(rs.next())
		{
			Register_DTO rdto=new Register_DTO();
			rdto.setCid(rs.getString(1));
			rdto.setPass(rs.getString(2));
			rdto.setName(rs.getString(3));
			rdto.setPhno(rs.getString(4));
			rdto.setEmail_no(rs.getString(5));
			rdto.setAdhar_no(rs.getString(6));
			rdto.setPan_card(rs.getString(7));
			rdto.setDob(rs.getString(8));
			rdto.setGender(rs.getString(9));
			rdto.setAddress(rs.getString(10));
			rdto.setStreet(rs.getString(11));
			rdto.setPin(rs.getString(12));
			al.add(rdto);
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return al;
	}
	public void insertData(Register_DTO rdto)
	{
	try
	{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		ps=cn.prepareStatement(insert_query);
		ps.setString(1, rdto.getCid());
		ps.setString(2, rdto.getPass());
		ps.setString(3, rdto.getName());
		ps.setString(4,rdto.getPhno());
		ps.setString(5, rdto.getEmail_no());
		ps.setString(6, rdto.getAdhar_no());
		ps.setString(7, rdto.getPan_card());
		ps.setString(8,rdto.getDob());
		ps.setString(9, rdto.getGender());
		ps.setString(10,rdto.getAddress());
		ps.setString(11,rdto.getStreet());
		ps.setString(12, rdto.getPin());
		
		ps.executeUpdate();
		cn.commit();
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	}
	public String getPassword(String cid)
	{
		String password="";
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=con.getStatement();
		String getPass="select pass from customer where cid='"+cid+"'";
		rs=con.getResult(getPass);
		while(rs.next())
		{
		password=rs.getString("pass");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return password;
	}
	public String getEmail(String cid)
	{
		String gotEmail="";
		String getEmail="select email_id from customer where cid='"+cid+"' ";
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(getEmail);
		while(rs.next())
		{
		gotEmail=rs.getString("email_id");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return gotEmail;
	}
	public String getName(String cid)
	{
		String name="";
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=con.getStatement();
		String getName="select name from customer where cid='"+cid+"'";
		rs=con.getResult(getName);
		while(rs.next())
		{
		name=rs.getString("name");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return name;
}
	public void deleteData(String cid)
	{
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(delete_query);
			ps.setString(1, cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateName(String cid,String name)
	{
		String update="update customer set name=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, name);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updatePhno(String cid,String phno)
	{
		String update="update customer set phno=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, phno);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateEmail(String cid,String email)
	{
		String update="update customer set email_id=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, email);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateAdhar(String cid,String adhar)
	{
		String update="update customer set adhar_no=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, adhar);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updatePan(String cid,String pan)
	{
		String update="update customer set pan_card=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, pan);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateDob(String cid,String dob)
	{
		String update="update customer set dob=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, dob);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateGender(String cid,String gender)
	{
		String update="update customer set gender=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, gender);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateAddress(String cid,String address)
	{
		String update="update customer set address=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, address);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateStreet(String cid,String street)
	{
		String update="update customer set street=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, street);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updatePin(String cid,String pin)
	{
		String update="update customer set pin=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, pin);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updatePass(String cid,String pass)
	{
		String update="update customer set pass=? where cid=?";
		try
		{
			Connection_Factory con=new Connection_Factory();
			cn=con.getConn();
			ps=cn.prepareStatement(update);
			ps.setString(1, pass);
			ps.setString(2,cid);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
}