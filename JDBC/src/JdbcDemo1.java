import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;




public class JdbcDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean isFound = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Empno");
		String empno = scanner.nextLine();
		System.out.println("Enter the Name");
		String name = scanner.nextLine();
		// Step-1 Load the Driver
		// oracle.jdbc.driver.OracleDriver
		//org.postgresql.Driver
		String driverClassName = "com.mysql.jdbc.Driver";
		Class.forName(driverClassName);
		// Step-2 Create Connection
		//jdbc:oracle:thin:@localhost:1521:dbname
		// jdbc:mysql://localhost:3306/dbname
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc10to12","root","root");
		// Step -3 Do Query
		//Statement stmt = con.createStatement();
		//PreparedStatement pstmt = con.prepareStatement("select * from employee where empno=? and name=?");
		PreparedStatement pstmt = con.prepareStatement("insert into employee(empno,name,salary) values(?,?,?)");
		pstmt.setInt(1, Integer.parseInt(empno));
		pstmt.setString(2, name);
		pstmt.setDouble(3, 6666);
		int recordCount = pstmt.executeUpdate();
		if(recordCount>0){
			System.out.println("Record Added...");
		}
		else
		{
			System.out.println("Record Not Added....");
		}
		//ResultSet rs = pstmt.executeQuery();
		// Step - 4 Execute Query and Get the Result
		//ResultSet rs = stmt.executeQuery("select * from employee where empno="+empno);
		//ResultSet rs = stmt.executeQuery("select * from employee where empno="+empno+" and name='"+name+"'");
		/*while(rs.next()){
			isFound =true;
			System.out.println(rs.getInt("empno")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
		}
		if(!isFound){
			System.out.println("Not Found....");
		}
		// Step -5 Close all the resources
		rs.close();*/
		pstmt.close();
		//stmt.close();
		con.close();
	}

}
