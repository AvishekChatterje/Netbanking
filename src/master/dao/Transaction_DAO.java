package master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import master.dto.Transaction_DTO;
import master.utilities.Connection_Factory;

public class Transaction_DAO 
{
	Connection cn;
	ResultSet rs;
	PreparedStatement ps;
	String insert_sql="insert into Transaction values(?,?,?,?,?,?)";
	public void insertData(Transaction_DTO tdto)
	{
		Connection_Factory conn=new Connection_Factory();
		cn=conn.getConn();
		try
		{
			ps=cn.prepareStatement(insert_sql);
			ps.setString(1, tdto.getCid());
			ps.setString(2, tdto.getAcc_no());
			ps.setString(3, tdto.getDotrans());
			ps.setInt(4, tdto.getCredit());
			ps.setInt(5, tdto.getDebit());
			ps.setInt(6, tdto.getBalance());
			
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public ArrayList<Transaction_DTO> getData(String acc_no)
	{
		String select_sql="select dotrans,credit,debit,balance from Transaction where acc_no ='"+acc_no+"'";
		ArrayList<Transaction_DTO> al=new ArrayList<Transaction_DTO>();
		try
		{
			Connection_Factory conn=new Connection_Factory();
			cn=conn.getConn();
			rs=conn.getResult(select_sql);
			while(rs.next())
			{
				Transaction_DTO tdto=new Transaction_DTO();
				tdto.setDotrans(rs.getString(1));
				tdto.setCredit(rs.getInt(2));
				tdto.setDebit(rs.getInt(3));
				tdto.setBalance(rs.getInt(4));
				al.add(tdto);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return al;
	}
	public String getName(String cid)
	{
		String name="";
		try
		{
		Connection_Factory con=new Connection_Factory();
		String getName_sql="select name from customer where cid='"+cid+"'";
		cn=con.getConn();
		rs=con.getResult(getName_sql);
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
	public String getCid(String acc_no)
	{
		String cid="";
		try
		{
		Connection_Factory con=new Connection_Factory();
		String getCid_sql="select cid from Transaction where acc_no='"+acc_no+"'";
		cn=con.getConn();
		rs=con.getResult(getCid_sql);
		while(rs.next())
		{
		cid=rs.getString("cid");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return cid;
	}
	public String getAcc(String cid)
	{
		String acc_no="";
		try
		{
		Connection_Factory con=new Connection_Factory();
		String getAcc_sql="select acc_no from account where cid='"+cid+"'";
		cn=con.getConn();
		rs=con.getResult(getAcc_sql);
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
	public int getBalance(String acc_no)
	{
		int bal=0;
		try
		{
		Connection_Factory con=new Connection_Factory();
		String getBal_sql="select balance from account where acc_no='"+acc_no+"'";
		cn=con.getConn();
		rs=con.getResult(getBal_sql);
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
	public void deleteSaving(String acc_no)
	{
		String delete_query="delete from account where acc_no=?";
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
}