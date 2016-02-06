package com.shop.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dto.ProductDTO;

public class ProductDAO {
	public ArrayList<ProductDTO> fetchProducts() throws SQLException, ClassNotFoundException{
		Connection con = null;
		ArrayList<ProductDTO> productList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDTO productDTO = null;
		String sql = "select id , name ,descr from product where status='Y'";
		try{
			con = CommonDAO.getConnection();
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				productDTO = new ProductDTO();
				productDTO.setId(rs.getInt("id"));
				productDTO.setName(rs.getString("name"));
				productDTO.setDesc(rs.getString("descr"));
				productList.add(productDTO);
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
		return productList;
	}
}
