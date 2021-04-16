package sec02.exam01_statement;

import java.io.BufferedReader;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class  JDBC_Update{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

  Connection con = null;
  Statement stmt = null ;

  String sql;
  int no=0;
  String  name, email, tel ;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );
      stmt= con.createStatement();

      //---JDBC_Insert �߰��� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer ���̺� �� �����ϱ� .....");
      System.out.print("������ ȸ����ȣ�� �Է� �ϼ���?");
      no = Integer.parseInt(br.readLine());
      System.out.print("������ �̸��� �Է��ϼ���: ");
      name = br.readLine();            //���̺� �߰��� name �ʵ� ���� �Է� ����
      System.out.print("������ �̸��� �Է�: ");
      email = br.readLine();             //���̺� �߰��� email �ʵ� ���� �Է� ����
      System.out.print("������ ��ȭ��ȣ �Է�: ");
      tel = br.readLine();               //���̺� �߰��� tel �ʵ� ���� �Է� ����
      
      // INSERT �������� �ۼ�
      sql  = "UPDATE customer SET email='" + email;
	  sql += "' , tel='" + tel + "', name='"+name+ "' WHERE no = "+ no;     
      
      //Statement ��ü�� executeUpdate(sql) �޼��带 �̿��� 
      int result=stmt.executeUpdate(sql) ;  //�����ͺ��̽� ������ ������ �����Ŵ
      if(result == 1){
    	  System.out.println("������ ���� ����");
      }else{
    	  System.out.println("������ ���� ����");
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
