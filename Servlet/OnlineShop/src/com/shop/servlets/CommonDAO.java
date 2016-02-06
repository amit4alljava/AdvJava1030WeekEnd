package com.shop.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class CommonDAO {
	private CommonDAO(){}
	private static Logger logger = Logger.getLogger(CommonDAO.class);
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		logger.debug("Connection Start");
		String driverClassName = "com.mysql.jdbc.Driver";
		Class.forName(driverClassName);
		Connection con = 
				DriverManager.
				getConnection("jdbc:mysql://localhost:3306/jdbc10to12"
						,"root","root");
		logger.debug("Connection Ends");
		return con;
	}
}
