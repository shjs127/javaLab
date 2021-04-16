package sec02.exam02_prestatement;
import java.sql.*;
import java.io.*;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 

class  JDBC_Delete01{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

  Connection con = null;
  PreparedStatement pstmt =  null;
  String sql;
  String name, email, tel ;
  int ino;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );      

      //---JDBC_Delete ����� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer ���̺��� ���ڵ� �����ϱ� .....");
      System.out.print("������ ȸ���� ȸ����ȣ�� �Է��ϼ���? ");
      ino = Integer.parseInt(br.readLine());     //���̺��� ������ name �ʵ� ���� �Է� ����
   
      // DELETE �������� �ۼ�
	  sql = "DELETE FROM customer WHERE no = ?";
	  pstmt = con.prepareStatement( sql );
	  pstmt.setInt(1, ino);	  
      int result=pstmt.executeUpdate() ;   
	  if(result==1){
		  System.out.println("ȸ�� ���� ����");
	  }else{
		  System.out.println("ȸ�� ���� ����");
	  }
      
	}catch(Exception e){
      System.out.println("�����ͺ��̽� ���� ����!");
    }
    finally{
      try{
        if( pstmt != null ) pstmt.close();
        if( con != null )  con.close();
      }
      catch(Exception e){ 
        System.out.println( e.getMessage());
      }
    }
  }
} 
