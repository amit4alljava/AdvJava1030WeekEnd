package com.shop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.shop.dto.ProductDTO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product.shop")
public class ProductServlet extends HttpServlet {
	String backGroundColor = "aqua";
	Logger logger = Logger.getLogger(ProductServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		/*if(session == null){
			response.sendRedirect("login.html");
		}
		else{*/
		ProductDAO productDAO = new ProductDAO();
		try {
			Cookie cookies[] = request.getCookies();
			if((cookies!=null && cookies.length>0)){
				for(Cookie c : cookies){
					if(c.getName().equals("color")){
						backGroundColor = c.getValue();
						break;
					}
				}
			}
			ArrayList<ProductDTO> productList = productDAO.fetchProducts();
			PrintWriter out = response.getWriter();
			String userid = (String)session.getAttribute("uid");
			//out.println("<html><body bgcolor='"+backGroundColor+"'>Welcome "+userid
			RequestDispatcher rd = 
					request.getRequestDispatcher("HeaderServlet.shop");
			rd.include(request, response);
			out.println("Welcome "+userid	
			+"<form action='logout.shop' method='post'>"
					+" <input type='submit' value='Logout'></form>"
					+"<table>");
			if(productList!=null && productList.size()>0){
				for(ProductDTO productDTO : productList){
					out.println("<tr>");
					out.println("<td>"
							+ "<img src='images/"+productDTO.getId()+".jpg'></td>");
					out.println("<td>Name "+productDTO.getName()
							+"  Desc "+productDTO.getDesc());
					
					out.println("</tr>");
				}
			}
			else{
				out.println("<tr><td colspan='2'>No Product Found</td></tr>");
			}
			out.println("</table>");//</body></html>");
			RequestDispatcher rd2 = 
					request.getRequestDispatcher("FooterServlet.shop");
			rd2.include(request, response);
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			out.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error(sw.toString());
			response.sendRedirect("error.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error(sw.toString());
			response.sendRedirect("error.html");
		}
		//}
	}

}
