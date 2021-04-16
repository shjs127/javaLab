package sec02.exam02_timestamp;
import java.io.BufferedReader;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class  JDBC_Delete02{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

  Connection con = null;
  PreparedStatement pstmt =  null;
  String sql;
  int no;
  String name, email, tel ;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );      

      //---JDBC_Delete ����� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer ���̺��� ���ڵ� �����ϱ� .....");
      System.out.print("������ ȸ�� ��ȣ�� �Է��ϼ���: ");
      no = Integer.parseInt(br.readLine());     //���̺��� ������ name �ʵ� ���� �Է� ����
   
      // DELETE �������� �ۼ�
	  sql = "DELETE FROM customer WHERE no = ?";
	  pstmt = con.prepareStatement( sql );
	  pstmt.setInt(1, no);	  
      int result=pstmt.executeUpdate() ;   
      if(result == 1){
  		 System.out.println(" ������ ���� ����!! ");
        }else{
  		 System.out.println(" ������ ���� ���� ");
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
