package sec01.exam01_jdbc;

import java.sql.*;

public class JDBC_Connect01 {

	public static void main(String[] args) {

		/** ORACLE JDBC Driver Test ***************************/
		String driver = "oracle.jdbc.driver.OracleDriver";
		/******************************************************/

		/** My-SQL JDBC Driver Test **************************/
		// String driver ="com.mysql.jdbc.Driver";
		/*****************************************************/

		try {
			//oracle db접속을 위한 클래스를 jvm에 로딩한다.
			Class.forName(driver);
			System.out.println("JDBC Driver Loading 성공~!!");

		} catch (Exception e) {
			System.out.println("JDBC Driver Loading 실패~!!");
			e.printStackTrace();
		}
	}
}
