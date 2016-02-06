package com.shop.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.shop.dto.LoginDTO;

public class LoginDAO {
	Logger logger = Logger.getLogger(LoginDAO.class);
	
	public boolean isUserExist(LoginDTO loginDTO) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isFound = false;
		try{
			con = CommonDAO.getConnection();
			pstmt  = con.prepareStatement("select userid,password from "
					+ "user_mst where userid=? and password=?");
			pstmt.setString(1,loginDTO.getUserid());
			pstmt.setString(2,loginDTO.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				isFound = true;
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return isFound;
	}
	
}
