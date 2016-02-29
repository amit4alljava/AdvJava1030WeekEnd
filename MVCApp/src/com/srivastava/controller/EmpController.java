package com.srivastava.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srivastava.dao.EmpDAO;
import com.srivastava.dto.EmployeeDTO;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/empcontroller")
public class EmpController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Take Value from View
		double salary = 
				Double.parseDouble
				(request.getParameter("salary"));
		EmpDAO empDAO = new EmpDAO();
		try {
			// 2. Call Model and get the Result
			ArrayList<EmployeeDTO> empList = 
					empDAO.searchBySalary(salary);
			// 3. Send the Result to the View
			request.setAttribute("emplist", empList);
			RequestDispatcher rd = request
					.getRequestDispatcher("EmpSearch.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}

}
