package master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import master.dto.Account_DTO;
import master.utilities.Connection_Factory;

public class Account_DAO 
{
	Connection cn=null;
	ResultSet rs=null;
	Statement st=null;
	PreparedStatement ps=null;
	String select_query="select * from account";
	String insert_query="insert into account values(?,?,?,?)";
	String delete_query="delete from account where acc_no=?";
	String update_bal="update account set balance=? where acc_no=?";
	public void insertData(Account_DTO adto)
	{
		try
		{
			Connection_Factory conn=new Connection_Factory();
			cn=conn.getConn();
			
		ps=cn.prepareStatement(insert_query);
		ps.setString(1, adto.getCid());
		ps.setString(2, adto.getAcc_no());
		ps.setInt(3,adto.getBalance());
		ps.setString(4,adto.getDop());
		ps.executeUpdate();
		cn.commit();
		}
	catch(SQLException se)		{
			se.printStackTrace();
		}
	}
	public ArrayList<Account_DTO>getData()
	{
		ArrayList <Account_DTO> al=new ArrayList<Account_DTO>();
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(select_query);
		while(rs.next())
		{
			Account_DTO adto=new Account_DTO();
			adto.setCid(rs.getString(1));
			adto.setAcc_no(rs.getString(2));
			adto.setBalance(rs.getInt(3));
			adto.setDop(rs.getString(4));
			al.add(adto);
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return al;
	}
	public void deleteData(String acc_no)
	{
		Connection_Factory conn=new Connection_Factory();
		cn=conn.getConn();
		try
		{
		ps=cn.prepareStatement(delete_query);
		ps.setString(1, acc_no);
		ps.executeUpdate();
		cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void updateBalance(String acc_no,int amount)
	{
		Connection_Factory conn=new Connection_Factory();
		cn=conn.getConn();
		int n=getBalance(acc_no);
		n+=amount;
		try
		{
			ps=cn.prepareStatement(update_bal);
			ps.setString(2, acc_no);
			ps.setInt(1, n);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public int getBalance(String acc_no)
	{
		String getBal="select balance from account where acc_no='"+acc_no+"'";
		int bal=0;
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(getBal);
		while(rs.next())
		{
		bal=rs.getInt("balance");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return bal;
	}
	public void deductBalance(String acc_no,int amount)
	{
		Connection_Factory conn=new Connection_Factory();
		cn=conn.getConn();
		int n=getBalance(acc_no);
		n-=amount;
		try
		{
			ps=cn.prepareStatement(update_bal);
			ps.setString(2, acc_no);
			ps.setInt(1, n);
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public String getAccount(String cid)
	{
		String getAcc="select acc_no from account where cid='"+cid+"'";
		String acc_no="";
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(getAcc);
		while(rs.next())
		{
		acc_no=rs.getString("acc_no");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return acc_no;
}
	public String checkAcc(String cid)
	{
		String check="select cid from account where cid='"+cid+"'";
		String c="";
		try
		{
			Connection_Factory conn=new Connection_Factory();
			cn=conn.getConn();
			rs=conn.getResult(check);
			while(rs.next())
			{
				c=rs.getString("cid");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return c;
	}
}