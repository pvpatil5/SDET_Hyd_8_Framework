package JDBC.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class StoringDataInDatabaseTest {

	@Test
	public void storingData() throws Throwable
	{
		Connection con=null;
		try {
			//Step=1 Register the driver
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			
			//Step=3 create statement
			Statement stmt = con.createStatement();
			
			int result = stmt.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values(20, 'ram','gowda', 'h');");
			
			if(result==1)
			{
				System.out.println("Data is inserted");
			}
			else
			{
				System.out.println("Data not added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
		con.close();
		}
	}

}
