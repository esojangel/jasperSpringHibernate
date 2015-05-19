package com.dem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.data.jdbc.JdbcDataAdapterImpl;

import com.dem.model.Sistemas;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourseBD{
	
	public static JdbcDataAdapterImpl getConexionJdbc(Sistemas sys) throws SQLException {
		JdbcDataAdapterImpl s = new JdbcDataAdapterImpl();
		s.setDriver("org.postgresql.Driver");
		s.setDatabase(sys.getDbname());
		s.setUrl("jdbc:postgresql://"+sys.getHost()+":5434/"+sys.getDbname());
		s.setUsername(sys.getUsername());
		s.setPassword(sys.getPassword());
		BasicDataSource bds = new BasicDataSource();

		
		return s;
		
	}
	public Connection getConexion(Sistemas sys) throws ClassNotFoundException, SQLException{
		System.out.println(sys.getHost());
		Connection con = null;
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://"+sys.getHost()+":5434/"+sys.getDbname();
		con =  DriverManager.getConnection(url, sys.getUsername(), sys.getPassword());
		return con;
	}
	
}
