package com.srivastava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.srivastava.dto.EmployeeDTO;

// Data Access Object 
// this class contains DB Related Code
public class EmpDAO {
private Connection getConnection() throws SQLException, ClassNotFoundException{
	String driverClassName = "com.mysql.jdbc.Driver";
	Class.forName(driverClassName);
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc10to12","root","root");
	return con;
}
public ArrayList<EmployeeDTO> searchBySalary(double salary) throws SQLException, ClassNotFoundException{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<EmployeeDTO> empList = new ArrayList<>();
	try{
		con = this.getConnection();
		pstmt = con.prepareStatement("select empno,name,salary from employee where salary>"+salary);
		rs = pstmt.executeQuery();
		while(rs.next()){
			EmployeeDTO empDTO  =new EmployeeDTO();
			empDTO.setEmpno(rs.getInt("empno"));
			empDTO.setName(rs.getString("name"));
			empDTO.setSalary(rs.getDouble("salary"));
			empList.add(empDTO);
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
	return empList;
	
}

}
