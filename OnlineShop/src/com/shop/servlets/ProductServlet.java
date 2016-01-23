package com.shop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.shop.dto.ProductDTO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ProductServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ArrayList<ProductDTO> productList = productDAO.fetchProducts();
			PrintWriter out = response.getWriter();
			out.println("<html><body><table>");
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
			out.println("</table></body></html>");
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
	}

}
