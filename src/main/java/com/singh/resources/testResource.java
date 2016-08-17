
package com.singh.resources;

import com.singh.utils.MyBatis;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class testResource {
	
	@Path("/db")
	@GET
	public String testConnection(){
		// Just for logging
				org.apache.ibatis.logging.LogFactory.useStdOutLogging();
		String s = "Emplty";
		try {
			System.out.print("Trying...");
			s = MyBatis.getSqlSessionFactory().openSession().getConnection().getMetaData().getDriverName();
			System.out.print("s : " + s);
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return s;
	}
	
	@Path("/hello")
	@GET
	public String test(){
		return "What's up!";
	}
	
	@Path("/db1")
	@GET
	public String testdb(){
		String s = "EMPTY";
		Context initCtx;
		try {
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			// Look up our data source
			DataSource ds = (DataSource) envCtx.lookup("jdbc/test");
			s= ds.getConnection().getMetaData().getDriverName();
		}
		catch (Exception ex) {
				ex.printStackTrace();
		}

		return s;


	}
	
	
}
