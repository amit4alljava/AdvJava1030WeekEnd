package com.icici.los.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icici.los.dto.UserDTO;


public class LoginDAO {
	public boolean checkLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = CommonDAO.getObject().getConnection();
			pstmt = con.prepareStatement("select userid,password from user_mst where userid=? and password=?");
			pstmt.setString(1,userDTO.getUserid());
			pstmt.setString(2,userDTO.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
			else{
				return false;
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
		
	}

}
