package master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import master.dto.Fd_DTO;
import master.utilities.Connection_Factory;

public class Fd_DAO 
{
	Connection cn=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	Statement st=null;
	String insert_query="insert into fd values(?,?,?,?,?,?,?)";
	String select_query="select * from fd";
	public void insertFD(Fd_DTO fdto)
	{
		Connection_Factory conn=new Connection_Factory();
		cn=conn.getConn();
		try
		{
			ps=cn.prepareStatement(insert_query);
			ps.setString(1, fdto.getCid());
			ps.setString(2, fdto.getFd_acc_no());
			ps.setInt(3, fdto.getDuration());
			ps.setDouble(4, fdto.getFd_pay());
			ps.setDouble(5, fdto.getFd_recieve());
			ps.setString(6, fdto.getStart());
			ps.setString(7, fdto.getEnd());
			
			ps.executeUpdate();
			cn.commit();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public ArrayList<Fd_DTO>getData()
	{
		ArrayList <Fd_DTO> al=new ArrayList<Fd_DTO>();
		try
		{
		Connection_Factory con=new Connection_Factory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(select_query);
		while(rs.next())
		{
			Fd_DTO fdto=new Fd_DTO();
			fdto.setCid(rs.getString(1));
			fdto.setFd_acc_no(rs.getString(2));
			fdto.setDuration(rs.getInt(3));
			fdto.setFd_pay(rs.getInt(4));
			fdto.setFd_recieve(rs.getInt(5));
			fdto.setStart(rs.getString(6));
			fdto.setEnd(rs.getString(7));
			al.add(fdto);
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return al;
}
}
