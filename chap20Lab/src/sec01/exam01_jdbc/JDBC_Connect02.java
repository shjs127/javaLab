package sec01.exam01_jdbc;

import java.sql.*;

public class JDBC_Connect02 {

	public static void main(String[] args) {

		/** ORACLE JDBC Driver Test *****************************************/
		String driver = "oracle.jdbc.driver.OracleDriver";
		// String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";
		/*******************************************************************/

		/** My-SQL JDBC Driver *********************************************/
		// String driver ="com.mysql.jdbc.Driver";
		// String url = "jdbc:mysql://localhost/academy";
		/*******************************************************************/

		Connection con = null;

		try {

			Class.forName(driver);

			/** ORACLE에서 Connection 객체 ***********************************/
			con = DriverManager.getConnection(url, "SCOTT", "TIGER");
			/*******************************************************************/

			/** My-SQL에서 Connection 객체 ***********************************/
			// con = DriverManager.getConnection(url, "totoro", "1234" );
			/*******************************************************************/

			System.out.println("데이터베이스 연결 성공~!!");

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패~!!");
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
