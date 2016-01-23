package com.shop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.shop.dto.LoginDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	Logger logger = Logger.getLogger(LoginServlet.class);
	
	private String doDesign(String msg){
		String design ="<!DOCTYPE html> <html>"
                      +"<head><meta charset='ISO-8859-1'>"
                      +"<title>Login Page</title>"
                      +"</head><body>";
         if(msg!=null && msg.length()>0){
        	 design = design + "<h1>"+msg +"</h1>";
         }
		design +="<form action='login' method='post'>"
                      +"<table>"
                      +"<tr>"
                      +"<td><label>UserName</label></td>"
                      +"<td><input type='text' name='userName'/></td>"
                      +"</tr>"	
                      +"<tr>"	
                      +"<td><label>Password</label></td>"
                      +"<td><input type='password' name='pwd'/></td>"
                      +"</tr><tr>"
                      +"<td colspan='2'>"
                      +"<input type='submit' value='Login'/>"
                      +"</td></tr></table></form></body></html>";

			return design;



	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(this.doDesign(null));
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Inside the DoPost Method");
		String userid = request.getParameter("userName");
		String password = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserid(userid);
		loginDTO.setPassword(password);
		LoginDAO loginDAO = new LoginDAO();
		try {
			boolean isExist = loginDAO.isUserExist(loginDTO);
			if(isExist){
				response.sendRedirect("product");
				//out.println("Welcome "+userid);
			}
			else{
				out.println(this.doDesign("Invalid Userid or Password"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//out.println(e);
			
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			//out.println(sw.toString());
			logger.error(sw.toString());
			response.sendRedirect("error.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString());
			response.sendRedirect("error.html");
			//out.println(sw.toString());
		}
		out.close();
		logger.debug("DoPost End");
	}

}
