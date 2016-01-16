package com.icici.los.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
//Singleton class
public class CommonDAO {
	// Step - 2 Class Variable (Static + Private )
	private static CommonDAO commonDAO = null;
	//Step -1 Private Constructor
	private CommonDAO(){}
	
	// Step - 3 static method 
	public static CommonDAO getObject(){ 
		if(commonDAO==null){
			commonDAO = new CommonDAO();
		}
		return commonDAO;
	}
	private ResourceBundle readPropertyFile(){
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = this.readPropertyFile();
		String driverClassName = rb.getString("drivername");
		Class.forName(driverClassName);
		Connection con = DriverManager.
				getConnection(rb.getString("dburl"),
						rb.getString("userid"),rb.getString("password"));
		return con;
	}

}
