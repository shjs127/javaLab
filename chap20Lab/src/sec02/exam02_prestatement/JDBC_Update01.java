package sec02.exam02_prestatement;
import java.sql.*;
import java.io.*;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 

class  JDBC_Update01{
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

      //---JDBC_Insert �߰��� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer ���̺� �� �����ϱ� .....");
      System.out.print("������ ȸ���� ȸ����ȣ�� �Է�? ");
      ino = Integer.parseInt(br.readLine());
      
      System.out.print("������ �̸��� �Է�:");
      name = br.readLine();            //���̺� �߰��� name �ʵ� ���� �Է� ����
      System.out.print("������ �̸��� �Է�: ");
      email = br.readLine();             //���̺� �߰��� email �ʵ� ���� �Է� ����
      System.out.print("������ ��ȭ��ȣ �Է�: ");
      tel = br.readLine();               //���̺� �߰��� tel �ʵ� ���� �Է� ����     

	  sql = "UPDATE customer SET name=?,email = ?, tel = ? where no = ?";
	  pstmt = con.prepareStatement( sql );
	  pstmt.setString(1, name);
	  pstmt.setString(2, email);
	  pstmt.setString(3, tel);
	  pstmt.setInt(4, ino);
      int result=pstmt.executeUpdate(); 
      if(result==1){
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
        if( pstmt != null ) pstmt.close();
        if( con != null )  con.close();
      }
      catch(Exception e){ 
        System.out.println( e.getMessage());
      }
    }
  }
} 
