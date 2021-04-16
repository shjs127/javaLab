package sec02.exam01_statement;

import java.sql.*;
import java.io.*;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 

class  JDBC_Insert{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";	

  Connection con = null;
  Statement stmt = null;

 // ResultSet  rs   = null;
  String sql;

   String name, email, tel, no ;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );
      stmt= con.createStatement();

      //---JDBC_Insert �߰��� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println(" customer ���̺� �� �Է��ϱ� .....");
      System.out.print(" ��ȣ �Է�: ");
      no = br.readLine();
      System.out.print(" �̸� �Է�: ");
      name = br.readLine();            //���̺� �߰��� name �ʵ� ���� �Է� ����
      System.out.print(" �̸��� �Է�: ");
      email = br.readLine();             //���̺� �߰��� email �ʵ� ���� �Է� ����
      System.out.print(" ��ȭ��ȣ �Է�: ");
      tel = br.readLine();               //���̺� �߰��� tel �ʵ� ���� �Է� ����
      
      // INSERT �������� �ۼ�
      sql = "INSERT into customer(no, name, email, tel) values " ;
      sql += "(" + no + ",'" + name +"','" + email +"','"+ tel +"')" ;
      
      //Statement ��ü�� executeUpdate(sql) �޼��带 �̿��� 
      int res = stmt.executeUpdate(sql) ;  //�����ͺ��̽� ���Ͽ� ���ο� ���� �߰���Ŵ
	  if(res == 1){
		 System.out.println(" Data insert success!! ");
      }else{
		System.out.println(" Data insert failed ");
	  }
	}
    catch(Exception e){
      System.out.println("�����ͺ��̽� ���� ����!");
    }
    finally{
      try{
 //       if( rs != null )   rs.close();        
        if( stmt != null ) stmt.close();
        if( con != null )  con.close();
      }
      catch(Exception e){ 
        System.out.println( e.getMessage());
      }
    }
  }
} 
