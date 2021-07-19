package master.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection_Factory 
{
	Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	public Connection getConn()
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "netbanking", "netbanking");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return cn;
	}
	public Statement getStatement()
	{
		try
		{
			cn=this.getConn();
			st=cn.createStatement();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return st;
	}
	public ResultSet getResult(String query)
	{
		try
		{
		cn=this.getConn();
		st=this.getStatement();
		rs=st.executeQuery(query);
		//System.out.println("PASSWORD IS : "+rs.getString("pass"));
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return rs;
	}
}
