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

			/** ORACLE���� Connection ��ü ***********************************/
			con = DriverManager.getConnection(url, "SCOTT", "TIGER");
			/*******************************************************************/

			/** My-SQL���� Connection ��ü ***********************************/
			// con = DriverManager.getConnection(url, "totoro", "1234" );
			/*******************************************************************/

			System.out.println("�����ͺ��̽� ���� ����~!!");

		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����~!!");
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
