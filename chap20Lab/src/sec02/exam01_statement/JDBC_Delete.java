package sec02.exam01_statement;

import java.io.BufferedReader;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class  JDBC_Delete{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

  Connection con = null;
  Statement stmt = null ;
  String sql;
  int no;
  String name, email, tel ;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );
      stmt= con.createStatement();

      //---JDBC_Delete ����� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer ���̺��� ���ڵ� �����ϱ� .....");
      System.out.print("������ ȸ����ȣ�� �Է��ϼ���: ");
      no = Integer.parseInt(br.readLine());     //���̺��� ������ name �ʵ� ���� �Է� ����
   
      // DELETE �������� �ۼ�
      sql  = "DELETE FROM customer WHERE no ="+no;     
      
      //Statement ��ü�� executeUpdate(sql) �޼��带 �̿��� 
      int result=stmt.executeUpdate(sql) ;  //�����ͺ��̽� ���Ͽ��� ���ڵ� ������Ŵ
      if(result == 1){
    	  System.out.println("ȸ������ ����");
      }else{
    	  System.out.println("ȸ������ ����");
      }
     }
    catch(Exception e){
      System.out.println("�����ͺ��̽� ���� ����!");
    }
    finally{
      try{
        if( stmt != null ) stmt.close();
        if( con != null )  con.close();
      }
      catch(Exception e){ 
        System.out.println( e.getMessage());
      }
    }
  }
} 
