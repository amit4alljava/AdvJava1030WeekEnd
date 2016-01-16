package com.icici.los.helper;

import java.sql.SQLException;

import com.icici.los.dao.LoginDAO;
import com.icici.los.dto.UserDTO;

import static com.icici.los.utility.ValidationUtility.isBlank;

public class LoginHelper {
	
	public String validateUser(UserDTO userDTO){
		String message = "";
		if(isBlank(userDTO.getUserid())){
			message =  "Userid is Blank";
		}
		else
		if(isBlank(userDTO.getPassword())){
			message =  "Password is Blank";
		}
		else{
		LoginDAO loginDAO = new LoginDAO();
		try {
			boolean isLoginSuccess = loginDAO.checkLogin(userDTO);
			if(isLoginSuccess){
				message = "Login SuccessFully...";
			}
			else{
				message = "Invalid UserId or Password";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Login Failed...";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Login Failed...";
		}
		}
		return message;
	}

}
